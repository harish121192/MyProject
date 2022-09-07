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
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author Sriharish
 *
 */
public class LoginPageTest extends BaseClass {
	
IndexPage indexpage;
LoginPage loginpage;
HomePage homepage;
	
@Parameters("browser")
@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
public void setup(String browser) {

	launchApp(browser);
	
			}
	

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		
		getDriver().quit();
	}
	
	@Test(dataProvider ="credentials", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String uname, String pswd ) throws InterruptedException {
		Log.startTestCase("loginTest");
		
		indexpage = new IndexPage();
		Log.info("user is going to click on SignIn");
		loginpage = indexpage.clickOnSignIn();
		Log.info("Enter username and password");
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = loginpage.login(uname,pswd);
		// Thread.sleep(5000);  For Firefox
		String actualURL = homepage.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to LogIn");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is success");
		Log.endTestCase("loginTest");
		
		
	}
	
}
