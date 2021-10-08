package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By AccountSections = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getAccountPageTitle()
	{
		return driver.getTitle();
	}
	public int getAccountsSectionCount()
	{
		 return driver.findElements(AccountSections).size();
	}
	
	public List<String> getAccountSectionList()
	{
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(AccountSections);
			for(WebElement e : accountsHeaderList )
			{
				String text = e.getText();
				System.out.println(text);
				accountsList.add(text);
			}
		return  accountsList;
	}
	
}
