package com.qa.demoWebShop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.demoWebShop.utils.BasePageWebActions;

public class DwsHomePage extends BasePageWebActions {

	private Logger log = LogManager.getLogger(DwsHomePage.class);

	public DwsHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class='ico-login']")
	private WebElement loginLink;

	public String getDwsHomePagetitle() {
		return driver.getTitle();
	}

	public DwsLoginPage clickOnLoginLink() throws InterruptedException {
		log.info("click on login link in home page");
		click(loginLink);
		return new DwsLoginPage();
	}
}