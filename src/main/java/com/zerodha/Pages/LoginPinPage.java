package com.zerodha.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zerodha.BasePack.TestBase;

public class LoginPinPage extends TestBase {

	@FindBy(xpath = "//input[@label='PIN']")
	private WebElement loginPinInput;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	
	private WebElement constuceElementForUserId(String userId) {
		return driver.findElement(By.xpath("//div[@class='login-form']//h2[text()='" + userId + "']"));
	}

	public LoginPinPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLoginPinPage(String userId) {
		boolean flag = false;

		if (constuceElementForUserId(userId).isDisplayed()) {
			flag = true;
		} else if (loginPinInput.isDisplayed()) {
			flag = true;
		}

		return flag;
	}
	
	public DashboardPage enterPin(String pin) {
		loginPinInput.sendKeys(pin);
		continueBtn.click();
		return new DashboardPage();
	}
}
