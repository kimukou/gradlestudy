call ../setEnvGG.bat

:: see http://code.google.com/intl/ja/appengine/docs/java/tools/uploadinganapp.html

set APPENGINE_OPTION=--email=kimukou.buzz@gmail.com


%APPENGINE_HOME%/bin/appcfg.cmd %APPENGINE_OPTION% update src/main/webapp
