/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.ie.InternetExplorerDriver

import org.openqa.selenium.remote.DesiredCapabilities

// Use htmlunit as the default
// run via “./gradlew htmlunitTest”
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { 
	def driver = new HtmlUnitDriver()
	driver.javascriptEnabled = true
	driver
}

waiting {
	timeout = 2
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
		driver = { new InternetExplorerDriver() }
	}
}
// To run the tests with all browsers just run “./gradlew test”