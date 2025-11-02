package com.qa.demoWebShop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoWebShop.utils.BasePageWebActions;



public class DwsLoginPage extends BasePageWebActions {

	private Logger log = LogManager.getLogger(DwsLoginPage.class);

	// create a Constructor
	public DwsLoginPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[contains(.,'planittest78@gmail.com')]")
	private WebElement accountlink;
	
	@FindBy(id = "Email")
	private WebElement emailEditbox;

	@FindBy(css = "#Password")
	private WebElement passwordEditbox;

	@FindBy(xpath = "//input[contains(@value,'Log in')]")
	private WebElement loginBtn;
	
	public void clickloginBtn() throws InterruptedException {
		log.info("click on signinBtn in login page");
		click(loginBtn);
	}
	
	public DwsWelcomePage doLogin(String uname, String pwd) throws InterruptedException {
		log.debug("perform the login action ");
		log.info("clear the content and type in emailEditbox");
		clearText(emailEditbox);
		type(emailEditbox, uname);
		log.info("clear the content and type in passwordEditbox");
		clearText(passwordEditbox);
		type(passwordEditbox, pwd);
		clickloginBtn();
		return new DwsWelcomePage();
	}	
}