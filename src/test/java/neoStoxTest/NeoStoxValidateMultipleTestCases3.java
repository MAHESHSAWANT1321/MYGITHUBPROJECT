package neoStoxTest;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxLoginPage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSinginPage;
import neoStoxUtillity.NewUtility;
import neoStoxNewBase.NewBase1;
@Listeners(listener.ListenerNew.class)
public class NeoStoxValidateMultipleTestCases3  extends NewBase1
{
	
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeoStoxSinginPage Singin;

	@BeforeClass
	public void launchNeoStox() throws InterruptedException, IOException
	{
    launchBrowser();
	login=new NeoStoxLoginPage(driver);
	password=new NeoStoxPasswordPage(driver);
	home=new NeoStoxHomePage(driver);
	Singin=new NeoStoxSinginPage(driver);
	}
	@BeforeMethod
	public void  loginIntoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException 
	
	{
		Thread.sleep(3000);
		Singin.ClickOnSinginButton(driver);
		Thread.sleep(1000);
        login.sendMobileNum(driver, NewUtility.readDataFromPropertyFile("MobileNo"));
        NewUtility.wait(driver,3000);
		login.ClickOnSingInButton(driver);
		NewUtility.wait(driver,3000);
		password.enterPassword(driver,NewUtility.readDataFromPropertyFile("PassWord"));
		Thread.sleep(3000);
		password.ClickOnSubmitButtons(driver);
		Thread.sleep(3000);
		home.handelPopUp(driver);
		NewUtility.wait(driver, 3000);
		}
	
	
	
	
	
	
@Test
public void userID() throws EncryptedDocumentException, IOException 
  {
	  Assert.assertEquals(home.getActualUserName(driver),NewUtility.readDataFromPropertyFile("UserName"),"TC is failed Actual and expected user name are not maching");
  //NewUtility.screenshot(driver,home.getActualUserName(driver));
  }


@Test(priority = -1)
public void validateAccBalance() throws IOException, InterruptedException
{
	Thread.sleep(2000);
Assert.assertNotNull(home.getAccBalance(driver), "TC is failed Unable to fatch Account Balance");	
//NewUtility.screenshot(driver,"ACCBalance");
//Assert.fail();
Reporter.log("========================", true);
}


@AfterMethod
public void logOutFromNeoStox()
{
home.logOut(driver);
}









@AfterClass
public void closwBrowser()
{
	Reporter.log("Closing Browser", true);
driver.close();	

}
}
