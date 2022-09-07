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
public class AddToCartPage extends BaseClass {

	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2//i")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	WebElement proceedToCheckOutButton;
	
public AddToCartPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
		
	}
	
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCart() {
		Action.fluentWait(getDriver(), addToCartMessage, 10);
	return 	Action.isDisplayed(getDriver(), addToCartMessage);
		
	}
	
	public OrderPage clickOnCheckOut() {
		Action.fluentWait(getDriver(), proceedToCheckOutButton, 10);
		Action.JSClick(getDriver(), proceedToCheckOutButton);
		return new OrderPage();
	}
}
