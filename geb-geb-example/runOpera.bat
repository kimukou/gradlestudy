::call ../setEnvGG.bat
::gradle operaTest

set JAVA_HOME=c:\opt\jdk
set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8
gradlew clean operaTest
