set ANT_HOME=D:/Tooldev/ant
set JAVA_HOME=c:\opt\jdk
set ANDROID_HOME=D:/Tooldev/android-sdk-windows
set PATH=%ANT_HOME%/bin;%JAVA_HOME%/bin;%ANDROID_HOME%/platform-tools;%ANDROID_HOME%/tools

::see http://www.neko.ne.jp/~freewing/android/android/
::    http://dev.ariel-networks.com/Members/iwanaga/android-intro/


::create emurator
:: android list
:: 
:: android create avd --name myAVD --target 1

::run emurator
call emulator -avd myAVD
