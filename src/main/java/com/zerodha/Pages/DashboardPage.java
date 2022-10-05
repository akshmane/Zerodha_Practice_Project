package com.zerodha.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.zerodha.BasePack.TestBase;

public class DashboardPage extends TestBase{

	
	Actions act=new Actions(driver);
	
	@FindBy(xpath = "//a[@class='logo']")
	private WebElement dashboardLogo;
	
	@FindBy(xpath = "//span[@class='transaction-type' and text()='Buy']")
	private WebElement buyingDialog;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDashboardPage() {
		 
		return dashboardLogo.isDisplayed();
	}

	private WebElement constructElementForShare(String shareName) {
		return driver.findElement(By.xpath("//span[@class='nice-name' and text()='"+shareName+"']"));
	}
	
	//span[@class='nice-name' and text()='TCS']/parent::span/parent::span/parent::div/following-sibling::span//button[text()='B ']
	
	public WebElement byBtn() {
		return driver.findElement(By.xpath("//button[contains(text(),'B')]"));
	}
	
	public boolean clickOnByBtn(String shareName) {

		act.moveToElement(constructElementForShare(shareName)).build().perform();

		act.moveToElement(byBtn()).click().build().perform();
		
		return buyingDialog.isDisplayed();
		
	}
	
	
	
	
	
}

