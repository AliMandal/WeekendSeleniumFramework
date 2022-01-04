package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin()
	{
		
	Logger log=	LogManager.getLogger(TestValidLogin.class.getName());
	
		
		//enter username
	log.debug("Object creation successfully");
	
		
		LoginPage lp=new LoginPage(driver);
		log.info("successful");
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		lp.setUserName(username);
		
		//enter password
		String password = Lib.getCellValue("ValidLogin", 1, 1);// cntrl+1+enter to see the return type. To  fetch the value from excel sheet we are calling getcellvalue method from Lib class, and we are passing the sheet name , and row and column  number from the excel.
		lp.setPassword(password);// In Logingpage class we createed this setpassword and setusername method, we created one object of loginpage  and using this object we are calling this methos
		
		//click on the login
		
         lp.clickLogin();
        // Assert.fail();// forcefully fail the method using this.
		
		
	}

}
// Execute both testinvalid and testvalid class after converting them into suite file.