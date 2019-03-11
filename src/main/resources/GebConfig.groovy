
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.remote.DesiredCapabilities

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.gargoylesoftware.htmlunit.WebClientOptions

import io.github.bonigarcia.wdm.WebDriverManager
 
environments {
 
    htmlUnit {
		WebDriverManager.firefoxdriver().setup()
        driver = { 
			HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38, true) 
			WebClientOptions options = driver.webClient.options
			options.setThrowExceptionOnScriptError(false);
			options.setThrowExceptionOnFailingStatusCode(false)
			driver
		}
    }
 
    firefox {
		WebDriverManager.firefoxdriver().setup()
        driver = { new FirefoxDriver() }
    }
	
	chrome {
		WebDriverManager.chromedriver().setup()
		driver = { 
			ChromeOptions options = new ChromeOptions()
            DesiredCapabilities capabilities = DesiredCapabilities.chrome() 
			options.addArguments("headless")
            capabilities.setCapability(ChromeOptions.CAPABILITY, options)
            new ChromeDriver(capabilities) 
		}
	}
}
