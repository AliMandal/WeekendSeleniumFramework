package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static {
		
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	
	@BeforeMethod
	public void openApplication()
	{
	 driver=new FirefoxDriver();
		String url = Lib.getPropertyValue("URL");// cntrl+1+enter , here we are calling the static method getPropertyValue through class name,and passing the value of key, which is present in config value.
		driver.get(url); // It will launch the url which is present in config file
		String timeout=Lib.getPropertyValue("ITO");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void closeApplication(ITestResult res)
	{
		if(ITestResult.FAILURE==res.getStatus()) // ITestResult.FAILURE: by default it will return 2 if testmethod gets failed, getStatus():It will return 1 when testmethd gets passed, and return 2 when testmethod gets failed
		{
		Lib.captureScreenShot(driver, res.getName());// Getname() return test method name		
		}
		driver.close();
	}

}
