set ANT_HOME=D:/Tooldev/ant
set JAVA_HOME=c:\opt\jdk
set ANDROID_HOME=D:/Tooldev/android-sdk-windows
set PATH=%ANT_HOME%/bin;%JAVA_HOME%/bin;%ANDROID_HOME%/platform-tools;%ANDROID_HOME%/tools


ant debug
::ant release
::call emulator -avd myAVD
::adb install ./bin/Hello-debug.apk