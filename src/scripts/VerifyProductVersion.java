package scripts;

import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.EnterTimeTrackPage;
import pompages.LoginPage;

public class VerifyProductVersion extends BaseTest {
	
	@Test
	public void actiTimeProductVersion() throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		
		// String username = Lib.getCellValue("ValidLogin", 1, 0);
		lp.setUserName("admin");
		//String password = Lib.getCellValue("ValidLogin", 1, 1);
		lp.setPassword("manager");
		
		String expectedversion = Lib.getCellValue("ActitimeVersion", 1,0);
		System.out.println(expectedversion);
		lp.clickLogin();
		Thread.sleep(8000);
		
		EnterTimeTrackPage et=new EnterTimeTrackPage(driver);
		//Thread.sleep(8000);
		et.helpclk();
		
		Thread.sleep(5000);
		et.abtActi();
		// String actualtitle=driver.findElement(By.xpath("//span[@class='productVersion']")).getText();
		 String actualtitle=et.fetchP();
		System.out.println(actualtitle);
		SoftAssert sp = new SoftAssert();
		sp.assertEquals(actualtitle, expectedversion);
		driver.findElement(By.id("aboutPopupCloseButtonId")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("logoutLink"));
		sp.assertAll();
		
		
	}

}
