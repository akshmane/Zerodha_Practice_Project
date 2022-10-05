package com.zerodha.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zerodha.BasePack.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//img[@alt='Kite']")
	private WebElement pageLogo;

	@FindBy(xpath = "//input[@id='userid']")
	private WebElement userIdInput;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement userPassword;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Signup now!')]")
	private WebElement signupLink;

	public WebElement getPageLogo() {
		return pageLogo;
	}

	public WebElement getUserIdInput() {
		return userIdInput;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSignupLink() {
		return signupLink;
	}
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Business logic
	
	private List<WebElement> getPageLogoElement() {
		return driver.findElements(By.xpath("//img[@alt='Kite']"));
	}
	
	public boolean verifyLoginPage() {
		boolean flag= true;
		
		
		if(!pageLogo.isDisplayed()) {
			flag=false;
		}else if(!userIdInput.isDisplayed()) {
			flag=false;
		}else if(!userPassword.isDisplayed()) {
			flag=false;
		}else if(!loginBtn.isDisplayed()) {
			flag=false;
		}else if(!signupLink.isDisplayed()) {
			flag=false;
		}
		
		if(getPageLogoElement().size()<=0) {
			flag=false;
		}
		
		return flag;
	}

	public LoginPinPage doLogin(String userId, String pass) {
		
		userIdInput.sendKeys(userId);
		userPassword.sendKeys(pass);
		loginBtn.click();
		return new LoginPinPage();
	}
	
	
}
