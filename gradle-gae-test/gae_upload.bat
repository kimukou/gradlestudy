set GRADLE_HOME=D:\Tooldev\gradle-1.0-milestone-3
set JAVA_HOME=c:\opt\jdk
set APPENGINE_HOME=D:\Tooldev\appengine-java-sdk-1.5.0

set PATH=%GRADLE_HOME%/bin;%JAVA_HOME%/bin;%APPENGINE_HOME%/bin


call gradle -b gae-build.gradle gaeUpload %*

