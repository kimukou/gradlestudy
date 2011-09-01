call ../setEnvGG.bat


call gradle -b gae-build.gradle gaeUpload %*

