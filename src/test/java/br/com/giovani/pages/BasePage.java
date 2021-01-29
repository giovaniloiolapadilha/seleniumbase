package br.com.giovani.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver){
		this.driver = driver;
	}

	public void click(By by) {
		WebElement element = driver.findElement(by);

		try {
			moveToElement(element);
			driver.findElement(by).click();
		}catch (ElementClickInterceptedException a){
			executeJavaScript("arguments[0].click();", element);
		}
	}

	public void executeJavaScript(String script) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(script);
	}

	public void executeJavaScript(String script, Object arg) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(script, arg);
	}
	
	public String getText(By by) {
		WebElement element = driver.findElement(by);
		
		moveToElement(element);
		String text = element.getText().trim();
		return text;
	}
	
	public void moveToElement(WebElement element) {
		for (int i = 0; i < 10; i++) {
			if(element.isDisplayed()) {	
				break;
			}
			if(i == 6) {
				executeJavaScript("window.scrollTo(0, 0);");
			}
			executeJavaScript("window.scrollBy(0, window.screen.width/5);");
		}
	}
	
	public void selectDropDown(By by, String text){
		WebElement element = driver.findElement(by);
		
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void write(By by, String text){
		WebElement element = driver.findElement(by);
		
		try {
			moveToElement(element);
			element.clear();
			element.sendKeys(text);
		}catch(Exception ex) {
			executeJavaScript("arguments[0].value = '" + text + "';", element);
		}
	}
}
