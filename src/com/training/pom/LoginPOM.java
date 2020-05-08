package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		
	// Click on Login/Register page Link from top NavBar	
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
	
	
	
}
