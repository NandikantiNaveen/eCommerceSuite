package com.qa.demoWebShop.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoWebShop.utils.BasePageWebActions;

public class DwsCheckoutPage extends BasePageWebActions {

	private Logger log = LogManager.getLogger(DwsShoppingCartPage.class);

	public DwsCheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@for='billing-address-select']")
	private WebElement billingAddressTxt;

	@FindBy(xpath = "//select[@name='billing_address_id']//option")
	private List<WebElement> addressoptions;

	@FindBy(xpath = "//select[@name='BillingNewAddress.CountryId']//option")
	private List<WebElement> countryList;

	@FindBy(xpath = "//input[@name='BillingNewAddress.City']")
	private WebElement fieldCity;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement fieldAddress1;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement fieldZipCode;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement fieldPhoneNumber;

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement btnBillingContinue;

	@FindBy(xpath = "//select[@id='shipping-address-select']")
	private WebElement shippingAddressDropDown;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement btnShippingContinue;

	@FindBy(id = "shippingoption_1")
	private WebElement radioBtnShippingMethod;

	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement btnShippingMethodContinue;

	@FindBy(xpath = "//input[@value='Payments.CashOnDelivery']")
	private WebElement radioBtnCOD;

	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement btnPaymentMethodContinue;

	@FindBy(xpath = "//p[contains(.,'You will pay by COD')]")
	private WebElement messagePaymentInfo;

	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement btnPaymentInfoContinue;

	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	private WebElement btnConfirm;

	@FindBy(xpath = "//strong[contains(.,'Your order has been successfully processed!')]")
	private WebElement messageConfirmOrder;

	@FindBy(xpath = "//li[contains(.,'Order number:')]")
	private WebElement messageOrderNumber;

	@FindBy(xpath = "//input[contains(@onclick,'setLocation('/')']")
	private WebElement btnConfirmContinue;

	@FindBy(xpath = "//span[contains(.,'Shopping cart')]")
	private WebElement shoppingCartLink;

	/**
	 * This method will select the required option from Billing address drop down
	 * 
	 * @throws InterruptedException
	 */
	public void selectBillingDropdown() throws InterruptedException {
		if (isTextPresent("Select a billing address from your address book or enter a new address.")) {
		//	selectByText(addressoptions, "New Address");
		} else {
			log.info("Not selecting");
		}

	}

	/**
	 * 
	 * @throws InterruptedException
	 */

	public void BillingAddressSectionForm() throws InterruptedException {
		//selectByText(countryList, "India");
		type(fieldCity, "Hyderabad");
		type(fieldAddress1, "TestAddress");
		type(fieldZipCode, "522009");
		type(fieldPhoneNumber, "985463735");
		click(btnBillingContinue);
	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	public void shippingAddressSection() throws InterruptedException {
		selectOptionByAttribute(shippingAddressDropDown, "2805552");
		click(btnShippingContinue);
	}
	
	public void shippingMethodSection() throws InterruptedException {
		click(radioBtnShippingMethod);
		click(btnShippingMethodContinue);
		
	}

	/**
	 * 
	 * @throws InterruptedException
	 */

	public void paymentMethod() throws InterruptedException {
		click(radioBtnCOD);
		click(btnPaymentMethodContinue);
	//	assertText(messagePaymentInfo, "You will pay by COD");
	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	public void paymentInfo() throws InterruptedException {
		click(btnPaymentInfoContinue);
		click(btnConfirm);
		//assertText(messageConfirmOrder, "Your order has been successfully processed!");
	//	assertContainsText(messageOrderNumber,"Order number" );
		click(btnConfirmContinue);
	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnShoppingCart() throws InterruptedException {
		scrollForElement(shoppingCartLink);
		log.info("click on shoppingCartLink");
		click(shoppingCartLink);
	}
	
	
}