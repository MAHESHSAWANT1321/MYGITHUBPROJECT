package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtillity.NewUtility;
public class NeoStoxSinginPage
{
@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement SinginButton;



public NeoStoxSinginPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}

public void ClickOnSinginButton(WebDriver driver)
{
	NewUtility.wait(driver, 1000);
Reporter.log("Clicking on sing in button",true);
SinginButton.click();
}
}

