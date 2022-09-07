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
public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//strong[text()='Your order on My Store is complete.']")
	WebElement confrimMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage( ) {
		String confirmMsg =confrimMessage.getText();
		return confirmMsg;
	}

}
