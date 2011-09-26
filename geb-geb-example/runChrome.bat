::call setEnvG9.bat
::gradle chromeTest

::taskkill /F /IM chromedriver.exe
::taskkill /F /IM chrome.exe
::.\exe\taskkill0 /F /IM chromedriver.exe
::.\exe\taskkill0 /F /IM chrome.exe


set JAVA_HOME=c:\opt\jdk
set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8
::gradlew chromeTest
::gradlew clean chromeTest
gradlew -DchromeTest.single=GoogleTest clean chromeTest

