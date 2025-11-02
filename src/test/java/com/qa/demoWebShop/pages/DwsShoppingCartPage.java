package com.qa.demoWebShop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoWebShop.utils.BasePageWebActions;

public class DwsShoppingCartPage extends BasePageWebActions {

	private Logger log = LogManager.getLogger(DwsShoppingCartPage.class);

	public DwsShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='product-price'][contains(.,'3630.00')]")
	private WebElement subTotal;

	@FindBy(id = "termsofservice")
	private WebElement chBoxTermsOfService;

	@FindBy(id = "checkout")
	private WebElement btnCheckOut;

	public DwsCheckoutPage clickOnCheckout() throws InterruptedException {
		//assertTextIgnoreCase(subTotal, "3630.00");
		scrollForElement(chBoxTermsOfService);
		click(chBoxTermsOfService);
		click(btnCheckOut);
		return new DwsCheckoutPage();
	}

}