package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	 * NOTE:- TestCase_01 must be marked (enabled = false), if user wants to execute TestCase_02
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
	 * @throws AWTException 
	 */
/*
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
*/	

	
	/**
	 * TestCase_04	(RETC_031):- To verify whether application allows admin to add new property with all details
	 * <Creation date="05/11/2020" author="Akash Tyagi">
	 * NOTE:- All other @Test must be marked (enabled = false) or commented, if user wants to execute TestCase_04
	 * @throws AWTException 
	 */

	@Test(priority=4, dependsOnMethods="validLoginTest")
	public void addNewProperty() throws InterruptedException, AWTException  {
		
		loginPOM.clickPropertiesTab();
		loginPOM.clickAddNewPropertyLink();
		Thread.sleep(500);
		loginPOM.sendPropertyTitle("new launch_AK");
		loginPOM.detailsTextArea("new launch Description_AK");
		screenShot.captureScreenShot("AddNew_Property");
		loginPOM.sendPrice("50000.00", "200.00");
		screenShot.captureScreenShot("AddPrice_SubPage");
		loginPOM.clickMainDetailMenu();
		loginPOM.sendMainDetails("NEW", "Electronic city", "immediate");
		loginPOM.clickLocationMenu();
		loginPOM.sendAddress("yeshwanthapur", "yeshwanthapur");
		loginPOM.sendMapLocation("120", "56");
		loginPOM.clickDetailsMenu();
		loginPOM.sendDetailsTabData("2");
		loginPOM.chkboxCentralBanglore();
		loginPOM.roboUpClickFunction();
		Thread.sleep(5000);
		loginPOM.clickPublishButton();
		Thread.sleep(3000);
		System.out.println("Response Message after Publish button click :- " );
		System.out.println(loginPOM.verifyPostContent());
		
		
	}
		
	
	/**
	 * TestCase_05	(RETC_032):- To verify whether application allows customer to view, enquire & calculate loan on New launches
	 * <Creation date="05/12/2020" author="Akash Tyagi">
	 * NOTE:- All other @Test must be marked (enabled = false) or commented, if user wants to execute TestCase_05
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	
	@Test(priority=5, enabled=false)
	public void enquireAndCalculateLoan() throws AWTException, InterruptedException {
		loginPOM.clickNewLaunchImage();
		loginPOM.sendForEnquiresData("selenium", "selenium@gmail.com", "apartment", "looking for apartment");
		screenShot.captureScreenShot("TC_05_Added_Enquiry");
		loginPOM.performMortgageCalculation("40000", "2000", "2", "5");
		screenShot.captureScreenShot("TC_05_Mortgage_Calculated");
	}

	
	/**
	 * TestCase_06	(RETC_033):- TO verify whether application allows admin to view added property details in All Properties window
	 * <Creation date="05/13/2020" author="Akash Tyagi">
	 * NOTE:- Other @Test apart from must 'validLoginTest' be marked (enabled = false) or commented, 
	 * if user wants to execute TestCase_06
	 * @throws InterruptedException 
	 */

/*	
	@Test(priority=6, dependsOnMethods="validLoginTest")
	public void viewAllAddedProperties() throws InterruptedException {
		
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		---> Why it didn't worked with Implicit Wait.
		loginPOM.clickPropertiesTab();
		loginPOM.clickAddNewPropertyLink();
		loginPOM.sendPropertyTitle("new launch_04");
		loginPOM.detailsTextArea("new launch Description_01");
		screenShot.captureScreenShot("TC_06_Add_Property");
		Thread.sleep(2000);
		loginPOM.clickPublishButton();
		Thread.sleep(3000);
		loginPOM.clickAllPropertiesLink();
		Thread.sleep(2000);
		loginPOM.verifyTableForAddedProperty();
		screenShot.captureScreenShot("TC_06_Verify_Added_Property");
	}

*/

	
	/**
	 * TestCase_07	(RETC_035):- TO verify whether application allows admin to view added user in all Users module.
	 * <Creation date="05/14/2020" author="Akash Tyagi">
	 * NOTE:- Other @Test apart from must 'validLoginTest' be marked (enabled = false) or commented, 
	 * if user wants to execute TestCase_07
	 * NOTE:- Unique value must be assigned to 'name' variable each time for Adding New User to group in each execution.
	 * @throws InterruptedException
	 */
/*
	
	@Test(priority=7, dependsOnMethods="validLoginTest")
	public void addNewUser() throws InterruptedException {
		String name = "AK_manzoor9";
		String email = (name + "@gmail.com");
		loginPOM.clickUsersTab();
		loginPOM.sendNewUserPageValues(name, email, name, "mehadi", "www.google.com");
		loginPOM.verifyRandomPassword("Manzoor@Mehadi123");
		screenShot.captureScreenShot("TC_07_Add_New_User");
		Thread.sleep(2000);
		loginPOM.selectUserRole("Agent");
		loginPOM.verifyTableForNewlyAddedUser(name, name, "mehadi");
		screenShot.captureScreenShot("TC_07_Added User in All_User_List");
	}
*/
	
	
}
