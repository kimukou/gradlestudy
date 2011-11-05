/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.android.AndroidDriver

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import com.opera.core.systems.OperaDriver
import com.opera.core.systems.settings.OperaDriverSettings
// Use htmlunit as the default

import com.thoughtworks.selenium.DefaultSelenium
import org.openqa.selenium.remote.CommandExecutor
import org.openqa.selenium.SeleneseCommandExecutor

// run via “./gradlew htmlunitTest”
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { 
	def driver = new HtmlUnitDriver()
	driver.javascriptEnabled = true
	driver
}

waiting {
	timeout = 30
	retryInterval =1
}

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	//			http://d.hatena.ne.jp/w650/20110825/1314280671
	chrome {
		def cmPath="exe/win32/chromedriver.exe"
		osArch = System.getProperty("os.arch")
		is64Bit = osArch.contains("64")
		if(is64Bit){
			cmPath="exe/win64/chromedriver.exe"
		}
		else{
			cmPath="exe/win32/chromedriver.exe"
		}
		System.setProperty("webdriver.chrome.driver", cmPath)

		driver = { 
/*
			//downloading Chromium Portable 
			// http://www.softpedia.com/get/PORTABLE-SOFTWARE/Internet/Browsers/Chromium-Portable.shtml
			//
			// locating ChromiumPortable
			def capabilities = org.openqa.selenium.remote.DesiredCapabilities.chrome()	
			capabilities.setCapability("chrome.binary", "ChromiumPortable\\App\\Chromium\\Chrome.exe")
			capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"))
			new ChromeDriver(capabilities)
*/
			new ChromeDriver()
		}
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

	ie {
		driver = { 
			// see http://code.google.com/p/selenium/issues/detail?id=1795
			//
			def ieCapabilities = DesiredCapabilities.internetExplorer()
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true)
			new InternetExplorerDriver(ieCapabilities)
			//new InternetExplorerDriver() 

			//new InternetExplorerDriver().navigate().to("http://google.com/ncr")
			//new RemoteWebDriver(new URL("http://google.com/ncr"),DesiredCapabilities.internetExplorer())
		}
	}
	
	// see http://code.google.com/p/selenium/wiki/AndroidDriver
	//
	//		issue http://code.google.com/p/selenium/issues/detail?id=1005
	//
	android{
		driver = { new AndroidDriver() }
	}

	opera {
		driver = { 
			// see http://code.google.com/p/selenium/wiki/OperaDriver
			//     https://github.com/operasoftware/operadriver/blob/master/src/com/opera/core/systems/OperaDriver.java
/*
			OperaDriverSettings settings = new OperaDriverSettings();
			settings.setOperaBinaryLocation("C:/Program Files/Opera/opera.exe");
			settings.setOperaBinaryArguments("-nowindow -someothervalue");
			settings.setUseOperaIdle(true);
			settings.setOperaLauncherXvfbDisplay(8);
			new OperaDriver(settings);
*/
			//	see https://github.com/operasoftware/operadriver/#
			//
			//Note: On Windows Vista and 7 the program files directory is not writeable. 
			//If you run Opera from this location you will get an error beginning "Opera has failed to access or upgrade your profile". 
			// To solve this you either need to make the folder writeable by your current user, 
			// or install Opera to a different location. 
			// If you install Opera to a different location you need to set the OPERA_PATH mentioned below

			def operaCapabilities = OperaDriver.getDefaultCapabilities()
			operaCapabilities.setCapability(OperaDriver.LAUNCHER ,"exe/launcher/launcher-win32-i86pc.exe")
			operaCapabilities.setCapability(OperaDriver.BINARY  ,"d:/ToolDev/Opera/opera.exe")
			operaCapabilities.setCapability(OperaDriver.ARGUMENTS ,"-nowindow -someothervalue")
			//operaCapabilities.setCapability(OperaDriver.OPERAIDLE ,true)
			//operaCapabilities.setCapability(OperaDriver.DISPLAY  ,8)
			new OperaDriver(operaCapabilities)


			//new OperaDriver().navigate().to("http://google.com/ncr")
			//new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.opera());
		}
	}

	safari{
		baseURL="http://www.google.co.jp/"
		def sel = new DefaultSelenium("localhost", 4444, "*safari", baseURL);
		CommandExecutor executor = new SeleneseCommandExecutor(sel);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("safari")
		dc.setCapability("platform" ,org.openqa.selenium.Platform.WINDOWS)
		dc.setJavascriptEnabled(true);
		new RemoteWebDriver(executor, dc);
	}

}
// To run the tests with all browsers just run “./gradlew test”