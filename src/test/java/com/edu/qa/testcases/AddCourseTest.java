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
import com.edu.qa.pages.UserProfilePage;
import com.edu.qa.util.TestUtil;

public class AddCourseTest extends TestBase {
	String sheetName = "validLogin";
	String sheetName1 = "Addcourse";
	String addPageTitle= "educollab";
	String uploadfilepath ="C:\\Users\\hp\\Desktop\\New folder\\Educollab2\\Educollab2\\src\\test\\resources\\Screenshot (2).png";
	String zoomlink ="https://us05web.zoom.us/j/85635846852?pwd=OW9PM05KOUliTkY1S3NjODJydVljQT09";
	
	LandingPage landingPage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	HomePage homePage;
	CoursePage coursePage;
	AddCoursePage addCoursePage;
	String usernname = prop.getProperty("usernname");
	String password = prop.getProperty("password");
	
	public AddCourseTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage =new LandingPage(driver);
		loginPage = new LoginPage(driver);	
		homePage= new HomePage(driver);
		coursePage = new CoursePage(driver);
		addCoursePage = new AddCoursePage(driver);
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
	public void VerifyCourseScreenLogo(String un, String pwd) {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		coursePage=homePage.ClickonCouseicon();
		coursePage.validateCourselogo();
		
	}
	
	@Test(priority=2,dataProvider="geteducollabTestData")
	public void VerifyAddtocourseScreenlogo(String un, String pwd) {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		coursePage=homePage.ClickonCouseicon();
		addCoursePage=coursePage.Clickonaddcoursebutton();
		addCoursePage.validateCourselogo();
		String addcoursePageTitle=addCoursePage.validateaddcoursePageTitle();
		Assert.assertEquals(addcoursePageTitle, addPageTitle);
		
	}
	
	
	@Test(priority=3,dataProvider="geteducollabTestData")
	public void Verifyselectcategory(String us, String pa) {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		coursePage=homePage.ClickonCouseicon();
		addCoursePage=coursePage.Clickonaddcoursebutton();
	    String selectedcourseCatregory=	addCoursePage.VerifyselectedcourseCatregory("Commerce / Economics");
	  //  Assert.assertEquals(selectedcourseCatregory, "Commerce / Economics");
		
	}
	
	
	@Test(priority=4,dataProvider="geteducollabTestData")
	public void AddcoursesaveAsDraft(String un, String pwd) throws InterruptedException {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		coursePage=homePage.ClickonCouseicon();
		addCoursePage=coursePage.Clickonaddcoursebutton();
		addCoursePage.selectcourseCatregory("Commerce / Economics");		
		addCoursePage.entertitle(pwd);
		addCoursePage.enterlearning_objectives("paras");
		addCoursePage.enterstart_date("2021-10-01");
		addCoursePage.enterend_date("2021-10-12");
		addCoursePage.enterstart_time("2255");		
		addCoursePage.selectfrequency("Daily");
		addCoursePage.enterduration("22");	
		addCoursePage.enterTag("parasjain");
		addCoursePage.enterAccessibleToOrganisation("TestOrganistaion");
		addCoursePage.enterEnterinstructors("testInstructor");
		addCoursePage.clickTopic1Removeicon();
		addCoursePage.clickCourseworkRemoveicon();
		addCoursePage.clickAssessmentRemoveicon();
		addCoursePage.clickCourseResource1Removeicon();
		addCoursePage.clicksaveAsDraft();
		
	}
	
	
	@Test(priority=5,dataProvider="geteducollabTestData")
	public void AddcourseSubmit(String un, String pwd) throws InterruptedException {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		coursePage=homePage.ClickonCouseicon();
		addCoursePage=coursePage.Clickonaddcoursebutton();
		addCoursePage.selectcourseCatregory("Commerce / Economics");		
		addCoursePage.entertitle(pwd);
		addCoursePage.enterlearning_objectives("paras");
		try {
			addCoursePage.uploadfile(uploadfilepath);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addCoursePage.enterstart_date("2021-10-01");
		addCoursePage.enterend_date("2021-10-12");
		addCoursePage.enterstart_time("2255");		
		addCoursePage.selectfrequency("Daily");
		addCoursePage.enterduration("22");	
		addCoursePage.selectLive(zoomlink);
		addCoursePage.enterTag("parasjain");
		addCoursePage.enterAccessibleToOrganisation("TestOrganistaion");
		addCoursePage.enterEnterinstructors("testInstructor");
		addCoursePage.clickTopic1Removeicon();
		addCoursePage.clickCourseworkRemoveicon();
		addCoursePage.clickAssessmentRemoveicon();
		addCoursePage.clickCourseResource1Removeicon();
		addCoursePage.clickpublish();
		
	}
	
	
	
	@Test(priority=6,dataProvider="geteducollabTestData")
	public void AddcourseSubmitwithoutLive(String un, String pwd) throws InterruptedException {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		coursePage=homePage.ClickonCouseicon();
		addCoursePage=coursePage.Clickonaddcoursebutton();
		addCoursePage.selectcourseCatregory("Commerce / Economics");		
		addCoursePage.entertitle(password);
		addCoursePage.enterlearning_objectives("paras");
		try {
			addCoursePage.uploadfile(uploadfilepath);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addCoursePage.enterstart_date("2021-10-01");
		addCoursePage.enterend_date("2021-10-12");
		addCoursePage.enterstart_time("2255");		
		addCoursePage.selectfrequency("Daily");
		addCoursePage.enterduration("22");	
		addCoursePage.removeLivesession();
		addCoursePage.enterTag("parasjain");
		addCoursePage.enterAccessibleToOrganisation("TestOrganistaion");
		addCoursePage.enterEnterinstructors("testInstructor");
		addCoursePage.clickTopic1Removeicon();
		addCoursePage.clickCourseworkRemoveicon();
		addCoursePage.clickAssessmentRemoveicon();
		addCoursePage.clickCourseResource1Removeicon();
		addCoursePage.clickpublish();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
