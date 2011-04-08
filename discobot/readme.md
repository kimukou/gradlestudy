reference doc 
	http://d.hatena.ne.jp/uehaj/20100515/1273934021

------------------------------------------------------------------
testing enviroments)
	CentOS 5.5 32bit

need enviroments)
	co /opt

	jdk6
		sh jdk-6u24-linux-i586.bin
		mv jdk-6u24-linux-i586 jdk
	groovy
		wget http://dist.groovy.codehaus.org/distributions/groovy-binary-1.7.10.zip
		unzip groovy-binary-1.7.10.zip
		mv groovy-binary-1.7.10.zip groovy
	ant
		wget http://www.meisei-u.ac.jp/mirror/apache/dist//ant/binaries/apache-ant-1.8.2-bin.tar.gz
		tar -xvzf apache-ant-1.8.2-bin.tar.gz
		mv apache-ant-1.8.2 ant
	maven
		wget http://ftp.riken.jp/net/apache//maven/binaries/apache-maven-3.0.3-bin.tar.gz
		tar -xvzf apache-maven-3.0.3-bin.tar.gz
		mv apache-maven-3.0.3 maven
	android-sdk
		wget http://dl.google.com/android/android-sdk_r10-linux_x86.tgz
		tar -xvzf android-sdk_r10-linux_x86

	option nessesary
			tools/android update sdk (need GUI Console)
			android list check-path(ANDROID_HOME/platforms/ into directory)

			id: 4 or "android-4"
			     Name: Android 1.6
			     Type: Platform
			     API level: 4
			     Revision: 3
			     Skins: WVGA854, QVGA, WVGA800 (default), HVGA


discobot source)
	wget http://discobot.googlecode.com/files/discobot-0.3.tar.gz


edit setting)
	edit discobot/project.conf
		android-folder:/opt/android-sdk-linux_x86
		target-api:android-4

■compile)
	sh ./package.sh

	unless 
		vi ~/.bashrc
			export ANT_HOME=/opt/ant
			export MAVEN_HOME=/opt/maven
			export JAVA_HOME=/opt/jdk
			export GROOVY_HOME=/opt/groovy
			export ANDROID_HOME=/opt/android-sdk-linux_x86
			export PATH=$PATH:$ANDROID_HOME/tools:$JAVA_HOME/bin:$GROOVY_HOME/bin:$ANT_HOME/bin:$MAVEN_HOME/bin
	need
	  source ~/.bashrce

//-------------------------------------------------------------
■create-project)

cd discobot
./mkProject.sh -path ~/proj -name org.jggug.sample.Main


cd ~/pro
sh ./ant_cmp.sh
	need ant,maven,java path root

//-------------------------------------------------------------
ls -la bin/*.apk
android create avd --name myAVD --target 4
emulator -avd myAVD
adb install bin/Main-debug.apk
