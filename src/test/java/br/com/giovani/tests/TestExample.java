package br.com.giovani.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.giovani.pages.Config;
import br.com.giovani.pages.MenuPage;
import br.com.giovani.pages.ArticlePage;

public class TestExample {

	WebDriver driver;
	Config config = new Config();
	MenuPage menu;
	ArticlePage art;

	@Before
	public void setup(){
		driver = config.setUpChrome(driver);
		menu = new MenuPage(driver);
		art = new ArticlePage(driver);
	}

	@Test
	public void search(){
		String search = "goku";
		String titleExpect = "Son Goku";

		menu.search(search);
		String titleCurrent = art.getTitleArticle();

		Assert.assertEquals(titleExpect, titleCurrent);
	}
}