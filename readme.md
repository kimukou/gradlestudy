need enviroments 

	jdk6u24
	gradlew.bat or sh gradlew
		or
	jdk6u24
	gradle milestorne 1 http://www.gradle.org/


1. HelloAndroid
	testing windows only

	gradle android plugin test

	need android sdk
	■prepare
		keygen.bat(debug key)
		password set:android
	
		android create avd --name myAVD --target 1
	
	■running
	1)adb_lunch.bat
		android emurator running
	
	2)apk_install.bat

2. msgpack
		run.bat
3. msgpack-rpc
		a)gradlew.bat -b sv_build.gradle
		b)gradlew.bat -b cl_build.gradle
				or
		a)sv_run.bat first
		b)cl_run.bat second

