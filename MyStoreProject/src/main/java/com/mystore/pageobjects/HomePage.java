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
public class HomePage extends BaseClass {

	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public HomePage() {	
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean validateMyWishLIst() {
		return Action.isDisplayed(getDriver(), myWishList);
		
	}
	
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), orderHistory);
		
	}
	
	public String getCurrentUrl() {
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}
}
