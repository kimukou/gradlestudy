set JAVA_HOME=c:\opt\jdk
set APPENGINE_HOME=D:\Tooldev\appengine-java-sdk-1.4.3

:: see http://code.google.com/intl/ja/appengine/docs/java/tools/devserver.html

%APPENGINE_HOME%/bin/dev_appserver.cmd --port=9090 --disable_update_check war
