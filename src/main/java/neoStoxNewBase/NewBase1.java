package neoStoxNewBase;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import neoStoxNewBase.NewBase1;
import neoStoxUtillity.NewUtility;

public class NewBase1
{
	protected  static WebDriver driver;
	public void launchBrowser() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(NewUtility.readDataFromPropertyFile("URL"));
		Reporter.log("Launching Browser...",true);
		Thread.sleep(3000);

	
	
	
	
	
	}

}
