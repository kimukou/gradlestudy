set GRADLE_HOME=D:\Tooldev\gradle-1.0-m1
set JAVA_HOME=c:\opt\jdk

set PATH=%GRADLE_HOME%/bin;%JAVA_HOME%/bin


::call gradle clean jar
call gradle jar

echo "====jar running start =="
java -jar build/libs/msgpack.jar
echo "====jar running end =="
