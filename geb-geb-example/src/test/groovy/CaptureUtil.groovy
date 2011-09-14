
class CaptureUtil{

	public static boolean capture(String outputDir) throws Exception {
		if(System.getProperty("capture.env")==false)return true

		if(!new File(outputDir).exists())new File(outputDir).mkdirs()
		// キャプラ起動オプション
		// /C3 - ウィンドウまたはコントロール
		// /W1 - 画面中央位置にあるウィンドウまたはコントロール
		// /R - トリミング加工する
		// /T1 - 1秒後にキャプチャを開始する
		// /A5;"outputDir";10" 連続して保存; 保存パス; PNG形式
		ProcessBuilder builder = new ProcessBuilder("exe/capwrite.exe", "/C3", "/W1", "/R", "/T1", "/A5;\"" + outputDir + "\";10");
		Process process = builder.start();
		process.waitFor();
		return process.exitValue() == 0;
	}
}
