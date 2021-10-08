package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	private WebDriver driver;
	
	//1.BY Locators
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By SignInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	//2.Constructor of the Login page
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//3.Page Actions : Features(behavior) of the page the form of the methods:
	public String getLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public  boolean isForgotPwdLinkExist()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(emailID).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(SignInButton).click();
	}
	
	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Login with :"+ un +" and "+ pwd);
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignInButton).click();
		return new AccountsPage(driver);
	}
	
}