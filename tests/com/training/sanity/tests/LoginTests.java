package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
/*
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	//	driver.quit();
	}
	
*/	
	
	// Test Case 2	:- To Verify whether application allows registered user to login into application

	@Test(priority = 2)
	public void validLoginTest() {
		
		driver.get(baseUrl);		// Needed only if TC1 and TC2 to be executed together.
		String titleDashboard = "Dashboard ‹ Real Estate — WordPress";
		loginPOM.clickLoginPageLink();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		String pageTitle = driver.getTitle();
		
		if(pageTitle.equalsIgnoreCase(titleDashboard))
		{
		System.out.println("Current Page Title is :-  " +driver.getTitle());
		}
		else
		{
			System.out.println("User navigated to wrong page i.e :-  " +pageTitle);
		}
	}
	
	@Test(priority=3, enabled=true)
	public void deleteCategories() throws InterruptedException  {
		
		loginPOM.clickPostTab();
		loginPOM.clickCategoriesLink();
		loginPOM.checkboxCheck();
		Thread.sleep(1000);
		loginPOM.bulkActions();
	}


	// Test Case 1	:- To verify whether application allows the user to get registered upon entering valid credentials
	@Test(priority=1, enabled=false)
	public void registerUserTest()  {
				
				
		loginPOM.clickLoginPageLink();
		loginPOM.clickRegisterTab();
		loginPOM.sendEmailId("manz03r@gmail.com");
		loginPOM.sendFirstName("Manz03r");
		loginPOM.sendLastName("mehad12");
		loginPOM.clickRegisterButton();
		screenShot.captureScreenShot("Register");
		
//		String message = driver.findElement(By.xpath("//div[@class = 'my-account style-1 margin-top-5 margin-bottom-40']//following::p")).getText();
				
		System.out.println("Response Message after Register button click :- ");
		System.out.println(loginPOM.ResponseMessage());
	}
	

	
}
