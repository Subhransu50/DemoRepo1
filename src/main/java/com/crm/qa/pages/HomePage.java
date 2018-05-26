package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
/*@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
WebElement userNameLabel;*/

//@FindBy(xpath="html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")
	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	
WebElement userNameLabel;

/*@FindBy(xpath="//a[contains(text(),'Contacts']")
WebElement contactlink;*/
@FindBy(xpath=".//*[@id='navmenu']/ul/li[4]/a")
WebElement contactlink;

@FindBy(xpath=".//*[@id='navmenu']/ul/li[5]/a")
WebElement dealsLink;

 @FindBy(xpath=".//*[@id='navmenu']/ul/li[6]/a")
 WebElement taskLink;
 
 public HomePage()
 {
	 PageFactory.initElements(driver, this);
 }
 
 public String verifyHomepageTitle()
 {
  return driver.getTitle();
 }
 
 public boolean verifyUserNamePage()
 {
	return userNameLabel.isDisplayed();
 }
 public ContactPage clickOnContactsLink()
 {
	 contactlink.click();
	 return new ContactPage();
 }
 
 public DealsPage clickOnDeals()
 {
	 dealsLink.click();
	 return new DealsPage();
 }
 
 public TaskPage clickOnTask()
 {
	 taskLink.click();
	 return new TaskPage();
 }

}
