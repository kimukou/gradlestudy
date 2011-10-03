::call ../setEnvGG.bat
::gradle safariTest

set JAVA_HOME=c:\opt\jdk
set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8

start %JAVA_HOME%/bin/java -jar libsv\selenium-server-standalone-*.jar

gradlew -DsafariTest.single=GoogleSpec clean safariTest

