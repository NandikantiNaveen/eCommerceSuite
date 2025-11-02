package com.qa.demoWebShop.testcases;

import org.testng.annotations.Test;
import com.qa.demoWebShop.base.TestBase;
import com.qa.demoWebShop.pages.DwsHomePage;
import com.qa.demoWebShop.pages.DwsLoginPage;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;

public class DwsLoginPageTest extends TestBase {

	private Logger log = LogManager.getLogger(DwsHomePageTest.class);
	DwsHomePage homePage;
	DwsLoginPage loginPage;

	@Test
	public void navigateToLoginPage() throws InterruptedException {
		log.info("User is logging to the application");
		homePage.clickOnLoginLink();

	}

	@BeforeClass
	public void beforeClass() {
		log.info("creating login page object");
		homePage = new DwsHomePage();
		loginPage = new DwsLoginPage();
	}

	@AfterClass
	public void afterClass() {
		log.info("removing all the cache of the browser for DwsLoginPage Test ");
		driver.manage().deleteAllCookies();
	}
}