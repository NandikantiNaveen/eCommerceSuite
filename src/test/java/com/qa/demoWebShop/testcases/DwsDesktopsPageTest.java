package com.qa.demoWebShop.testcases;

import org.testng.annotations.Test;

import com.qa.demoWebShop.base.TestBase;
import com.qa.demoWebShop.pages.DwsDesktopsPage;
import com.qa.demoWebShop.pages.DwsHomePage;
import com.qa.demoWebShop.pages.DwsLoginPage;
import com.qa.demoWebShop.pages.DwsWelcomePage;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;

public class DwsDesktopsPageTest extends TestBase {

	private Logger log = LogManager.getLogger(DwsDesktopsPageTest.class);
	DwsHomePage homePage;
	DwsLoginPage loginPage;
	DwsWelcomePage welcomePage;
	DwsDesktopsPage desktopPage;

	@Test(priority = 1)
	public void navigateToLoginPage() throws InterruptedException {
		log.info("User is logging to the application");
		homePage.clickOnLoginLink();
	}

	@Test(priority = 2)
	public void doLogin() throws InterruptedException, IOException {
		log.debug("entering username and password");
		welcomePage = loginPage.doLogin(readPropertyValue("username"), readPropertyValue("password"));
		log.info("Login is Successful");
	}

	@Test(priority = 3)
	public void removeItemsfromCart() throws InterruptedException {
		log.info("removing items from the cart");
		welcomePage.clearShoppingCart();
	}

	//@Test(priority = 4)
	public void selectDesktopsSubCategory() throws InterruptedException {
		log.info("navigating to sub category Desktops");
		welcomePage.clickOnSubCategoryDesktops();
	}

	@Test(priority = 5)
	public void clickOnComputerExpensiveItem() throws InterruptedException {
		desktopPage.clickOnExpensiveComputerItem();
	}

	@BeforeClass
	public void beforeClass() {
		log.info("creating the home page object");
		homePage = new DwsHomePage();
		loginPage = new DwsLoginPage();
		welcomePage = new DwsWelcomePage();
		desktopPage = new DwsDesktopsPage();
	}

	@AfterClass
	public void afterClass() {
		log.info("removing all the cache of the browser for DwsDesktopPage Test ");
		driver.manage().deleteAllCookies();
	}
}