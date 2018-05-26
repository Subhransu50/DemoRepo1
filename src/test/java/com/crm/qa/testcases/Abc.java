package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;
//import org.testng.log4testng.Logger;

public class Abc extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contact;
	DealsPage deal;
	TaskPage task;
	TestUtil testutil;
	//What is log? : capturing info/activities at the time of program execution. 
	// types of logs:
		//1. info
		//2. warn
		//3. debug
		//4. fatal
		
	//how to generate the logs? : use Apache log4j API (log4j jar)
	//How it works? : it reads log 4j configuration from log4j.properties file
	//where to create: create inside resources folder
	
	WebDriver driver;
	public Abc()
	{
		super();
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][]=TestUtil.getTestData();
		return data;
	}
	Logger log = Logger.getLogger(Abc.class);
	
	
	@BeforeMethod
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");

		log.info("Initializing the parameter");
		initialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		contact=new  ContactPage();
	}
	
	
	@Test(priority=1)
	public void freeCrmTitleTest(String username,String password)throws Exception{
		loginpage.login(username, password);
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title is--->"+title);
		Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");

	}
	
	@Test(priority=2)
	public void freemCRMLogoTest(String username,String password)throws Exception{
		loginpage.login(username, password);
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");

		boolean b = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");

	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");

		
	}
	

}