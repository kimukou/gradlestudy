need enviroments 
	jdk6u26
	gradlew.bat or sh gradlew
		or
	jdk6u26
	gradle milestorne 1 http://www.gradle.org/

gradle users documents
	release page  http://www.gradle.org/
	english  http://www.gradle.org/current/docs/userguide/userguide_single.html
	japanise http://www.monochromeroad.com/artifacts/gradle/userguide/userguide.html

---------------------------------------------------------------------
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
			https://github.com/jvoegele/gradle-android-plugin

	■running
	0-1	adb_lunch.bat
			android emurator running
	
	0-2	apk_install.bat
	0-3	apk_uninstall.bat

---------------------------------------------------------------------
2. msgpack
		run.bat
			or
		gradlew.bat / gradlew (need java)

3. msgpack-rpc

		a)gradlew.bat -b sv_build.gradle
		b)gradlew.bat -b cl_build.gradle
				or
		a)sv_run.bat first
		b)cl_run.bat second

---------------------------------------------------------------------
4. tester gradle setting

	gradle android plugin test
			https://github.com/jvoegele/gradle-android-plugin

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


---------------------------------------------------------------------
5. Gaelyk gradle setting
	gradle-gae-test

6. gradle-gae-test chromeDriver running & capture(use windows)
	geb-example-gradle
		https://github.com/geb/geb-example-gradle

	edit setting
		http://d.hatena.ne.jp/tanamon/20090417/1239941367
		http://d.hatena.ne.jp/w650/20110825/1314280671

