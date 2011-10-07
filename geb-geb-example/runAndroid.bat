call ../setEnvGG.bat


::start emulator -avd my_android  -no-window -no-audio -no-boot-anim
start emulator -avd my_android  -no-audio -no-boot-anim

echo "waiting emurator rised..."
pause 

adb -e install -r  apk\android-server-2.6.0.apk

::
:: apk start
::
:: see http://code.google.com/p/selenium/source/browse/trunk/android/app/AndroidManifest.xml
::     http://d.hatena.ne.jp/Kazzz/20100909/p1
::
:: check for http://localhost:8080/wd/hub/status/ shown
adb shell am start -n org.openqa.selenium.android.app/.MainActivity

adb forward tcp:8080 tcp:8080

::pause

gradle clean androidTest -DandroidTest.single=OneTest


:: see http://code.google.com/p/selenium/wiki/AndroidDriver
::
:: Install Android WebDriver on Real Device
:: Connect your device through USB to your machine.
:: 
:: $~/android_sdk/platform-tools/adb devices
:: This will give you the serial Id of your connected device. Now install the apk on the device:
:: 
:: $./adb -s <serialId> -e install -r android-server.apk
:: Setup port forwarding:
:: 
:: $~/android_sdk/adb -s <serialId> forward tcp:8080 tcp:8080
