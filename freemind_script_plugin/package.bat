set GROOVY_HOME=C:\opt\groovy-1.8.0
set GRADLE_HOME=D:\Tooldev\gradle-1.0-milestone-3
set JAVA_HOME=c:\opt\jdk
set ANT_HOME=D:\Tooldev\ant

set PATH=%GROOVY_HOME%/bin;%GRADLE_HOME%/bin;%JAVA_HOME%/bin;%ANT_HOME%/bin

set JAVA_OPTS=-Dgroovy.source.encoding=UTF-8 -Dfile.encoding=UTF-8


call gradle clean jar %*
