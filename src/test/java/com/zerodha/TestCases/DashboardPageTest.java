package com.zerodha.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zerodha.BasePack.TestBase;
import com.zerodha.Pages.DashboardPage;
import com.zerodha.Pages.LoginPage;
import com.zerodha.Pages.LoginPinPage;

public class DashboardPageTest extends TestBase {

	LoginPage login = null;
	LoginPinPage pinPage = null;
	DashboardPage dashboard = null;

	@BeforeMethod
	void setup() {
		init();
		login = new LoginPage();
		pinPage = login.doLogin(prop.getProperty("userId"), prop.getProperty("password"));
		dashboard = pinPage.enterPin((prop.getProperty("pin")));
	}

	@Test(priority = 0)
	void validateBuyingFun() {
		boolean result = dashboard.clickOnByBtn("TCS");
		Assert.assertTrue(result);

	}

	@AfterMethod
	void closeDashTest() {
		tearDown();
	}
}
