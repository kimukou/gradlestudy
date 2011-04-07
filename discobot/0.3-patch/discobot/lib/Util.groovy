import org.apache.commons.io.FilenameUtils

class Util{
    public static def getAndroidPath(){
        def f = new File(System.getProperty("user.dir"), "project.conf")
        if(f.exists()){
            for(String s: f.readLines()){
                def parts = s.split(":")
                if(parts.size() == 2 && parts[0] == "android-folder"){
                    //make sure that path ends with a slash
								    if(parts[1].charAt(parts[1].length() -1) != '/') parts[1] += "/"
		  						  return parts[1]
                }
            }
       }
       return null
    }

//2011/04/07 kimukou_26 add start
    public static def getTargetPath(){
        def f = new File(System.getProperty("user.dir"), "project.conf")
        if(f.exists()){
            for(String s: f.readLines()){
                def parts = s.split(":")
                if(parts.size() == 2 && parts[0] == "target-api"){
                    //make sure that path ends with a slash
								    if(parts[1].charAt(parts[1].length() -1) != '/') parts[1] += "/"
		  						  return parts[1]
                }
            }
       }
       return null
    }
//2011/04/07 kimukou_26 add end


    public static def verifyAndroidPath(String path){
        def lookFor = ["tools/apkbuilder",
                        "platforms/android-1.6/android.jar",
                        "platforms/android-1.6/tools/dx",
                        "platforms/android-1.6/tools/aapt"]
        def retval = true

        lookFor.each {
            if(!Util.strToFile(path + it).exists() && !Util.strToFile(path + it + ".exe").exists()){
                retval = false;
                println "Could not locate " + it
            }
        }

        if(!retval){
            println "Make sure that you have conigured the android path correctly."
        }

        return retval
    }

    public static def strToFile(def s){
        return new File(FilenameUtils.separatorsToSystem(s))
    }
}
