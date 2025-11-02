package com.qa.demoWebShop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoWebShop.utils.BasePageWebActions;

public class DwsWelcomePage extends BasePageWebActions {

	static Actions act;
	private Logger log = LogManager.getLogger(DwsWelcomePage.class);

	public DwsWelcomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(.,'Shopping cart')]")
	private WebElement shoppingCartLink;

	@FindBy(xpath = "//input[contains(@name,'removefromcart')]")
	private WebElement removefromcartCheckbox;

	@FindBy(xpath = "//input[contains(@name,'updatecart')]")
	private WebElement updateShoppingCart;

	@FindBy(xpath = "//img[contains(@alt,'Tricentis Demo Web Shop')]")
	private WebElement dwslogo;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(@href,'computers')]")
	private WebElement computersCategory;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(@href,'desktops')]")
	private WebElement desktopsSubCategory;

	@FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'expensive')]")
	private WebElement expensiveComputer;

	// h2[@class='product-title']//a[contains(text(),'cheap')]

	public void clearShoppingCart() throws InterruptedException {
		log.info("click on shoppingCartLink");
		click(shoppingCartLink);
		click(removefromcartCheckbox);
		click(updateShoppingCart);
		log.info("Navigate to DWS Welcome page");
		click(dwslogo);
	}

	public DwsDesktopsPage clickOnSubCategoryDesktops() throws InterruptedException {
		//hoverOnElement(computersCategory);
		clickByActions(desktopsSubCategory);
		click(expensiveComputer);
		return new DwsDesktopsPage();

	}
}