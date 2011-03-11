set JAVA_HOME=c:\opt\jdk
set PATH=%JAVA_HOME%/bin

echo "android type keyStorePassword and  keyAliasPassword"
keytool -genkey -alias androiddebugkey -keystore debug.keystore

