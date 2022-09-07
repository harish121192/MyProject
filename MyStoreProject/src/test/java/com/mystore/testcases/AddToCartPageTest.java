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
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Sriharish
 *
 */
public class AddToCartPageTest  extends BaseClass  {
	
		
		IndexPage indexpage;
		SearchResultPage searchresultpage;
		AddToCartPage addtocartpage;	
		
		 @Parameters("browser")
		@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		public void setup(String browser) {

			launchApp(browser);
			
			
					}
		

		@AfterMethod(groups= {"Smoke","Sanity","Regression"})
		public void tearDown() {
			
			getDriver().quit();
		}
		
		@Test(groups= {"Regression", "Sanity" })
		public void productAvailabilityTest() {
			
			indexpage = new IndexPage();
			searchresultpage = indexpage.searchProduct("t-shirt");
			addtocartpage = searchresultpage.clickOnProduct();
			addtocartpage.enterQuantity("2");
			addtocartpage.selectSize("M");
			addtocartpage.clickOnAddToCart();
			boolean result = addtocartpage.validateAddToCart();
			Assert.assertTrue(result);
}
		
		
}
