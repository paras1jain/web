package com.edu.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.edu.qa.base.TestBase;
import com.edu.qa.util.TestUtil;

public class UserProfilePage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//a[@id='accDropdown']")
	WebElement accdropdown;
	//input[@class='form-control ng-pristine ng-valid ng-touched' and @type='text']
	@FindBy(xpath="//h1[contains(text(),'My Profile')]")
	WebElement UserProfilepageLogo;
	//input[@formcontrolname='first_name']
	@FindBy(xpath="//input[@formcontrolname='first_name']")
	WebElement UserProfileFirstName;
	//input[@formcontrolname='last_name']
	@FindBy(xpath="//input[@formcontrolname='last_name']")
	WebElement UserProfileLastName;
	
	@FindBy(xpath="//input[@formcontrolname='username']")
	WebElement UserProfileUserName;
	
	@FindBy(xpath="//input[@formcontrolname='role']")
	WebElement UserProfileUserRole;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement UserProfileUserEmail;
	
	@FindBy(xpath="//input[@formcontrolname='facebook']")
	WebElement UserProfileUserFacebook;
	
	@FindBy(xpath="//input[@formcontrolname='linkedin']")
	WebElement UserProfileUserLinkedin;
	
	@FindBy(xpath="//input[@formcontrolname='institute']")
	WebElement UserProfileUserOrganision;
	
	@FindBy(xpath="//input[@formcontrolname='mobile']")
	WebElement UserProfileUserMobile;
	@FindBy(xpath="//*[@class='form-control ng-valid ng-touched ng-dirty']")
	WebElement UserProfileAbout;
	
	@FindBy(xpath="//button[@class='btn btn-danger' and @type ='submit']")
	WebElement UserProfileSaveButton;
	@FindBy(xpath="//p[@class='notifier__notification-message']")
	WebElement Notificationsuccesssave;
	
	//Initializing the Page Objects:
	public UserProfilePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateloginlogo(){
		return UserProfilepageLogo.isDisplayed();
	}
	
	public void ClickonUseProfileicon(){
		Select acdropdown = new Select(accdropdown);
		acdropdown.deselectByVisibleText("User Profile");
		
	}

	public String getUserProfileFirstName(){
		String userProfileFirstName=TestUtil.getText(UserProfileFirstName);	
		return userProfileFirstName;
	}
	
	public String getUserProfileLastName(){
		//String userProfileLastName= TestUtil.getText(UserProfileLastName);	
		String userProfileLastName= UserProfileLastName.getAttribute("value");
		return userProfileLastName;
	}
	public String getUserProfileUserName(){
		//String userProfileUserName= TestUtil.getText(UserProfileUserName);	
		String userProfileUserName= UserProfileUserName.getAttribute("value");
		return userProfileUserName;
	}
	
	public String getUserProfileRole(){
		//String userProfileRole= TestUtil.getText(UserProfileUserRole);
		String userProfileRole= UserProfileUserRole.getAttribute("value");
		return userProfileRole;
	}
	
	public String getUserProfileEmail(){
		//String userProfileEmail= TestUtil.getText(UserProfileUserEmail);
		String userProfileEmail= UserProfileUserEmail.getAttribute("value");
		return userProfileEmail;
	}
	
	public String getUserProfileFacebooklink(){
		//String userProfilefb= TestUtil.getText(UserProfileUserFacebook);
		String userProfilefb= UserProfileUserFacebook.getAttribute("placeholder");
		return userProfilefb;
	}
	public String getUserProfileLindianlink(){
		//String userProfileUserLinkedin= TestUtil.getText(UserProfileUserLinkedin);
		String userProfileUserLinkedin= UserProfileUserLinkedin.getAttribute("placeholder");
		return userProfileUserLinkedin;
	}
	
	public String getUserProfileOrganision(){
		//String userProfileUserOrganision= TestUtil.getText(UserProfileUserOrganision);
		String userProfileUserOrganision= UserProfileUserOrganision.getAttribute("value");
		return userProfileUserOrganision;
	}
	
	public String getUserProfileUserMobile(){
		//String userProfileUserMobile= TestUtil.getText(UserProfileUserMobile);
		String userProfileUserMobile= UserProfileUserMobile.getAttribute("value");
		return userProfileUserMobile;
	}	
	
	
	public void editUserProfileFirstName(String FirstName){
		UserProfileFirstName.click();
		UserProfileFirstName.clear();
		UserProfileFirstName.sendKeys(FirstName);		
	}
	
	public void editUserProfileLastName(String lastname){
		UserProfileFirstName.click();
		UserProfileFirstName.clear();
		 UserProfileLastName.sendKeys(lastname);		
	}
	
	public void editUserProfileUserName(String UserName){	
		UserProfileUserName.click();
		UserProfileUserName.clear();
		 UserProfileUserName.sendKeys(UserName);	
	}
	public void editUserProfileAbout(String UserAbout){	
		UserProfileAbout.click();
		UserProfileAbout.clear();
		UserProfileAbout.sendKeys(UserAbout);	
	}
	
	public void editUserProfileFacebooklink(String Facebooklink){
		UserProfileUserFacebook.click();
		UserProfileUserFacebook.clear();
		 UserProfileUserFacebook.sendKeys(Facebooklink);		
	}
	
	public void editUserProfileLindianlink(String Lindianlink){	
		UserProfileUserLinkedin.click();
		UserProfileUserLinkedin.clear();
		 UserProfileUserLinkedin.sendKeys(Lindianlink);	
	}
	
	public void editUserProfileUserMobile(String UserMobile){
		UserProfileUserMobile.click();
		UserProfileUserMobile.clear();
		UserProfileUserMobile.sendKeys(UserMobile);
	}	
	public String clickSaveButton (){
		UserProfileSaveButton.click();
		 String alertmsg=Notificationsuccesssave.getText();
			return alertmsg;
		
	}
	
	
}
