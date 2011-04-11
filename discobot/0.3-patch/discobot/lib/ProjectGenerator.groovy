import org.apache.commons.io.FileUtils

class ProjectGenerator {
    //simple files and dirs that exsist in the project directory
    static def filterList = ["build.xml", "AndroidManifest.xml", "default.properties", 
                             "ant_cmp.sh", "ant_cmp.bat"]//2011/04/08 kimukou_26 append file
    static def dirList = ["libs", "res", "tools"]

    //The parser states, these would be inside a enum if i could have
    //a function that returned them
    final static def NONE = 0
    final static def PATH = 1
    final static def PACKAGE =2

    public static void main(String[] args){
        def config = parseArgs(args)
        if(!config["path"] || !config["name"] || !config["package"]) helpAndExit()

        config["sdk"] = Util.getAndroidPath()
        if(!config["sdk"]){
            println "Could not locate the android sdk, please set this parameter in project.conf"
            System.exit(0)
        }

        def discoJar = new File(new File(".", "dist"), "discobot.jar")
        if(!discoJar.exists()){
            println "Could not find discobot.jar please build the project first,"
            println "or make sure your running this script from the discobot directory."
            System.exit(-1)
        }

        def fromDir = new File(".", "discobot-project")
        def destDir = new File(config["path"])

        //check if the destination already exsists
        if(!config["force"] && destDir.exists()){
            println "Error: The directory " + destDir + " already exists"
            println "\tUse -force to override this check"
            System.exit(-1)
        }

        //Create the project dir, and the subdirs
        destDir.mkdirs()
        dirList.each {
            new File(destDir, it).mkdir()
        }

        //Copy and filter the root files
        filterList.each {
            filterFile(new File(fromDir, it), new File(destDir, it), config)
        }

        //strings.xml is slightly special
        def values = new File(new File(destDir, "res"), "values")
        filterFile(new File(fromDir,"strings.xml"), new File(values, "strings.xml"), config)

        //Create the programs main(entry) file
        def srcDir = new File(destDir, "src")
        config["package"].split("\\.").each {srcDir = new File(srcDir, it)}
        srcDir.mkdirs()
        filterFile(new File(fromDir,"SourceFile.groovy"), new File(srcDir, config["name"] + ".groovy"), config)

        //Copy the discobot jar into the project folder
        FileUtils.copyFileToDirectory(discoJar, new File(destDir, "libs"))
    }

    private static void filterFile(File from, File to, def config){
        println "Filter:"
        println "\tFrom:" + from
        println "\tTo:" + to
        if(!to.exists()) FileUtils.touch(to)

        config["api"] = Util.getTargetPath()  //2011/04/07 kimukou_26 add
        to.withPrintWriter {writer->
            from.eachLine {
                def str = it.replace((CharSequence)"%%app-name%%", config["name"])
                str = str.replace((CharSequence)"%%android-sdk%%", config["sdk"])
                str = str.replace((CharSequence)"%%target-api%%", config["api"]) //2011/04/07 kimukou_26 add
                str = str.replace((CharSequence)"%%app-package%%", config["package"])

                writer << str + "\n"
            }
        }
    }

    private static void helpAndExit(){
        println "You need to specify both -path and -name."
        println "Example:"
        println "\t./mkProject.sh -path /home/user/projects/hello -name org.dance.Hello"
        System.exit(0)
    }

    private static def parseArgs(String[] args){
        def ret = [:]

        def state = NONE

        args.each {
            switch(state){
            case NONE:
                state = getState(it, ret)
                break
            case PATH:
                ret["path"] = it
                state = NONE
                break
            case PACKAGE:
                def dot = it.lastIndexOf(".")
                def name = it.substring(dot + 1)
                def pack = it.substring(0, dot)
                println "Name: " + name + " Package: " + pack
                ret["package"] = pack
                ret["name"] = name
                state = NONE
                break
            }
        }
        return ret
    }

    private static int getState(String s, def config){
        switch(s){
            case "-force":
                config["force"] = true
                return NONE
            case "-path":
                return PATH
            case "-name":
                return PACKAGE
            default:
                println "Illegal argument: " + s
                System.exit(0)
        }
    }
}