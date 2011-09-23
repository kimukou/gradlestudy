call ../setEnvGG.bat

::set GRADLE_OPTS="-Xms1024m -Xmx1024m"
::set JAVA_OPTS="-Xms1024m -Xmx1024m"

call gradle clean
::call gradle androidPackage
::call gradle configureDebug assemble
call gradle configureDebug androidInstall
::call gradle androidInstall
