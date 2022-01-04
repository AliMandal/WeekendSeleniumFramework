package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest {

	@Test
	public void testInvalidLogin() throws InterruptedException
	{
		//enter username
		
				LoginPage lp=new LoginPage(driver);
				//In excel sheet we have multiple cell, to get each value we will use for loop, to execute
				int rowcount=Lib.getRowCount("InvalidLogin");
				System.out.println(rowcount);
				for (int i=1;i<=rowcount;i++)
				{
				String username = Lib.getCellValue("InvalidLogin", i, 0);
				lp.setUserName(username);
				 Thread.sleep(3000);
				 
				 
				 
				//enter password
				String password = Lib.getCellValue("InvalidLogin", i, 1);// cntrl+1+enter to see the return type. To  fetch the value from excel sheet we are calling getcellvalue method from Lib class, and we are passing the sheet name , and row and column  number from the excel.
				lp.setPassword(password);// In Logingpage class we createed this setpassword and setusername method, we created one object of loginpage  and using this object we are calling this methos
				Thread.sleep(3000);
				
				
				
				//click on the login
				
				lp.clickLogin();
				Thread.sleep(8000);
				}
	}
}
