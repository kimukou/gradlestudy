export APPENGINE_HOME=../../appengine-java-sdk-1.7.3
#:: see http://code.google.com/intl/ja/appengine/docs/java/tools/devserver.html

$APPENGINE_HOME/bin/dev_appserver.sh --port=9090 --disable_update_check war
