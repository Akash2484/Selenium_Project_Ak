package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

 /** Updated 'loginDBTest' to execute TestCase(RETC_062)
 * <Creation date="05/19/2020" author="Akash Tyagi">
 * @author AKASHTYAGI
 *
 */
 
public class LoginDBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	
	/**
	 * TestCase_10	(RETC_062):- To verify whether details entered by user during registration get displayed in database
	 * <Creation date="05/19/2020" author="Akash Tyagi">
	 * @param emailId
	 * @param firstName
	 * @param lastName
	 */
	
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String emailId, String firstName, String lastName) {	

		System.out.println("Email Id value from DB is :- " +emailId);
		System.out.println("First Name value from DB is :- " +firstName);
		System.out.println("Last Name value from DB is :- " +lastName);
		
		loginPOM.clickLoginPageLink();
		loginPOM.clickRegisterTab();
		loginPOM.sendEmailId(emailId);
		loginPOM.sendFirstName(firstName);
		loginPOM.sendLastName(lastName);
		screenShot.captureScreenShot("Data_Before_Registration_for" +firstName);
		loginPOM.clickRegisterButton();
		screenShot.captureScreenShot(firstName);
		System.out.println("Response Message after Register button click :- " );
		System.out.println(loginPOM.ResponseMessage());
		

	}

}