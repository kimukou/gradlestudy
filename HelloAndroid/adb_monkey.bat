call ../setEnvGG.bat

for /F "delims=" %%s in ('cd') do @set PWD=%%s

::see http://erlang.web.fc2.com/monkeyrunner/
::set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8

::call monkeyrunner %PWD%/monkeytest.py
call monkeyrunner %PWD%/monkey_rec_test.py

pause
