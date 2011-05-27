# -*- coding: utf-8 -*-

# monkeyrunnerモジュールのインポート
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# デバイスに接続し、MonkeyDeviceオブジェクトを返します。
device = MonkeyRunner.waitForConnection()

# パッケージのインストール
# このメソッドがtrueを返したなら、インストールは成功です。
device.installPackage('bin/Hello-debug.apk')

# Activityの起動
#device.startActivity(component='org.example.hello.Hello')

package = 'org.example.hello'
activity = 'org.example.hello.Hello'
runComponent = package + '/' + activity
device.startActivity(component=runComponent)

# メニューキーの押下
device.press('KEYCODE_MENU','DOWN_AND_UP')

# スクリーンショットの取得
result = device.takeSnapshot()

# スクリーンショットの書き出し
result.writeToFile('shot1.png','png')
