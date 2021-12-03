package com.edu.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.edu.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//a[@id='accDropdown']")
	WebElement accdropdown;
	
	@FindBy(xpath="//a[contains(text(),'User Profile')]")
	WebElement userprofileicon;
	
	@FindBy(xpath="//a[contains(text(),' Log Out')]")
	WebElement logouticon;
	
	@FindBy(xpath="//a[contains(text(),' Resources ')]")
	WebElement Resourcesicon;
	
	@FindBy(xpath="//a[contains(text(),'Question Bank')]")
	WebElement QuestionBankicon;
	
	@FindBy(xpath="//a[contains(text(),'Assessment')]")
	WebElement Assessmenticon;
	
	@FindBy(xpath="//a[contains(text(),'Course Work')]")
	WebElement CourseWorkicon;
	
	@FindBy(xpath="//a[contains(text(),'Resource Bank')]")
	WebElement ResourceBankicon;
		
	@FindBy(xpath="//a[contains(text(),'The Mosaic')]")
	WebElement TheMosaicicon;
	
	@FindBy(xpath="//a[contains(text(),' Student Content ')]")
	WebElement StudentContenticon;
	
	@FindBy(xpath="//a[contains(text(),'Student Questions')]")
	WebElement StudentQuestionsicon;
	
	@FindBy(xpath="//a[contains(text(),'Student Answer')]")
	WebElement StudentAnswericon;
	
	@FindBy(xpath="//a[contains(text(),'Courses')]")
	WebElement courseicon;
	
	@FindBy(xpath="//h2[contains(text(),'Collaborating for Happy Learning')]")
	WebElement HomepageLogo;
	
	//Initializing the Page Objects:
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateloginlogo(){
		return HomepageLogo.isDisplayed();
	}
	
	public UserProfilePage ClickonUseProfileicon(){
		accdropdown.click();
		userprofileicon.click();
		return new UserProfilePage(driver);
	}

	
	public QuestionBankPage ClickonQuestionBankicon(){
		Resourcesicon.click();
		QuestionBankicon.click();
		return new QuestionBankPage(driver);
		
	}
	
	public CoursePage ClickonCouseicon(){
		courseicon.click();
		return new CoursePage(driver);				
	}
		
	public LandingPage ClickonLogouticon(){
		accdropdown.click();
		logouticon.click();
		return new LandingPage(driver);
	}
}
