package com.qa.demoWebShop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoWebShop.utils.BasePageWebActions;

public class DwsDesktopsPage extends BasePageWebActions {

	private Logger log = LogManager.getLogger(DwsDesktopsPage.class);

	public DwsDesktopsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'expensive')]")
	private WebElement expensiveComputer;

	public DwsProductDetailsPage clickOnExpensiveComputerItem() throws InterruptedException {
		log.info("clicking on expensive Cpmputer item");
		scrollForElement(expensiveComputer);
		click(expensiveComputer);
		return new DwsProductDetailsPage();
	}

	// h2[@class='product-title']//a[contains(text(),'cheap')]

}
