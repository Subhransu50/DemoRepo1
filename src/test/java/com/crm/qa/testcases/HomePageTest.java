package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;
//import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contact;
	DealsPage deal;
	TaskPage task;
	TestUtil testutil;
	//String SheetName="testdata";
	
	public HomePageTest()
	{
		super();
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][]=TestUtil.getTestData();
		return data;
	}
	
	Logger log=Logger.getLogger(HomePageTest.class);
	
@BeforeMethod()
public void login()
{
	log.info("Initializing the parameter");
	initialization();
	loginpage=new LoginPage();
	testutil=new TestUtil();
	contact=new  ContactPage();
	//homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	
}

@Test(priority=1,dataProvider="getTestData")
public void verifyHomePageTitleTest(String username,String password) throws Exception 
{
	log.info("Proceeding for login");
homepage=loginpage.login(username, password);
Thread.sleep(5000);
String a=homepage.verifyHomepageTitle();
log.info("Comparing between original and expected result");
Assert.assertEquals(a,"CRMPRO","Does not matched");
}

@Test(priority=3,dataProvider="getTestData")
public void verifyUserNameTest(String username,String password) throws Exception
{	log.info("Proceeding for login");
	homepage=loginpage.login(username, password);
	Thread.sleep(5000);
	log.info("Switch to a frame");
	testutil.switchToFrame();
	Thread.sleep(5000);
	log.info("Applying the validation");
Assert.assertTrue(homepage.verifyUserNamePage());
	
}
@Test(priority=2,dataProvider="getTestData")
public void clickOnContactListTest(String username,String password) throws Exception 
{	log.info("Proceeding for login");
	homepage=loginpage.login(username, password);
	Thread.sleep(15000);
	log.info("Switch to a frame");
testutil.switchToFrame();
Thread.sleep(5000);
log.info("Clicking over Contacts page");
	contact=homepage.clickOnContactsLink();
}


@AfterMethod
public void tearDown() throws Exception
{
	Thread.sleep(5000);
log.info("closing the browser");
	driver.quit();
}
}
