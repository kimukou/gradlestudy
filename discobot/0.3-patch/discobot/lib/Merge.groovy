import org.apache.commons.io.FileUtils
import org.apache.tools.ant.Project
import org.apache.tools.ant.ProjectHelper
import java.util.zip.ZipInputStream
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream
import java.util.zip.ZipEntry

class Merge{
    public static void main(String[] args){
        def config = [groovy_src:"groovy-core",
		    discobot_src:"discobot-patches",
		    dest:"mixer",
		    cwd:System.getProperty("user.dir"),
		    clean:false,
		    copy:false,
		    simulate:false,
		    test:false,
		    android_path:Util.getAndroidPath()]

        //This is the commandqueue the commands in this list
        //are executed only if no errors are detected
        def commands = []
        def fail = false

        //Parse commandline arguments
        args.each {
            if(config.containsKey(it)){
                config[it] = true
            }else{
                println "Unknown argument: " + it
                System.exit(-1)
            }
        }

	if(!Util.verifyAndroidPath(config["android_path"])) System.exit(-1)

        if(config["clean"]){
            println "Cleaning."
            FileUtils.cleanDirectory(new File(config["cwd"], config["dest"]))
        }

        //copy original groovy files
        if(config["copy"] || config["clean"]){
            commands << ["copydir",new File(config["groovy_src"]),new File(config["dest"])]

            //Copy the android jar
	    def andJar  = Util.strToFile(config["android_path"] + "platforms/android-4/android.jar")
	    def andDest = Util.strToFile(config["dest"] + "/target/lib/compile/android.jar")
            commands << ["copyAndroidJar",andJar ,andDest]
        }

        //load commands
        fail |= parseCommandFile(new File("commands.cmd"), commands)

        //verify patches and queue the copy commands
        if(!fail) fail |= new PatchMerger(config, commands).exec()

        //If everything is ok, execute all commands in the commandqueue
        if(!fail) fail |= execCommands(commands, config)

        if(fail) System.exit(-1)

    }

    private static boolean parseCommandFile(def f, def commands){
        println "Parsing commandfile.."
        int cmd = commands.size
        FileUtils.readLines(f).each {
            def parts = it.split(":")
            switch(parts[0]){
            case "rmdir":
            case "remove":
                commands << [parts[0], parts[1]]
                break
            }
        }
        println "\t${commands.size() - cmd} commands parsed."
        return false
        }

        private static boolean execCommands(def commands, def config){
        println "\nExecuting..."
        def simulate = config["simulate"]
        commands.each {
            switch(it[0]){
            case "copy":
                println "Copying: "
                println "\tFrom:\t" + it[1]
                println "\tTo:\t" + it[2]
                if(!simulate) FileUtils.copyFile(it[1], it[2])
                break
            case "copydir":
                println "Copying directory:"
                println "\tFrom:\t" + it[1]
                println "\tTo:\t" + it[2]
                if(!simulate) FileUtils.copyDirectory(it[1],it[2])
                break
            case "remove":
                println "Removing file: " + new File(config["dest"],it[1])
                if(!simulate) new File(config["dest"],it[1]).delete()
                break
            case "rmdir":
                println "Removing dir: " + new File(config["dest"],it[1])
                if(!simulate) FileUtils.deleteDirectory(new File(config["dest"],it[1]))
                break
            case "copyAndroidJar":
                println "Copying android.jar"
                if(!simulate) copyAndroidJar(it[1],it[2])
                break
            }
        }
        println "Done"
    }

    /**
     * Copies the android jar and removes junit from it in the process
     *
     */
    public static void copyAndroidJar(File from, File to){
        def inFile = new ZipFile(from, ZipFile.OPEN_READ)
        FileUtils.touch(to)
        def out = new ZipOutputStream(new FileOutputStream(to))
        for(ZipEntry ze: inFile.entries()){
            if(!ze.getName().startsWith("junit")){
                def instream = inFile.getInputStream(ze)
                out.putNextEntry(new ZipEntry(ze.getName()))
                byte[] buff = new byte[ze.getSize()]
                instream.read(buff, 0, buff.length)
                out.write(buff,0, buff.length)
            }
        }

        inFile.close()
        out.close()
    }
}
