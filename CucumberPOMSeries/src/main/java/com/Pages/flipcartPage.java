package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.QA.factory.DriverFactory;

import java.util.Set;

import org.junit.Assert;

public class flipcartPage {

	private WebDriver driver;
	
	
	//Locators of flipkart Pages
	private By searchBar = By.name("q");
	private By ProductName = By.xpath("//div[text()='APPLE iPhone 12 (Blue, 64 GB)']");
	private By addTocart = By.xpath("//button[text()='ADD TO CART']");
	private By Price = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[4]/div[1]/div/div[1]");
	private By totalprice = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[4]/div/span/div/div/span");
	
	public flipcartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private String ProductPrice = driver.findElement(Price).getText();;
	private String TotalAmount = driver.findElement(totalprice).getText();
	
	
	public void closeLoginPopUp() 
	{
		 driver.findElement(By.xpath("//button[text()='✕']")).click(); 
	  
	}
	
	public void verifySearchBar() throws InterruptedException
	{
		  Thread.sleep(1000);
		  Assert.assertTrue(driver.findElement(searchBar).isEnabled()); 
	}
	
	public void SearchProduct() throws InterruptedException
	{
		driver.findElement(searchBar).sendKeys("Iphone12",Keys.ENTER);
		Thread.sleep(1000);
	}
	
	public void verifyProductDisplayed()
	{
		boolean displayed = driver.findElement(ProductName).isDisplayed();
		System.out.println(displayed);
	}
	
	public void selectProduct() throws InterruptedException
	{
		driver.findElement(ProductName).click();
		Thread.sleep(1000);
	}
	
	
	public void switchtoChildWindow() throws InterruptedException
	{
		String ParentWindow=driver.getWindowHandle();
		System.out.println("Parent Window id is: "+ParentWindow);
		Set<String> Windows	=driver.getWindowHandles();
		int count=Windows.size();
		System.out.println("the No of Windows are :"+count);
		
		for(String childWindow:Windows)
		{
			if(!ParentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				Thread.sleep(2000);
			}
		}
	}
	
	public void addtoKart()
	{
		driver.findElement(addTocart).click();
	}
	
	public void verifyPrices()
	{
		System.out.println(ProductPrice);
		System.out.println(TotalAmount);
		Assert.assertEquals("Both are Equal",ProductPrice,TotalAmount);
	}
	
}
