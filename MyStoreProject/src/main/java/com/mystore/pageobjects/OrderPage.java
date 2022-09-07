/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Sriharish
 *
 */
public class OrderPage extends BaseClass {

	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut; 
	
	public OrderPage() {
			PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String unitprice1=unitPrice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalprice1=totalPrice.getText();
		String tot=totalprice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice = Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOncheckOut() {
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
		}
}
