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
public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement bankWireMethod;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement payByChequeeMethod;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickoOnPaymentMethod() {
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}

}
