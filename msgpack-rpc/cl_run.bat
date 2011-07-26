call ../setEnvGG.bat

call gradlew -b cl_build.gradle
:call gradle -b cl_build.gradle
