package com.zerodha.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zerodha.BasePack.TestBase;
import com.zerodha.Pages.DashboardPage;
import com.zerodha.Pages.LoginPage;
import com.zerodha.Pages.LoginPinPage;

public class LoginPageTest extends TestBase {

	LoginPage login = null;
	LoginPinPage pinPage = null;
	DashboardPage dashboard = null;

	@BeforeMethod
	void setup() {
		init();
		login = new LoginPage();
	}

	@Test(priority = 0, description = "Verifying login page element test")
	void validateLoginPage() {
		boolean result = login.verifyLoginPage();
		Assert.assertTrue(result);
	}

	@Test(priority = 1, description = "Verifying login Functionality test")
	void validateLoginFun() {

		pinPage = login.doLogin(prop.getProperty("userId"), prop.getProperty("password"));

		Assert.assertTrue(pinPage.verifyLoginPinPage(prop.getProperty("userId")));

		dashboard = pinPage.enterPin(prop.getProperty("pin"));
		
		Assert.assertTrue(dashboard.verifyDashboardPage()," Login Failed check the user if pass");
	}

	@AfterMethod
	void closeLoginTest() {
		tearDown();
	}
}

