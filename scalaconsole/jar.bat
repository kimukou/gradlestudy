set JAVA_HOME=c:\opt\jdk
call gradlew jar %*

echo "====jar running start =="
%JAVA_HOME%/bin/java -jar build/libs/scalaconsole-all.jar
echo "====jar running end =="