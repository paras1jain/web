package com.edu.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.edu.qa.base.TestBase;
import com.edu.qa.pages.ForgotPasswordPage;
import com.edu.qa.pages.LandingPage;
import com.edu.qa.pages.LoginPage;

public class ForgotPasswordTest extends TestBase {
	String sheetName = "validLogin";
	LandingPage landingPage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
	
	public ForgotPasswordTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage =new LandingPage(driver);
		loginPage = new LoginPage(driver);	
		forgotPasswordPage = new ForgotPasswordPage(driver);
	}
	
	@Test(priority=1)
	public void ForgotPassword(){
		loginPage=landingPage.clickloginbutton();
		forgotPasswordPage=loginPage.ClickForgotPassword();
		forgotPasswordPage.validateforgototpsend(sheetName);
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
