package com.edu.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.edu.qa.base.TestBase;

public class LandingPage extends TestBase{
	//Page Factory - OR:
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	WebElement loginicon;
		
	//Initializing the Page Objects:
	public LandingPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLandingPageTitle(){
		return driver.getTitle();
	}

	public LoginPage clickloginbutton(){
		loginicon.click();
		return new LoginPage(driver);
		
	}


}
