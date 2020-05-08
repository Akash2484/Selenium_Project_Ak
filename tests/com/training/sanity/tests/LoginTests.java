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


	/**
	 * TestCase_01	(RETC_001):- To verify whether application allows the user to get registered upon entering valid credentials
	 * <Creation date="05/05/2020" author="Akash Tyagi">
	 * NOTE:- Other @Test must be marked (enabled = false), if user wants to execute TestCase_01
	 */
	
	@Test(priority=1, enabled=false)
	public void registerUserTest()  {
					
					
		loginPOM.clickLoginPageLink();
		loginPOM.clickRegisterTab();
		loginPOM.sendEmailId("manz04r@gmail.com");
		loginPOM.sendFirstName("Manz04r");
		loginPOM.sendLastName("mehad14");
		screenShot.captureScreenShot("Before_Register");
		loginPOM.clickRegisterButton();
		screenShot.captureScreenShot("After_Register");	
		System.out.println("Response Message after Register button click :- " );
		System.out.println(loginPOM.ResponseMessage());
	}
	
		
	/**
	 * TestCase_02	(RETC_002):- To Verify whether application allows registered user to login into application
	 * <Creation date="05/05/2020" author="Akash Tyagi">
	 */

	@Test(priority = 2)
	public void validLoginTest() {
		
		String titleDashboard = "Dashboard ‹ Real Estate — WordPress";
		loginPOM.clickLoginPageLink();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard_Default_Page");
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
	
	/**
	 * TestCase_03	(RETC_019):- To Verify whether application allows admin to delete category from the categories page
	 * <Creation date="05/05/2020" author="Akash Tyagi">
	 */

	@Test(priority=3, dependsOnMethods="validLoginTest")
	public void deleteCategories() throws InterruptedException  {
		
		loginPOM.clickPostTab();
		loginPOM.clickCategoriesLink();
		loginPOM.checkboxCheck();
		screenShot.captureScreenShot("Before_Delete_Categories");
		Thread.sleep(1000);
		loginPOM.bulkActions();
		screenShot.captureScreenShot("After_Delete_Categories");
	}

	
}
