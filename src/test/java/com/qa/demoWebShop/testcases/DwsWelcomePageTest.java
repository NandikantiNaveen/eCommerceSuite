package com.qa.demoWebShop.testcases;

import org.testng.annotations.Test;

import com.qa.demoWebShop.base.TestBase;
import com.qa.demoWebShop.pages.DwsHomePage;
import com.qa.demoWebShop.pages.DwsLoginPage;
import com.qa.demoWebShop.pages.DwsWelcomePage;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;

public class DwsWelcomePageTest extends TestBase{
	private Logger log = LogManager.getLogger(DwsHomePageTest.class);
	DwsHomePage homePage;
	DwsLoginPage loginPage;
	DwsWelcomePage welcomePage;
	
	@Test(priority=1)
	public void navigateToLoginPage() throws InterruptedException {
		log.info("User is logging to the application");
		homePage.clickOnLoginLink();
	}

	@Test(priority=2)
	public void doLogin() throws InterruptedException, IOException {
		log.debug("entering username and password");
		welcomePage = loginPage.doLogin(readPropertyValue("username"), readPropertyValue("password"));
		log.info("Login is Successful");
	}

	@BeforeClass
	public void beforeClass() {
		log.info("creating the home page object");
		homePage = new DwsHomePage();
		loginPage = new DwsLoginPage();
		welcomePage = new DwsWelcomePage();
	}

	@AfterClass
	public void afterClass() {
		log.info("removing all the cache of the browser for DwsWelcomePage Test ");
		driver.manage().deleteAllCookies();
	}
}