set JAVA_HOME=c:\opt\jdk
call gradlew jar %*

echo "====jar running start =="
java -jar build/libs/scalaconsole-all.jar
echo "====jar running end =="