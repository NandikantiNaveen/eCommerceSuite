package com.qa.demoWebShop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoWebShop.utils.BasePageWebActions;

public class DwsProductDetailsPage extends BasePageWebActions {
	private Logger log = LogManager.getLogger(DwsDesktopsPage.class);

	public DwsProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='product-price']")
	private WebElement expensiveDesktopPrice;

	@FindBy(id = "addtocart_74_EnteredQuantity")
	private WebElement quantityEditbox;

	@FindBy(id = "add-to-cart-button-74")
	private WebElement AddToCartbtn;

	@FindBy(xpath = "//p[@class='content']")
	private WebElement msgItemAddedToShoppingCart;
	
	@FindBy(xpath ="//span[contains(@class,'close')]")
	private WebElement msgClose;
	
	@FindBy(xpath ="//span[contains(.,'Shopping cart')]")
	private WebElement shoppingCartlink;


	public void validatePrice() throws InterruptedException {
		scrollForElement(expensiveDesktopPrice);
		//assertText(expensiveDesktopPrice, "1800.00");
	}

	public void enterQuantity() throws InterruptedException {
		scrollForElement(quantityEditbox);
		type(quantityEditbox, "2");
	}

	public void clickOnAddtoCart() throws InterruptedException {
		scrollForElement(AddToCartbtn);
		click(AddToCartbtn);
	}

	public DwsShoppingCartPage validateMsgAddedItemToCart() throws InterruptedException {
		//assertText(msgItemAddedToShoppingCart, "The product has been added to your shopping cart");
		click(msgClose);
		click(shoppingCartlink);
		return new DwsShoppingCartPage();
	}
}