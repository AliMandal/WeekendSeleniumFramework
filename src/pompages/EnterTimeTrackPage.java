package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {
	
	//Click on help
	@FindBy(xpath="//div[@class='popup_menu_icon support_icon']")
	WebElement help;
	
	//Click on about your acti time
	

	@FindBy(xpath="//a[text()='About your actiTIME']")
	WebElement abtaActi;
	
	
	//Fetch the version
	@FindBy(xpath="//span[@class='productVersion']")
	WebElement Fetch;
	
//	@FindBy(className="infoTitle")
//	WebElement fetch;
	
	
//Initialize
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilize
	
	public void helpclk()
	{
		help.click();
	}
	
	public void abtActi()
	{
		abtaActi.click();
	}
	public String fetchP()
	{
		String s=Fetch.getText();
		return s;
	}
//	
	//get the product version
	//Check weather version is collect using soft assert
	//Close the product version window
	// click on logout
	

}
