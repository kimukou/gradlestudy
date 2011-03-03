set JAVA_HOME=c:\opt\jdk
set PATH=%JAVA_HOME%/bin

echo "android type"
keytool -list -keystore "%USERPROFILE%/.android/debug.keystore"
