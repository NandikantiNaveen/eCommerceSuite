package com.qa.demoWebShop.testcases;

import org.testng.annotations.Test;
import com.qa.demoWebShop.base.TestBase;
import com.qa.demoWebShop.pages.DwsHomePage;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DwsHomePageTest extends TestBase {

	private Logger log = LogManager.getLogger(DwsHomePageTest.class);
	DwsHomePage homePage;

	@Test
	public void verifyHomePageTitle() {
		log.info("fectching the home title");
		homePage.getDwsHomePagetitle();
		Assert.assertEquals(homePage.getDwsHomePagetitle(), "Demo Web Shop");
	}

	@BeforeClass
	public void beforeClass() {
		log.info("creating the home page object");
		homePage = new DwsHomePage();
	}

	@AfterClass
	public void afterClass() {
		log.info("removing all the cache of the browser for DwsHomePage Test ");
		driver.manage().deleteAllCookies();
	}
}