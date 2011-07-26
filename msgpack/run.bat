call ../setEnvGG.bat

::call gradle clean jar
::call gradle jar %*
call gradlew jar %*

echo "====jar running start =="
java -jar build/libs/msgpack.jar
echo "====jar running end =="
