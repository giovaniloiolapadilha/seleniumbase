package br.com.giovani.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {
	
	String driverPathChrome = "Util\\drivers\\chromedriver.exe";
	String driverPathFirefox = "Util\\drivers\\geckodriver.exe";
	String pageUrl = "https://pt.wikipedia.org/";
	
	
	public WebDriver setUpChrome(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", driverPathChrome);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(pageUrl);
		return driver;
	}
	
	public WebDriver setUpFirefox(WebDriver driver) {
		System.setProperty("webdriver.gecko.driver", driverPathFirefox);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(pageUrl);
		return driver;
	}
	
	

}
