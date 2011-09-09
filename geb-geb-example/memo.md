ChromeDriverに関するメモ）

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
	ChromiumPortableをバイナリ位置指定で使えるかどうか?
		http://code.google.com/p/selenium/wiki/ChromeDriver#Overriding_the_Chrome_binary_location

	ChromePortableはライセンス的に再配布は難しいみたい(Google Chrome自体が)
	＜Google系のソフトは再配布は基本認めていないよう
