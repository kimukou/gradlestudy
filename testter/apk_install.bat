set GRADLE_HOME=D:\Tooldev\gradle-1.0-milestone-3
set JAVA_HOME=c:\opt\jdk
set ANDROID_HOME=D:/Tooldev/android-sdk-windows

set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8
set PATH=%GRADLE_HOME%/bin;%JAVA_HOME%/bin;%ANDROID_HOME%/platform-tools;%ANDROID_HOME%/tools


echo "need prepare 'android' command and emurator running"
call gradle configureDebug androidInstall %1
