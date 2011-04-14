export ANT_HOME=/opt/ant
export MAVEN_HOME=/opt/maven
export JAVA_HOME=/opt/jdk
export GROOVY_HOME=/opt/groovy
export ANDROID_HOME=%%android-sdk%%
export PATH=$PATH:$ANDROID_HOME/tools:$JAVA_HOME/bin:$GROOVY_HOME/bin:$ANT_HOME/bin:$MAVEN_HOME/bin

export CLASSPATH=libs/discobot.jar
ant
