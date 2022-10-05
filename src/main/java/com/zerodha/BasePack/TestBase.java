package com.zerodha.BasePack;

import java.util.Properties;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zerodha.utils.ReadPropFile;

public class TestBase {

	public static Properties prop=null; 
	public static WebDriver driver=null;
	
	public static void init() {
	
		prop=ReadPropFile.getProp("D:\\Akshay\\Software Testing\\Eclips Workspace\\kite_Zerodha_TestStage\\"
				+ "src\\main\\java\\com\\zerodha\\config\\application.properties");
	
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefor") || browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverPath"));
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageLoadTime")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeOut")), TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("baseUrl"));		
	}
	

	
	public void tearDown() {
		driver.quit();
	}
	
}
