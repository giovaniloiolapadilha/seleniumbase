package br.com.giovani.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {

	By titleArticle = By.id("firstHeading");
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitleArticle(){
		return getText(titleArticle);
	}
}
