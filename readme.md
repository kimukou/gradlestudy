need enviroments 
	jdk6u24
	gradlew.bat or sh gradlew
		or
	jdk6u24
	gradle milestorne 1 http://www.gradle.org/


0. android enviroments
	need android sdk
	■prepare
		keygen.bat(debug key)
		password set:android

		android_setting
			0_anddroid_list.bat
				check android 1.6 target id
			1_create_adb.bat
				need edit target id

		android_setting(option)

	reference 
		http://d.hatena.ne.jp/waman/20110228/1298856326
		http://d.hatena.ne.jp/waman/20110303/1299103140


1. HelloAndroid
	gradle android plugin test
	
	■running
	1)adb_lunch.bat
		android emurator running
	
	2)apk_install.bat
	3)apk_uninstall.bat
		
---------------------------------------------------------------------
2. msgpack
		run.bat
3. msgpack-rpc
		a)gradlew.bat -b sv_build.gradle
		b)gradlew.bat -b cl_build.gradle
				or
		a)sv_run.bat first
		b)cl_run.bat second

---------------------------------------------------------------------
4. tester gradle setting
		gradle android plugin test

		4.1 see https://sites.google.com/site/androidtestclub/testter
				download GoogleCode
		
		4.2	Twitter devkey get
				https://dev.twitter.com/apps/

				refarence)
					http://archais.me/archives/21
				
		4.3	res/raw/config.properties create
				twitter.consumer=
				twitter.secret=

		4.4	copy to tester into master code

