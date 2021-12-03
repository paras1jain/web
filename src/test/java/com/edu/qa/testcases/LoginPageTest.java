package com.edu.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.qa.base.TestBase;
import com.edu.qa.pages.HomePage;
import com.edu.qa.pages.LandingPage;
import com.edu.qa.pages.LoginPage;
import com.edu.qa.pages.UserProfilePage;
import com.edu.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	String sheetName1 = "InvalidLogin";
	String sheetName = "validLogin";
	String notification = "Please correct your credentials";
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	UserProfilePage userProfilePage;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage =new LandingPage(driver);
		loginPage = new LoginPage(driver);	
		homePage = new HomePage(driver);
		userProfilePage= new UserProfilePage(driver);
	}
	
	@Test(priority=1)
	public void landingPageTitleTest(){
		String landingPagetitle=landingPage.validateLandingPageTitle();
		Assert.assertEquals(landingPagetitle, "educollab");
	}
	
	@Test(priority=2)
	public void loginPageTitleTest(){
		loginPage=landingPage.clickloginbutton();
		String loginPagetitle=loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPagetitle, "educollab");
		
	}
	@Test(priority=3)
	public void loginLogoImageTest(){
		loginPage=landingPage.clickloginbutton();
		boolean loginPagelogo=loginPage.validateloginlogo();
		Assert.assertTrue(loginPagelogo);
	}
	
	
	@DataProvider
	public Object[][] geteducollabTestDatainvalid(){
		Object data[][] = TestUtil.getTestData(sheetName1);
		return data;
	}
	@Test(priority=4,dataProvider="geteducollabTestDatainvalid")
	public void loginTestInvalid(String username,String password) throws InterruptedException{
		
		loginPage=landingPage.clickloginbutton();
		String ArtMsg = loginPage.invalidlogin(username, password);
		Assert.assertEquals(ArtMsg, notification);
	}
	
	@Test(priority=5,dataProvider="geteducollabTestDatainvalid")
	public void PasswordviewIcon(String username,String password){
		
		loginPage=landingPage.clickloginbutton();
		String passwd = loginPage.viewpasswordicon(username, password);
		
		Assert.assertEquals(passwd, password);
	}
	
	@DataProvider
	public Object[][] geteducollabTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=6,dataProvider="geteducollabTestData")
	public void loginTest(String username,String password){
		
		loginPage=landingPage.clickloginbutton();
		homePage= loginPage.login(username, password);
		 homePage.validateHomePageTitle();
	}
	
	@Test(priority=7,dataProvider="geteducollabTestData")
	public void logoutTest(String username,String password){
		
		loginPage=landingPage.clickloginbutton();
		homePage= loginPage.login(username, password);
		 homePage.validateHomePageTitle();
		 landingPage = homePage.ClickonLogouticon();
		 landingPage.validateLandingPageTitle();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
