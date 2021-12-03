package com.edu.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.qa.base.TestBase;

public class ForgotPasswordPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@formcontrolname='forgotPasswordInput']")
	WebElement forgotPasswordInputEmailId;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//h1[contains(text(),'Forgot Password')]")
	WebElement forgotPasswordLogo;
	
	//Initializing the Page Objects:
	public ForgotPasswordPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateforgotPasswordlogo(){
		return forgotPasswordLogo.isDisplayed();
	}
	
	public void validateforgototpsend(String un){
		forgotPasswordInputEmailId.sendKeys(un);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", submitBtn);
		    	
	
	}

}
