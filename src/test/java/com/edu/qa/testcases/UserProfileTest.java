package com.edu.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.qa.base.TestBase;
import com.edu.qa.pages.ForgotPasswordPage;
import com.edu.qa.pages.HomePage;
import com.edu.qa.pages.LandingPage;
import com.edu.qa.pages.LoginPage;
import com.edu.qa.pages.UserProfilePage;
import com.edu.qa.util.TestUtil;

public class UserProfileTest extends TestBase {
	String sheetName = "validLogin";
	LandingPage landingPage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	HomePage homePage;
	UserProfilePage userProfilePage;
	String usernname = prop.getProperty("usernname");
	String password = prop.getProperty("password");
	//<class name="com.edu.qa.testcases.UserProfileTest"></class>
	public UserProfileTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage =new LandingPage(driver);
		loginPage = new LoginPage(driver);	
		homePage= new HomePage(driver);
		userProfilePage = new UserProfilePage(driver);
	}
	@DataProvider
	public Object[][] geteducollabTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1,dataProvider="geteducollabTestData")
	public void VerifyUserProfileInformation(String un, String pwd) {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		userProfilePage=homePage.ClickonUseProfileicon();
		String userProfileFirstName=userProfilePage.getUserProfileFirstName();	
		System.out.println(userProfileFirstName);
		String userProfileLastName=userProfilePage.getUserProfileLastName();
		System.out.println(userProfileLastName);
		String userProfileUserName=userProfilePage.getUserProfileUserName();
		System.out.println(userProfileUserName);
		String userProfileRole=userProfilePage.getUserProfileRole();
		System.out.println(userProfileRole);
		String userProfileEmail=userProfilePage.getUserProfileEmail();
		System.out.println(userProfileEmail);
		String userProfileFacebooklink=userProfilePage.getUserProfileFacebooklink();
		System.out.println(userProfileFacebooklink);
		String userProfileLindianlink=userProfilePage.getUserProfileLindianlink();
		System.out.println(userProfileLindianlink);
		String userProfileMobile=userProfilePage.getUserProfileUserMobile();
		System.out.println(userProfileMobile);
		String userProfileOrganision=userProfilePage.getUserProfileOrganision();
		System.out.println(userProfileOrganision);
		
	}
	
	
	@Test(priority=2,dataProvider="geteducollabTestData")
	public void EditUserProfileInformation(String un, String pwd) {
		loginPage=landingPage.clickloginbutton();
		homePage=loginPage.login(usernname, password);
		userProfilePage=homePage.ClickonUseProfileicon();
		userProfilePage.editUserProfileFirstName("Pooja");		
		userProfilePage.editUserProfileLastName("Test");
		userProfilePage.editUserProfileUserName("Poojateach");
		userProfilePage.editUserProfileAbout("pstestxxx xxxxx");
		userProfilePage.editUserProfileFacebooklink("https://www.facebook.com/pooja.sagr11");
		userProfilePage.editUserProfileLindianlink("https://www.linkedin.com/in/pooja-sgr-b2aa7b2b/");
		userProfilePage.editUserProfileUserMobile("989898xxxx");
		String alertmsg=userProfilePage.clickSaveButton();
		//Assert.assertEquals(alertmsg, "Saved successfully");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
