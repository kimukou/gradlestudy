call ../setEnvGG.bat

:: see http://code.google.com/intl/ja/appengine/docs/java/tools/devserver.html

%APPENGINE_HOME%/bin/dev_appserver.cmd --port=9090 --disable_update_check src/main/webapp
