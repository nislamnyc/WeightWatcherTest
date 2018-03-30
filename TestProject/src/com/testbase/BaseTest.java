package com.testbase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;


public class BaseTest {

	protected WebDriver driver;
	protected static final String URL = "https://www.weightwatchers.com/us/";
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional("firefox") String browsername) {
		
		if(browsername.equalsIgnoreCase("firefox")){
			System.out.println("launching firefox browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/lib/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("chrome")){
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("ie")){
			System.out.println("launching ie browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/lib/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		System.out.println("navigating application");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
				
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("quiting application!");
		driver.quit();
	}

}
