package com.edu.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.edu.qa.base.TestBase;

public class QuestionBankPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//h1[contains(text(),'Question Bank')]")
	WebElement QuestionBanklevel;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement searchInputbox;
	
	@FindBy(xpath="//*[@class='text-left']//p")
	WebElement questionlisticon;
	
	@FindBy(xpath="//input[@id='importQst']")
	WebElement checkboxImportQst;
	
	@FindBy(xpath="//input[@id='file']")
	WebElement choosefile;
	
	@FindBy(xpath="//button[contains(text(),'Import')]")
	WebElement importbutton;
	
	
	
	
	//Initializing the Page Objects:
	public QuestionBankPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateQuestionBanklevel(){
		return QuestionBanklevel.isDisplayed();
	}
	
	public void InputQuestion(String question){
		searchInputbox.click();
		searchInputbox.sendKeys(question);
		searchInputbox.click();
		Questionlist();
		//*[@class='text-left']//p
	}

	
	public String Questionlist(){
		String elementText = null;
		List<WebElement> listElement = driver.findElements(By.xpath("//*[@class='text-left']//p"));
		for(int i =0;i<listElement.size();i++) {
		 elementText = listElement.get(i).getText(); 
		 System.out.println(elementText); 
		}
		return elementText;
	}
	
}
