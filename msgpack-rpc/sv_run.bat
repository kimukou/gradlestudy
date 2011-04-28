set GRADLE_HOME=D:\Tooldev\gradle-1.0-milestone-3
set JAVA_HOME=c:\opt\jdk

set PATH=%GRADLE_HOME%/bin;%JAVA_HOME%/bin


call gradle -b sv_build.gradle
