call ../setEnvGG.bat


echo "need prepare 'android' command and emurator running"
call gradle configureDebug androidInstall %1
