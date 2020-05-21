package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	// Login/Register Link Element	
	
	@FindBy(className = "sign-in" )
	
	private WebElement loginLink;
		
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")	
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	
	// Register Page WebElements
	
	@FindBy(linkText = "Register")
	private WebElement registerTab;
	
	@FindBy(id = "email")
	private WebElement txtEmailID;
	
	@FindBy(id = "first-name")
	private WebElement txtFirstName;
	
	@FindBy(id = "last-name")
	private WebElement txtLastName;
	
	@FindBy(name = "submit")
	private WebElement btnRegister;
	
	@FindBy(xpath = "//div[@class = 'my-account style-1 margin-top-5 margin-bottom-40']//following::p")
	private WebElement	registerPageResponseMsg;
	
	
	// Dashboard Page WebElements
	
	@FindBy(xpath = "//div[contains(text(), \"Posts\")]")
	private WebElement poststab;
	
	@FindBy(xpath = "//a[contains(text(), 'All Posts')]")
	private WebElement allPostsMenu;
	
	@FindBy(xpath = "//a[contains(text(), 'Tags')]")
	private WebElement tagsMenu;
		
	@FindBy(xpath = ("//a[contains(text(), \"Categories\")]"))
	
	private WebElement categorieslink;
	
	@FindBy(xpath = ("//table[@class = 'wp-list-table widefat fixed striped tags']/tbody/tr[2]//following::input"))
	private WebElement secondCheckbox;
	
	@FindBy(xpath = ("//table[@class = 'wp-list-table widefat fixed striped tags']/tbody/tr[3]//following::input"))
	private WebElement thirdCheckbox;
	
	@FindBy(id = "bulk-action-selector-top")
	private WebElement drpdwnBulkAction;
	
	@FindBy(xpath = ("//option[contains(text(), 'Delete')]"))
	private WebElement deleteValue;
	
	@FindBy(id = "doaction")
	private WebElement applyButton;
	
	
	// Add New Properties Page WebElements	(RETC_031 & RETC_033)
	
	@FindBy(xpath = ("//div[contains(text(), 'Properties')]"))
	private WebElement propertiesTab;

	@FindBy(xpath = "//div[contains(text(), 'Properties')]//following::a[2]")
	private WebElement addNewPropertyLink;

	@FindBy(xpath = "//a[contains(text(),'All Properties')]")
	private WebElement allPropertiesMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Properties Settings')]")
	private WebElement propertiesSettings;
	
	@FindBy(css = "input[name=post_title]")
	private WebElement txtPropertyTitle;
	
	@FindBy(css = "textarea#content")
	private WebElement txtAreaContent;

	@FindBy(css="textarea#_price")
	private WebElement txtAreaPrice;	
	
	@FindBy(css="input#_price_per")
	private WebElement pricePerUnit;

	@FindBy(xpath = "//a[contains(text(),'Main Details')]")
	private WebElement mainDetailMenu;
	
	@FindBy(css="input#_status")
	private WebElement txtStatus;	
	
	@FindBy(css="input#_location")
	private WebElement txtLocation;
	
	@FindBy(css="input.regular-text[name =_possession]")
	private WebElement txtPossession;	
	
	@FindBy(css="a.ui-tabs-anchor[id =ui-id-3]")
	private WebElement locationMenu;
	
	@FindBy(css="input#_friendly_address")
	private WebElement txtAddress;	
	
	@FindBy(css="input#_address")
	private WebElement txtMapsAddress;
	
	@FindBy(css="input#_geolocation_lat")
	private WebElement txtLatitude;	
	
	@FindBy(css="input[name =_geolocation_long]")
	private WebElement txtLongitude;
	
	@FindBy(css="a.ui-tabs-anchor[id =ui-id-4]")
	private WebElement detailsMenu;
	
	@FindBy(css="input#_storage_room")
	private WebElement txtStorageRoom;
	
	@FindBy(xpath = "//div[@class='categorychecklist-holder']//following::input")
	private WebElement chkCentralBanglore;
	
	@FindBy(css="input#publish")
	private WebElement btnPublish;
	
	@FindBy(css = "div.updated.notice.notice-success.is-dismissible")
	private WebElement verifyPostPublished;
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr")
	private List<WebElement> tablePost;
	
	
	//New Launch & Enquiry section WebElements	(RETC_033)
	
	@FindBy(xpath = "//a[contains(text(),'New Launch ')]")
	private WebElement newLaunchLink;
	
	@FindBy(xpath = "//div[@class=\"wpmm-post post-4505\"]//following::img")
	private WebElement imgNewLaunch;
	
	@FindBy(xpath = "//h3[contains(text(),'prestige - Overview ')]")
	private WebElement prestigeOverviewText;
	
	//Enquiries & Mortgage Calculation Functions
	
	@FindBy(css="input[name=your-name]")
	private WebElement txtYourName;
	
	@FindBy(css="input[name=your-email]")
	private WebElement txtYourEmail;
	
	@FindBy(css="input[name=your-subject]")
	private WebElement txtYourSubject;
	
	@FindBy(css="textarea[name=your-message]")
	private WebElement txtAreaYourMessage;	

	@FindBy(css="input[value=Send]")
	private WebElement btnSendForEnquiry;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement enquiryMessage;
	
	@FindBy(css="input#amount")
	private WebElement txtSalePrice;
	
	@FindBy(css="input#downpayment")
	private WebElement txtDownPayment;
	
	@FindBy(css="input#years")
	private WebElement txtLoanTermYears;
	
	@FindBy(css="input#interest")
	private WebElement txtInterest;
	

	@FindBy(css="button.button.calc-button")
	private WebElement btnCalculate;
	
	@FindBy(css="div.notification.success")
	private WebElement mortgageCalculationMessage;
	

	// USERS Tab & Add New User WebElements (RETC_035)
	
	@FindBy(xpath = ("//div[contains(text(), 'Users')]"))
	private WebElement usersTab;

	@FindBy(xpath = "//a[contains(text(),'All Users')]")
	private WebElement allUsersLink;

	@FindBy(xpath = "//div[contains(text(), 'Users')]//following::a[contains(text(),'Add New')]")
	private WebElement addNewUserLink;
	
	@FindBy(xpath = "//a[contains(text(),'Your Profile')]")
	private WebElement yourProfileLink;
	
	@FindBy(css="input#user_login")
	private WebElement txtNewUserName;
	
