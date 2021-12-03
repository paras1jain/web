package com.edu.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.edu.qa.base.TestBase;

public class CoursePage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//*[contains(text(),'Courses')]")
	WebElement CoursepageLogo;
	//button[@routerlink='/courses/add-course']
	@FindBy(xpath="//button[@class='btn btn-link']")
	WebElement addcoursebutton;
	@FindBy(xpath="//a[contains(text(),'Teach on Educollab')]")
	WebElement TeachonEducollabicon;
	
	
	
	//Initializing the Page Objects:
	public CoursePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCourselogo(){
		return CoursepageLogo.isDisplayed();
	}
		
	public AddCoursePage Clickonaddcoursebutton(){
		addcoursebutton.click();
		return new AddCoursePage(driver);		
	}
	public void ClickonTeachonEducollabicon(){
		TeachonEducollabicon.click();
			
	}
	
}
