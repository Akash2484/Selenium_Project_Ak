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
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/** Updated 'loginDBTest' to execute TestCase(RETC_061)
 * <Creation date="05/18/2020" author="Akash Tyagi">
 * @author AKASHTYAGI
 *
 */

public class LoginExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

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
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	
	/**TestCase_09	(RETC_061):- To verify whether application allows multiple users to get registered upon entering valid credentials
	 * <Creation date="05/18/2020" author="Akash Tyagi">
	 * @param emailId
	 * @param firstName
	 * @param lastName
	 * NOTE :- Calling generic function named 'genericRegisterFunciton' to perform 'Registration'.
	 */	
	
	@Test(priority =1, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)	
	public void loginExcelValidDataTest(String emailId, String firstName, String lastName) {

		genericRegisterFunciton(emailId, firstName, lastName);
		
	}
	

	/**TestCase_11	(RETC_063):- TO verify whether application displays error message upon entering invalid details during registration
	 * <Creation date="05/20/2020" author="Akash Tyagi">
	 * @param emailId
	 * @param firstName
	 * @param lastName
	 * NOTE :- Calling generic function named 'genericRegisterFunciton' to perform 'Registration'.
	 */
	
	@Test(priority =2, dataProvider = "excel2-inputs", dataProviderClass = LoginDataProviders.class)	
	public void loginExcelInvalidDataTest(String emailId, String firstName, String lastName) {
			
		genericRegisterFunciton(emailId, firstName, lastName);

	}
	
	
	/**Generic function to perform new user registration for valid/invalid scenario's.
	 * <Creation date="05/20/2020" author="Akash Tyagi">
	 * @param emailId
	 * @param firstName
	 * @param lastName
	 * NOTE :- This is a generic function getting called from 'loginExcelValidDataTest' and 'loginExcelInvalidDataTest' Tests.
	 */
	public void genericRegisterFunciton(String emailId, String firstName, String lastName) {
		
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