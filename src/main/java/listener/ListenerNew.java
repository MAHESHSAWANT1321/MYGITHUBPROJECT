package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxNewBase.NewBase1;
import neoStoxUtillity.NewUtility;

public class ListenerNew extends NewBase1 implements ITestListener
{

public void onTestFailure(ITestResult result)
{
	String TCName = result.getName();
Reporter.log(TCName+"Test Case Failed Please Try Again....",true);
try {
	NewUtility.screenshot(driver, TCName);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
public void onTestSuccess(ITestResult result)
{
Reporter.log(result.getName()+"Test Case Is Successfully Execute",true);
}

public void onTestSkipped(ITestResult result)
{
Reporter.log(result.getName()+"Test Case is Skipped Please Check",true);	
}
}

