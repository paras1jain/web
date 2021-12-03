package com.edu.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edu.qa.base.TestBase;
import com.edu.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@formcontrolname='userName']")
	WebElement username;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h1[contains(text(),'Log In')]")
	WebElement loginpageLogo;
	
	@FindBy(xpath="//*[@class='fa fa-eye-slash']")
	WebElement viewPasswordicon;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement viewPasswordtext;
	

	@FindBy(xpath="//a[contains(text(),'Forgot password')]")
	WebElement ForgotPasswordlink;
	
	@FindBy(xpath="//p[contains(text(),'Please correct your credentials')]")
	WebElement invalidLoginNoitification;
	//*[@class='notifier__notification-message']
	
	//Initializing the Page Objects:
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateloginlogo(){
		return loginpageLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
				return new HomePage(driver) ;
		    	
	
	}
	
	public String invalidlogin(String un, String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	TestUtil.waiting(invalidLoginNoitification);
		    	boolean notice = invalidLoginNoitification.isDisplayed();
		    	System.out.println(notice);
		    String alertmsg=invalidLoginNoitification.getText();
			return alertmsg;
				
	}
	
	
	public String viewpasswordicon(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		viewPasswordicon.click();
		 String password=viewPasswordtext.getAttribute("value");
		return password;
		
				
	}
	
	public ForgotPasswordPage ClickForgotPassword(){
		ForgotPasswordlink.click();
		return new ForgotPasswordPage(driver);
	}
	
}
