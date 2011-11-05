Driverに関するメモ）

ChromDriverの入手先
	http://chromium.googlecode.com/

Windows
	コンピュータの設定を「パフォーマンスを優先にする」にしておかないと
	TimeOutException等が出る事がある

	何度も実行しているとChromeのプロセスが大量に終了していない時がある
	＜cleanしてから再実行しないとSUCESSがでてもブラウザが実行しないパターンも

	Pageを相対パスで指定したい場合は
	下記のように環境変数でgeb.build.baseUrlを設定する

	environments {
		def baseurl = "http://localhost:8080/ectest/"
		System.setProperty("geb.build.baseUrl",baseurl)

		なんか環境変数の設定がGebConfig.groovy上で遣らないと
		Driver初期化系の時の状態に影響しない


調査したい項目）
済) ChromiumPortableをバイナリ位置指定で使えるかどうか?
		http://code.google.com/p/selenium/wiki/ChromeDriver#Overriding_the_Chrome_binary_location

	ChromePortableはライセンス的に再配布は難しいみたい(Google Chrome自体が)
	＜Google系のソフトは再配布は基本認めていないよう

	ChromePortableカスタマイズ)
		ChromiumPortable\App\AppInfo\Launcher
		ChromiumPortable.ini

#CommandLineArguments=--disk-cache-dir="%Temp%\Cache"
CommandLineArguments=--enable-extensions --disk-cache-dir="PortableGoogleChrome\Cache" --app=file:///../startup/startup.html --start-maximized


OperaDriver
	ここからコンパイル
		https://github.com/operasoftware/operadriver/

	Win7,VistaだとC:\Program Files配下にはインストールしてはいけないらしい
	(設定するとプロファイルがセキュリティ違反で見れないとのこと)
	したがって今回は D:\ToolDev\opera にインストールしたとして設定
	(インストール開始時に、オプションでインストール先を変える事)


SafariDriver
	ここからコンパイル？（macしかできないかも）
		https://github.com/shs96c/webdriver

	remote dirverで試す
		http://darrellgrainger.blogspot.com/2011/02/using-selenium-20-with-webdriver-and.html

AndroidDriver
	課題系
		http://code.google.com/p/selenium/wiki/AndroidDriver

