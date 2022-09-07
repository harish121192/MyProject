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
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author Sriharish
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;
	
	 @Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {

		launchApp(browser);
		
				}
	

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void verifyCreateAccountPageTest() {
		
		indexpage = new IndexPage();
		loginpage = indexpage.clickOnSignIn();
		accountcreationpage = loginpage.createNewAccount("hajsdhjasd@gail.com");
		boolean result = accountcreationpage.validateAccountCreatePage();
		Assert.assertTrue(result);
		
	}

}
