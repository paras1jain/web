package com.edu.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.qa.base.TestBase;
import com.edu.qa.pages.AddCoursePage;
import com.edu.qa.pages.CoursePage;
import com.edu.qa.pages.ForgotPasswordPage;
import com.edu.qa.pages.HomePage;
import com.edu.qa.pages.LandingPage;
import com.edu.qa.pages.LoginPage;
import com.edu.qa.pages.QuestionBankPage;
import com.edu.qa.pages.UserProfilePage;
import com.edu.qa.util.TestUtil;

public class QuestionBankTest extends TestBase {
	String sheetName = "validLogin";
	String sheetName1 = "Addcourse";
	String searchquestion= "what is machine learning";
	
	LandingPage landingPage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	HomePage homePage;
	QuestionBankPage questionBankPage;
	CoursePage coursePage;
	AddCoursePage addCoursePage;
	String usernname = prop.getProperty("usernname");
	String password = prop.getProperty("password");
	
	public QuestionBankTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage =new LandingPage(driver);
		loginPage = new LoginPage(driver);	
		homePage= new HomePage(driver);
		questionBankPage= new QuestionBankPage(driver);
	}
	@DataProvider
	public Object[][] geteducollabTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	

@DataProvider
public Object[][] geteducollabTestData2(){
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}
	@Test(priority=1,dataProvider="geteducollabTestData")
	public void ValidateQuestionBanklevel(String un, String pwd) {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		questionBankPage=homePage.ClickonQuestionBankicon();
		questionBankPage.validateQuestionBanklevel();
		
		
	}
	
	@Test(priority=1,dataProvider="geteducollabTestData")
	public void ValidateQuestionBank(String un, String pwd) {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		questionBankPage=homePage.ClickonQuestionBankicon();
		questionBankPage.InputQuestion(searchquestion);		
	}


	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
