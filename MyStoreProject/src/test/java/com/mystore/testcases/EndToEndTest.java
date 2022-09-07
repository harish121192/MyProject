/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author Sriharish
 *
 */
public class EndToEndTest extends BaseClass{

	

	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummary ordersummary;
	OrderConfirmationPage orderconfirmatiopage;
	
	 @Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		launchApp(browser);
		
				}
	

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void endToEndTest() {
		

		indexpage = new IndexPage();
		searchresultpage = indexpage.searchProduct("t-shirt");
		addtocartpage = searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("M");
		addtocartpage.clickOnAddToCart();
		orderpage = addtocartpage.clickOnCheckOut();
		loginpage = orderpage.clickOncheckOut();
		addresspage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage = addresspage.clickOnCheckOut();
		shippingpage.clickOnTerms();
		paymentpage = shippingpage.clickOnProceedToCheckOut();
		ordersummary = paymentpage.clickoOnPaymentMethod();
		orderconfirmatiopage = ordersummary.clickOnConfirmOrderBtn();
		String actualMessage = orderconfirmatiopage.validateConfirmMessage();
		String expectedMessage = "Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
}
