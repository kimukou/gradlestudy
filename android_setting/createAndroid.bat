::sdk.dir = D:/Tooldev/android-sdk-windows
set ANDROID_HOME=D:/Tooldev/android-sdk-windows
set JAVA_HOME=c:\opt\jdk

set PATH=%ANDROID_HOME%/tools;%JAVA_HOME%/bin


::D:\Tooldev\android-sdk-windows\platforms place check

android create project -t android-4 -p HelloAndroid -k org.example.hello -a Hello
