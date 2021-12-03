package com.edu.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.edu.qa.base.TestBase;
import com.edu.qa.util.TestUtil;

public class AddCoursePage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//*[contains(text(),'Add Course')]")
	WebElement AddCoursepageLogo;
	
	@FindBy(xpath="//button[@class='btn btn-link']")
	WebElement addcoursebutton;
	
	@FindBy(xpath="//a[contains(text(),'Teach on Educollab')]")
	WebElement TeachonEducollabicon;
	
	@FindBy(xpath="//*[@formcontrolname='course_category_id']")
	WebElement cousreCategory;
	
	@FindBy(xpath="//input[@formcontrolname='subject']")
	WebElement subjecttitle;
	
	@FindBy(xpath="//textarea[@formcontrolname ='learning_objectives']")
	WebElement learning_objectives;
	
	@FindBy(xpath="//input[@formcontrolname ='start_date']")
	WebElement start_date;
	
	@FindBy(xpath="//input[@formcontrolname ='end_date']")
	WebElement end_date;
	@FindBy(xpath="//input[@formcontrolname ='start_time']")
	WebElement start_time;
	
	
	@FindBy(xpath="//select[@formcontrolname ='frequency']")
	WebElement frequency;
	
	@FindBy(xpath="//input[@formcontrolname ='duration']")
	WebElement duration;
	

	@FindBy(xpath="//button[@id ='btnGroupDrop1']")
	WebElement btnGroupDrop1;
	
	@FindBy(xpath="(//button[@class ='dropdown-item'])[1]")
	WebElement btndropdown_item1;
	
	@FindBy(xpath="//input[@placeholder='+ Tag']")
	WebElement tag;
	
	@FindBy(xpath="//input[@placeholder='Enter Organisations']")
	WebElement EnterOrganisations;
	
	@FindBy(xpath="//input[@placeholder='Enter instructors']")
	WebElement Enterinstructors;
	
	@FindBy(xpath="//input[@placeholder='Enter editors']")
	WebElement Entereditors;
	
	@FindBy(xpath="//*[contains(text(),'Add video conferencing URL')]//following::button[1]")
	WebElement Topic1_dropdownicon;
	
	//*[@class='dropdown-menu show']//*[contains(text(),' Custom ')]
	
	@FindBy(xpath="//button[contains(text(),'Save as draft')]")
	WebElement saveAsDraft;
	
	@FindBy(xpath="//button[contains(text(),'Publish')]")
	WebElement Publish;
	
	@FindBy(xpath="//*[@class='custom-file']")
	WebElement uploadbutton;
	
	
	@FindBy(xpath="//button[contains(text(),'Add zoom Credentials ')]")
	WebElement AddzoomCredentials;
	
	@FindBy(xpath="//*[@class='dropdown-menu show']//*[contains(text(),' Custom ')]")
	WebElement clickCustomurloption;
	
	
	@FindBy(xpath="//input[@class='form-control ng-valid ng-touched ng-dirty']")
	WebElement addCustomurl;
	
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	WebElement Removeicon;
	
	@FindBy(xpath="//*[contains(text(),' Topic 1 ')]//following::button[1]")
	WebElement Topic1Removeicon;
	
	@FindBy(xpath="(//*[contains(text(),' Coursework ')]//following::button[6])[1]")
	WebElement CourseworkRemoveicon;
	
	@FindBy(xpath="(//*[contains(text(),' Assessment ')]//following::button[6])[1]")
	WebElement AssessmentRemoveicon;
	
	@FindBy(xpath="(//*[contains(text(),' Course Resource 1 ')]//following::button[1])[1]")
	WebElement CourseResource1Removeicon;
	
		
	
	
	//Initializing the Page Objects:
	public AddCoursePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateaddcoursePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCourselogo(){
		return AddCoursepageLogo.isDisplayed();
	}
		
	public void Clickonaddcoursebutton(){
		addcoursebutton.click();		
	}
	public void selectcourseCatregory(String cousreCategry){
		TestUtil.slectclass(cousreCategory, cousreCategry);
			
	}
	
	public String VerifyselectedcourseCatregory(String cousreCategry){
		WebElement option =	TestUtil.verifyslectedclass(cousreCategory, cousreCategry);
		String defaultItem = option.getText();
		return defaultItem;
			
	}
	
	
	
	public void entertitle(String subjecttite){
		subjecttitle.sendKeys(subjecttite);
			
	}
	
	public void enterlearning_objectives(String learningobjective){
		learning_objectives.sendKeys(learningobjective);
			
	}
	
	public void enterstart_date(String startdate){
		start_date.sendKeys(startdate);
			
	}
	
	public void enterend_date(String enddate){
		end_date.sendKeys(enddate);
			
	}
	
	public void selectLive(String customurl){
		//TestUtil.slectclass(Topic1_dropdownicon, customurl);
		Topic1_dropdownicon.click();
		TestUtil.waiting(clickCustomurloption);
		clickCustomurloption.click();
		TestUtil.waiting(addCustomurl);
		//addCustomurl.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById(addCustomurl).setAttribute('value', customurl)");
		//addCustomurl.sendKeys(customurl);
			
	}
	
	public void enterstart_time(String starttime){
		start_time.sendKeys(starttime);
			
	}
	public void selectfrequency(String frequncy){
		frequency.sendKeys(frequncy);
			
	}
	public void enterduration(String duratin){
		duration.sendKeys(duratin);
			
	}
	public void clickbtnGroupDrop1(){
		btnGroupDrop1.click();
			
	}
	public void clickbtndropdown_item1(){
		btndropdown_item1.click();
			
	}
	
	public void removeLivesession() throws InterruptedException{
		Removeicon.click();
		TestUtil.isAlertPresent();
			
	}
	
	
	public void enterTag(String Tag){
		tag.click();
		tag.sendKeys(Tag);
			
	}
	
	public void enterAccessibleToOrganisation(String Organisations){
		EnterOrganisations.click();
		EnterOrganisations.sendKeys(Organisations);
			
	}
	public void enterEnterinstructors(String Instructors){
		Enterinstructors.click();
		Enterinstructors.sendKeys(Instructors);
			
	}
	
	
	public void clicksaveAsDraft(){
		saveAsDraft.click();
			
	}
	
	public void clickpublish(){
		Publish.click();
			
	}
	public void clickTopic1Removeicon() throws InterruptedException{
			
		try {
			   
			Topic1Removeicon.click();   
			   
			  } catch (NoSuchElementException ex) {
			 

				  ex.printStackTrace();
		        }
		TestUtil.isAlertPresent();
		
			
	}
	public void clickCourseworkRemoveicon() throws InterruptedException{
		
		try {
	   
			CourseworkRemoveicon.click();   
			   
			  } catch (NoSuchElementException ex) {
			 
				  ex.printStackTrace();
		        }
		TestUtil.isAlertPresent();
	}
	public void clickAssessmentRemoveicon() throws InterruptedException{
		
		
		try {
			   
			AssessmentRemoveicon.click();   
			   
			  } catch (NoSuchElementException ex) {
			 
				  ex.printStackTrace();
		        }
		TestUtil.isAlertPresent();
			
	}
	
	public void clickCourseResource1Removeicon() throws InterruptedException{
		
		try {
			   
			CourseResource1Removeicon.click();
			     
			  } catch (NoSuchElementException ex) {
			 
				  ex.printStackTrace();
		        }
		TestUtil.isAlertPresent();
			
	}
	public void uploadfile(String uploadfilepath) throws AWTException{
	
		uploadbutton.click();
	StringSelection ss = new StringSelection(uploadfilepath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

    //imitate mouse events like ENTER, CTRL+C, CTRL+V
    Robot robot = new Robot();
    robot.delay(250);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.delay(90);
    robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
}
