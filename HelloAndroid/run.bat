call ..\setEnvGG.bat

set JAVA_HOME=C:\opt\jdk
::gradlew clean configureDebug androidInstall
gradlew clean configureDebug androidInstall --debug > hogehoge.txt 2>&1
