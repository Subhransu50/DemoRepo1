package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest  extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	//static String SheetName="testdata";
	public LoginPageTest()throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=3)
	public void loginPageTitleTest()
	{
		String a=loginpage.validateLoginpageTitle();
		Assert.assertEquals(a, "Free CRM software in the cloud powers sales and customer service");
		
	}
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getTestDataa()
	{
		Object data[][]=TestUtil.getTestData();
		return data;
	}
	
	
	@Test(priority=1,dataProvider="getTestDataa")
	public void loginTest(String username,String password) throws Exception
	{
		//homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	homepage=	loginpage.login(username, password);
	}
	@AfterMethod
	public void tearDown() throws Exception
	{Thread.sleep(5000);
		driver.quit();
	}
}
