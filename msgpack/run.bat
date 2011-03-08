set GROOVY_HOME=C:\opt\groovy-1.7.8
set GRADLE_HOME=D:\Tooldev\gradle-1.0-m1
set JAVA_HOME=c:\opt\jdk

set PATH=%GROOVY_HOME%/bin;%GRADLE_HOME%/bin;%JAVA_HOME%/bin


call gradle clean jar

java -jar build/libs/msgpack.jar
