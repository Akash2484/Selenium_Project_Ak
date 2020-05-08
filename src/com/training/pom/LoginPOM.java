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
	
	
//	@FindBy(id="login")
	@FindBy(id="user_login")
	private WebElement userName; 
	
//	@FindBy(id="password")
	@FindBy(id="user_pass")
	
	private WebElement password;
	
	//@FindBy(id="formLogin_submitAuth")
	@FindBy(name="login")
	
	private WebElement loginBtn; 
	
	
	// Register Page WebElements
	
//	@FindBy(xpath ="//a[contains(text(),'Register')]")
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
	
//	@FindBy(className = "wp-menu-name")
	@FindBy(xpath = "//div[contains(text(), \"Posts\")]")
	private WebElement poststab;
	
	@FindBy(xpath = ("//a[contains(text(), \"Categories\")]"))
	
	private WebElement categorieslink;
	
	@FindBy(xpath = ("//table[@class = 'wp-list-table widefat fixed striped tags']/tbody/tr[2]//following::th"))
	private WebElement secondCheckbox;
	
	@FindBy(xpath = ("//table[@class = 'wp-list-table widefat fixed striped tags']/tbody/tr[3]//following::th"))
	private WebElement thirdCheckbox;
	
	
	@FindBy(id = "bulk-action-selector-top")
	private WebElement drpdwnBulkAction;
	
	@FindBy(xpath = ("//option[contains(text(), 'Delete')]"))
	private WebElement deleteValue;
	
	@FindBy(id = "doaction")
	private WebElement applyButton;
	
	
	// Dashboard Page Functions
	
		public void clickPostTab() {
			this.poststab.click();
		}
	
		public void clickCategoriesLink() {
			this.categorieslink.click();
		}
		
		public void checkboxCheck() {
			this.secondCheckbox.click();
			this.thirdCheckbox.isEnabled();
		}
		
		public void bulkActions() {
			this.drpdwnBulkAction.click();
			this.deleteValue.click();
			this.applyButton.click();
		}
		
		
	
	
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
	}
	
		
	
	// Register Page Functions
	
	public void clickRegisterTab() {
		this.registerTab.click();
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
	
	
}
