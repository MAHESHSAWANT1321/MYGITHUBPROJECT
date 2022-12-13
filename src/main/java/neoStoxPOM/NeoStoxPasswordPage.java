package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtillity.NewUtility;
public class NeoStoxPasswordPage 
{
@FindBy(id = "txt_accesspin") private WebElement PassWordField;
@FindBy(xpath = "//a[text()='Submit']") private WebElement SubmitButtons;

public NeoStoxPasswordPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}


public void enterPassword(WebDriver driver,String Pass)
{
	NewUtility.wait(driver,3000);
	PassWordField.sendKeys(Pass);
	Reporter.log("Entering Password...",true);
}


public void ClickOnSubmitButtons(WebDriver driver)
{
	NewUtility.wait(driver, 3000);	
SubmitButtons.click();
Reporter.log("Clicking on Submit Buttons",true);
}
}
