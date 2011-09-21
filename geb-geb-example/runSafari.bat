set JAVA_HOME=c:\opt\jdk
set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8

start %JAVA_HOME%/bin/java -jar libsv\selenium-server-standalone-*.jar

gradlew -Dtest=src/test/groovy/GoogleSpec.groovy clean safariTest

