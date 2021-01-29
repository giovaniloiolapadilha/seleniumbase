package br.com.giovani.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage{

	By inputSearch = By.id("searchInput");
	By btnSearch = By.id("searchButton");

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	public void search(String text){
		write(inputSearch, text);
		click(btnSearch);
	}
}
