set JAVA_HOME=c:\opt\jdk
set APPENGINE_HOME=D:\Tooldev\appengine-java-sdk-1.4.3

:: see http://code.google.com/intl/ja/appengine/docs/java/tools/uploadinganapp.html

set APPENGINE_OPTION=--email=kimukou.buzz@gmail.com


%APPENGINE_HOME%/bin/appcfg.cmd %APPENGINE_OPTION% update war
