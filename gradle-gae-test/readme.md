>GAE login

runnning 
	1. https://appengine.google.com/
		SDK download
	2. http://gaelyk.appspot.com/download
		Template project v0.7 download
	3. unzip
		gaelyk-template-project-0.7.zip

	4. appid edif
		edit myappid => change app id
		WEB-INF\appengine-web.xml(2):     <application>myappid</application>

	5. gae_run.bat or run.bat execute

upload
	1. gae_upload.bat or upload.bat
		watch http://gradle-gae-test.appspot.com/
	*) E_MAIL define
		gradle.properties
