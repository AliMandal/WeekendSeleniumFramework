package generic;

public interface IAutoConstant {
	
	// Path of driver executable file [firefox and chrome]
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_PATH="./driver/geckodriver";
	
	String CHROME_KEY="webdriver.chrome.driver"; // 
	String CHROME_PATH="./driver/chromedriver";
	
	String EXCEL_PATH="./testdata/inputdata.xlsx"; // path of excel in inputdata
	String CONFIG_PATH="./config.properties"; // path of config file
	String SNAPSHOT_PATH="./screenshots/";
	

}
