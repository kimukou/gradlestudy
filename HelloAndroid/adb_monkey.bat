for /F "delims=" %%s in ('cd') do @set PWD=%%s

::set ANT_HOME=D:/Tooldev/ant
set JAVA_HOME=c:\opt\jdk
set ANDROID_HOME=D:/Tooldev/android-sdk-windows
set PATH=%ANT_HOME%/bin;%JAVA_HOME%/bin;%ANDROID_HOME%/platform-tools;%ANDROID_HOME%/tools

::see http://erlang.web.fc2.com/monkeyrunner/
::set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8

call monkeyrunner %PWD%/monkeytest.py

pause
