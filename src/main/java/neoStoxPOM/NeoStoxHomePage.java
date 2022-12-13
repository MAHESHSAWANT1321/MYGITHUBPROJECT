package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtillity.NewUtility;
public class NeoStoxHomePage 
{
@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement OkButtons;
@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement CloseButtons;
@FindBy(id = "lbl_username") private WebElement UserName;
@FindBy(id = "lbl_curbalancetop") private WebElement AccBalance;
@FindBy(xpath = "//span[text()='Logout']") private WebElement LogOutButton;
public NeoStoxHomePage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}



public void  handelPopUp(WebDriver driver) throws InterruptedException
{
	if(OkButtons.isDisplayed())
	{
	NewUtility.wait(driver,3000);
	OkButtons.click();
	Reporter.log("Clicking on Ok Buttons of PopUp",true);
	Thread.sleep(3000);
	NewUtility.wait(driver,3000);
	CloseButtons.click();
	Reporter.log("Clicking on Close Buttons",true);
	}
	
	else
	{
		Reporter.log("there is no popup", true);
		Thread.sleep(1000);
	}
}

public String getActualUserName(WebDriver driver)
{
	NewUtility.wait(driver, 2000);
	String actualUserName = UserName.getText();
	Reporter.log("geting actualUserName"+actualUserName, true);
//String realUserName = actualUserName.substring(3);
Reporter.log("Actual user name is"+actualUserName, true);
return actualUserName;
}

public String getAccBalance(WebDriver driver)
{
	NewUtility.wait(driver,2000);
	String accBalance = AccBalance.getText();
	Reporter.log("geting accBalance",true);
	Reporter.log("Account Balance is " +accBalance, true);
	return accBalance;
}


public void logOut(WebDriver driver)
{
NewUtility.wait(driver, 1000);
UserName.click();
NewUtility.wait(driver, 3000);
LogOutButton.click();
Reporter.log("Logging out", true);
}
}