/*	******************************************************************************
  	NOTE:- No Need to define this 'Email' WebElement again, old WebElement from   
	Register page can be re-used as Locator value is same in both cases.
	******************************************************************************
*/	
	
//	@FindBy(id = "email")					
//	private WebElement txtNewUserEmail;
	
	@FindBy(css="input#first_name")
	private WebElement txtNewUserFirstName;
	
	@FindBy(css="input#last_name")
	private WebElement txtNewUserLastName;
	
	@FindBy(css="input#url")
	private WebElement txtNewUserWebsite;

	@FindBy(xpath="//button[contains(text(),'Show password')]")
	private WebElement btnShowPassword;
	
	@FindBy(css= "button[aria-label='Hide password']")
	private WebElement btnHidePassword;
	
	@FindBy(css= "button[aria-label='Cancel password change']")
	private WebElement btnCancel;
	
	@FindBy(css= "input#pass1-text")
	private WebElement txtUserPassword;
	
	@FindBy(css="input#pass1")
	private WebElement passwordTextValue;
	
	@FindBy(css="select#role")
	private WebElement clickRole;
	
	@FindBy(css="input#createusersub")
	private WebElement btnAddNewUser; 
	
	@FindBy(xpath = "//table[@class='wp-list-table widefat fixed striped users']/tbody/tr")
	private List<WebElement> tableUser;
	
	

	// *******List of Defined Functions ********
	
	// Login Page Functions
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
		
	public void clickLoginPageLink() {
		this.loginLink.click();
		System.out.println("Login sub-screen gets displayed :-  " +userName.isDisplayed());		//If UserName field is present, user is under login tab. 
	}
			
	
	// Register Page Functions

	public void clickRegisterTab() {
		this.registerTab.click();
		System.out.println("Register sub-screen gets displayed :-  " +txtEmailID.isDisplayed());		//If Email_ID field is present, user is under Register tab. 
		
	}

	public void sendEmailId(String emailID) {
		this.txtEmailID.clear();
		this.txtEmailID.sendKeys(emailID);
	}
	
	public void sendFirstName(String firstName) {
		this.txtFirstName.clear();
		this.txtFirstName.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.txtLastName.clear();
		this.txtLastName.sendKeys(lastName);
	}

	public void clickRegisterButton() {
		this.btnRegister.click();
	}
	
	public String ResponseMessage() {
		
		String response = registerPageResponseMsg.getText();				
		return response;
	}
	
	
	// Dash Board Page Functions
	
	public void clickPostTab() {
		this.poststab.click();
		System.out.println("All Posts sub-menu is visible :-  " +allPostsMenu.isDisplayed());
		System.out.println("Tags sub-menu is visible :-  " +tagsMenu.isDisplayed());
	}
		
	public void clickCategoriesLink() {
		this.categorieslink.click();
	}
			
	public void checkboxCheck() {
		this.secondCheckbox.click();
		System.out.println("Is SecondCheckbox checked :- " +secondCheckbox.isSelected());
		this.thirdCheckbox.click();
		System.out.println("Is ThirdCheckbox checked :- " +thirdCheckbox.isSelected());
	}
			
	public void bulkActions() {
		this.drpdwnBulkAction.click();
		this.deleteValue.click();
		System.out.println("Is Delete dropdown value selected :- " +deleteValue.isSelected());
		this.applyButton.click();
	}
	

	// Add New Property Functions	(RETC_031 & RETC_033)
		
	public void clickPropertiesTab() {
		this.propertiesTab.click();
		System.out.println("All Properties sub-menu is visible :-  " +allPropertiesMenu.isDisplayed());
		System.out.println("Tags sub-menu is visible :-  " +propertiesSettings.isDisplayed());
	}
	
	public void clickAddNewPropertyLink() {
		this.addNewPropertyLink.click();
	}

	public void sendPropertyTitle(String newPropertyTitle) {
		this.txtPropertyTitle.clear();
		this.txtPropertyTitle.sendKeys(newPropertyTitle);
	}
	
	public void detailsTextArea(String description) {
		this.txtAreaContent.clear();
		this.txtAreaContent.sendKeys(description);
	}
		
	public void sendPrice(String totalPrice, String pricePerUnit) {
		this.txtAreaPrice.clear();
		this.txtAreaPrice.sendKeys(totalPrice);
		this.pricePerUnit.clear();
		this.pricePerUnit.sendKeys(pricePerUnit);
	}
	
	public void clickMainDetailMenu() {
		this.mainDetailMenu.click();
	}
	
	public void sendMainDetails(String status, String location, String possession) {
		this.txtStatus.clear();
		this.txtStatus.sendKeys(status);
		this.txtLocation.clear();
		this.txtLocation.sendKeys(location);
		this.txtPossession.clear();
		this.txtPossession.sendKeys(possession);	
	}
	
	public void clickLocationMenu() {
		this.locationMenu.click();
	}
	
	public void sendAddress(String address, String mapAddress) {
		this.txtAddress.clear();
		this.txtAddress.sendKeys(address);	
		this.txtMapsAddress.clear();
		this.txtMapsAddress.sendKeys(mapAddress);
	}

	public void sendMapLocation(String latitude, String longitude) {
		this.txtLatitude.clear();
		this.txtLatitude.sendKeys(latitude);	
		this.txtLongitude.clear();
		this.txtLongitude.sendKeys(longitude);
	}
	
	public void clickDetailsMenu() {
		this.detailsMenu.click();
	}
	
	public void sendDetailsTabData(String storageDetails) {
		this.txtStorageRoom.clear();
		this.txtStorageRoom.sendKeys(storageDetails);	
	}
	
	public void chkboxCentralBanglore()	{
		this.chkCentralBanglore.click();
		System.out.println("Is Central Banglore checked :- " +chkCentralBanglore.isSelected());	
	}
	

	public void roboUpClickFunction() throws AWTException {
	
	Robot robo = new Robot();
    robo.keyPress(KeyEvent.VK_UP);
    robo.keyPress(KeyEvent.VK_ENTER);
    
    robo.keyRelease(KeyEvent.VK_UP);
    robo.keyRelease(KeyEvent.VK_ENTER);
    
	}
	
	public void clickPublishButton() {
		this.btnPublish.click();
	}
	
	public String verifyPostContent() {		
		String message = verifyPostPublished.getText();	
		return message;
	}
	
	public void clickAllPropertiesLink() {
		this.allPropertiesMenu.click();
		
	}

	public void verifyTableForAddedProperty() {
		
//	   List<WebElement> table = driver.findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr"));
	   List<WebElement> table = tablePost; 	
	   int noofRows = table.size();
	   int flag = 0;
	   System.out.println("No of rows " + noofRows);		
	   for(int i=1; i<=noofRows; i++) {
		      		
	     	String propertyTitle = driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr["+i+"]/td[1]/strong")).getText();
	     	if(propertyTitle.equalsIgnoreCase("new launch_04")) 
	     	{		     		
	     		System.out.println("Newly Added Property Title matches expected property name i.e  " + propertyTitle);
	     		flag=1;
	     		break;
	     	}
	   }
	   if(flag ==0)
	   {
		   System.out.println("Unable to identify newly added property in table.");
	   }
		    
	}
	
	
	// Enquires & Mortgage Calculation Functions	(RETC_032)
		
	public void clickNewLaunchImage() throws AWTException, InterruptedException {
		Thread.sleep(3000);

//      ******************************************* 		
// 		NOTE :- Below commented code to be discussed with Roshan. Identified (x,y) co-ordinates using getLocation() function 
//	    are unable to identify object in GUI using 	robo.mouseMove(x,y)	function. 
		
//		Point loc = driver.findElement(By.xpath("//a[contains(text(),'New Launch ')]")).getLocation();
//		String text = driver.findElement(By.xpath("//a[contains(text(),'New Launch ')]")).getText();
//        System.out.println("Location of link " + loc);
//        System.out.println("Text of link " + text);
        
//		Robot robo = new Robot();	
//		robo.mouseMove(532,129);
		
//      ******************************************* 		
		
		Actions action = new Actions(driver);
		action.moveToElement(newLaunchLink).perform();		
		Thread.sleep(3000);
		System.out.println("Prestige Image Icon is visible... " +this.imgNewLaunch.isDisplayed());
		this.imgNewLaunch.click();
		System.out.println("Is detail of Prestige apartment visible" +this.prestigeOverviewText.isDisplayed());

	}
	
	public void sendForEnquiresData(String yourName, String yourEmail, String yourSubject, String yourMessage) throws InterruptedException {
		this.txtYourName.clear();
		this.txtYourName.sendKeys(yourName);
		this.txtYourEmail.clear();
		this.txtYourEmail.sendKeys(yourEmail);
		this.txtYourSubject.clear();
		this.txtYourSubject.sendKeys(yourSubject);
		this.txtAreaYourMessage.clear();
		this.txtAreaYourMessage.sendKeys(yourMessage);
		Thread.sleep(4000);
		this.btnSendForEnquiry.click();
		Thread.sleep(5000);
		System.out.println("Value of Response Message is :- " +enquiryMessage.getText());
		
	}
	
	public void performMortgageCalculation(String salePrice, String downPayment, String loanTermYears, String interest) throws InterruptedException {
		this.txtSalePrice.clear();
		this.txtSalePrice.sendKeys(salePrice);
		this.txtDownPayment.clear();
		this.txtDownPayment.sendKeys(downPayment);
		this.txtLoanTermYears.clear();
		this.txtLoanTermYears.sendKeys(loanTermYears);
		this.txtInterest.clear();
		this.txtInterest.sendKeys(interest);
		this.btnCalculate.click();
		Thread.sleep(4000);
		System.out.println("Value of Mortgage Calculation Message is :- " +mortgageCalculationMessage.getText());		
		String actualMortgage = mortgageCalculationMessage.getText();
        String expectedMortgage = "Monthly Payment: 1667.11 Rs.";
        
        try {
            Assert.assertEquals(actualMortgage, expectedMortgage);		//HardAssert :- It Fails the script and throws error if condition fails.
        } catch(Throwable t) {
            System.out.println("Test Script(RETC_032) failed as Calculated Mortgage value is not as Expected");
        }
		
	}
		

	// USERS Tab & Add New User Functions (RETC_035)
	
		public void clickUsersTab() {
			this.usersTab.click();
			System.out.println("All Users sub-menu is visible :-  " +allUsersLink.isDisplayed());
			System.out.println("Add New Users sub-menu is visible :-  " +addNewUserLink.isDisplayed());
			System.out.println("Your Profile sub-menu is visible :-  " +yourProfileLink.isDisplayed());
			this.addNewUserLink.click();
			System.out.println("Current Page Title is :-  " +driver.getTitle());	
			
		}
		
		
		public void sendNewUserPageValues(String newUserName, String newUserEmail, String newUserFirstName, String newUserLastName, String newUserWebsite) {
			this.txtNewUserName.clear();
			this.txtNewUserName.sendKeys(newUserName);
			this.txtEmailID.clear();
			this.txtEmailID.sendKeys(newUserEmail);
			this.txtNewUserFirstName.clear();
			this.txtNewUserFirstName.sendKeys(newUserFirstName);
			this.txtNewUserLastName.clear();
			this.txtNewUserLastName.sendKeys(newUserLastName);
			this.txtNewUserWebsite.clear();
			this.txtNewUserWebsite.sendKeys(newUserWebsite);
			this.btnShowPassword.click();
			System.out.println("Hide button is displayed :- " +this.btnHidePassword.isDisplayed());
			System.out.println("Clear button is displayed :- " +this.btnCancel.isDisplayed());
			System.out.println("Ensure Show button is not displayed :- " +this.btnShowPassword.isDisplayed());
			
		}
		
		public void verifyRandomPassword(String newPasswordValue) throws InterruptedException {
			String hiddenpasswordValue = passwordTextValue.getAttribute("data-pw");
			if(hiddenpasswordValue.isEmpty())
			{
				System.out.println("User Password field is Empty.");
			}
			else
			{
			System.out.println("Randomly generated password is :- " +hiddenpasswordValue);	
			}			
			this.txtUserPassword.clear();
			this.txtUserPassword.sendKeys(newPasswordValue);		
			System.out.println("New Password Value is  :- "+txtUserPassword.getAttribute("value"));
			
		}
		
		public void selectUserRole(String roleName) throws InterruptedException {
			this.clickRole.click();
			Thread.sleep(2000);
						
			Select sel = new Select(clickRole);	        
		        
			List<WebElement> userRoleList = sel.getOptions();
		       int noOfItems = userRoleList.size();
		        
		       System.out.println("Total Number of User Roles :- " + noOfItems);
		        
		       for(int i=0; i<noOfItems; i++) {
		          System.out.println("User Role named as :-  " +userRoleList.get(i).getText());
		       }
		       sel.selectByVisibleText(roleName);
		       System.out.println("Selected value in User Role dropdown is :- " +clickRole.getAttribute("value"));
		       this.btnAddNewUser.click();
		       String msg = driver.findElement(By.xpath("//div[@id='message']")).getText();
		       System.out.println("Message visisble on List page is :- " +msg);
		       this.allUsersLink.click();

		}
		
		public void verifyTableForNewlyAddedUser(String userNameValue, String userFirstName, String userLastNameValue) throws InterruptedException {
			String fullName_01 = (userFirstName + " " + userLastNameValue);
			System.out.println("Trimed FullName is  :- " + fullName_01);
//		    List<WebElement> table = driver.findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped users']/tbody/tr"));
			List<WebElement> table = tableUser;
			   int noofRows = table.size();
			   int flag = 0;
			   System.out.println("No of rows " + noofRows);		
			   for(int i=1; i<=noofRows; i++) {
				      		
			     	String usersName = driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped users']/tbody/tr["+i+"]/td[1]/strong")).getText();
			     	String fullName = driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped users']/tbody/tr["+i+"]/td[2]")).getText();
			     	
			     	if(usersName.equalsIgnoreCase(userNameValue)) 
			     	{		     		
			     		System.out.println("Newly Added Users UserName matches expected user name i.e :-  " + usersName);
			     		if(fullName.equalsIgnoreCase(fullName_01))
			     			
			     		{
			     			System.out.println("Newly Added Users FullName matches expected name i.e :-  " + fullName);

			     			flag=1;
				     		break;
			     		}
			     	
			     	}
			   }
			   if(flag ==0)
			   {
				   System.out.println("Unable to identify newly added User in table.");
			   }
			
		}

	
	
}
