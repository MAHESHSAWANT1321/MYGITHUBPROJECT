package neoStoxPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtillity.NewUtility;
public class NeoStoxLoginPage 
{
@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement MobileNumField;
@FindBy(xpath ="(//a[text()='Sign In'])[2]") private WebElement SingInButtons;
public NeoStoxLoginPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}
public void  sendMobileNum(WebDriver driver,String mobNum)
{
	NewUtility.wait(driver, 1000);
	MobileNumField.sendKeys(mobNum);
	Reporter.log("Entering Mobile Number",true);
}
public void ClickOnSingInButton(WebDriver driver)
{
	NewUtility.wait(driver,1000);
	SingInButtons.click();
	Reporter.log("Clicing on SingIn Buttons",true);
}
}
