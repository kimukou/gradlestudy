set GRADLE_HOME=D:\Tooldev\gradle-1.0-m1
set JAVA_HOME=c:\opt\jdk

set PATH=%GRADLE_HOME%/bin;%JAVA_HOME%/bin


call gradle -b cl_build.gradle
