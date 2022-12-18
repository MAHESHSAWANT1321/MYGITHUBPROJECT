package neoStoxUtillity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;


public class NewUtility 
{

	public static String readDataFromPropertyFile(String key) throws IOException
	{
	//Create Object Of Properties Class
Properties prop=new Properties();
//Create Object Of FileInputStream and Propeties file path as a Parameter
FileInputStream myfile =new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\MY_PROJECTS\\NeoStoxNew_.properties");
prop.load(myfile);
String value = prop.getProperty(key);
Reporter.log("Reading"+key+"from property file",true);
return value;
	}
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		wait(driver,500);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",element);
    Reporter.log("Scrolling Into View",true);
	}
	public static void wait(WebDriver driver , int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		Reporter.log("Waiting For"+waitTime+"ms",true);
	}
	public static void screenshot(WebDriver driver,String screenShotName) throws IOException
	{
		wait(driver,500);
		String Screenshot = RandomString.make(3);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\SreenShot\\Images\\"+screenShotName+Screenshot+".png");
		FileHandler.copy(src, dest);
		Reporter.log("Taking ScreenShot",true);
	}
	

}
