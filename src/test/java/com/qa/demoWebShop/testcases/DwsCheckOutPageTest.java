package com.qa.demoWebShop.testcases;

import org.testng.annotations.Test;
import com.qa.demoWebShop.base.TestBase;
import com.qa.demoWebShop.pages.DwsCheckoutPage;
import com.qa.demoWebShop.pages.DwsDesktopsPage;
import com.qa.demoWebShop.pages.DwsHomePage;
import com.qa.demoWebShop.pages.DwsLoginPage;
import com.qa.demoWebShop.pages.DwsProductDetailsPage;
import com.qa.demoWebShop.pages.DwsShoppingCartPage;
import com.qa.demoWebShop.pages.DwsWelcomePage;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;

public class DwsCheckOutPageTest extends TestBase{
	
	private Logger log = LogManager.getLogger(DwsProductDetailsPageTest.class);
	DwsHomePage homePage;
	DwsLoginPage loginPage;
	DwsWelcomePage welcomePage;
	DwsDesktopsPage desktopPage;
	DwsProductDetailsPage productDetailsPage;
	DwsShoppingCartPage shoppingCardPage;
	DwsCheckoutPage checkoutPage;
	
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
	public void selectDesktopsSubCategory() throws InterruptedException {
		log.info("navigating to sub category Desktops");
		welcomePage.clickOnSubCategoryDesktops();
	}

	@Test(priority = 4)
	public void addToCart() throws InterruptedException {
		productDetailsPage.validatePrice();
		productDetailsPage.enterQuantity();
		productDetailsPage.clickOnAddtoCart();
		productDetailsPage.validateMsgAddedItemToCart();

	}
	@Test(priority = 5)
	public void navigateToCheckout() throws InterruptedException {
		shoppingCardPage.clickOnCheckout();
	}
	
	@Test(priority = 6)
	public void checkoutPage() throws InterruptedException {
		//checkoutPage.clickOnShoppingCart();
		checkoutPage.selectBillingDropdown();
		checkoutPage.BillingAddressSectionForm();
		checkoutPage.shippingAddressSection();
		checkoutPage.shippingMethodSection();
		checkoutPage.paymentMethod();
		checkoutPage.paymentInfo();
	}

	@BeforeClass
	public void beforeClass() {

		log.info("creating the home page object");
		homePage = new DwsHomePage();
		loginPage = new DwsLoginPage();
		welcomePage = new DwsWelcomePage();
		desktopPage = new DwsDesktopsPage();
		productDetailsPage = new DwsProductDetailsPage();
		shoppingCardPage = new DwsShoppingCartPage();
		checkoutPage = new DwsCheckoutPage();
	}
	
	@AfterClass
	public void afterClass() {
		log.info("removing all the cache of the browser for DwsDesktopPage Test ");
		driver.manage().deleteAllCookies();
	}
}