package com.training.bean;

public class LoginBean {
//	private String userName;
//	private String password;
	private String emailId;
	private String firstName;
	private String lastName;
	

	public LoginBean() {
	}

/*	
	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
*/

	//NOTE by Akash :- Update the LoginBean function based on parameters needed for testcase.
	public LoginBean(String emailId, String firstName, String lastName) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	//NOTE by Akash :- Create getter setter's for objects needed for your testcase.
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String email) {
		this.emailId = email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last) {
		this.lastName = last;
	}
	
	
	
/*	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}

*/

	@Override
	public String toString() {
		return "LoginBean [emailId=" +emailId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
