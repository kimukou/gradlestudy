set ANT_HOME=D:/Tooldev/ant
set JAVA_HOME=c:\opt\jdk
set ANDROID_HOME=D:/Tooldev/android-sdk-windows
set PATH=%ANT_HOME%/bin;%JAVA_HOME%/bin;%ANDROID_HOME%/platform-tools;%ANDROID_HOME%/tools

::see http://www.neko.ne.jp/~freewing/android/android/
::    http://dev.ariel-networks.com/Members/iwanaga/android-intro/

::need edit!! 0_anddroid_list.bat check no
set TARGET_ID=3


::create emurator
::android list
:: id:XX check set target num
android create avd --name myAVD --target %TARGET_ID% -f -s HVGA
