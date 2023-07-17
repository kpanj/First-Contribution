package genericLib;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public PropertyFile pdata = new PropertyFile();
	public WebDriverUtilities driverutilities = new WebDriverUtilities();
	
	
	@BeforeMethod
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pdata.getpropertydata("urlofCRM"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterMethod
	public void teardown(ITestResult res) throws IOException {
		int status = res.getStatus();
		String name = res.getName();
		if(status == 2) {
			Screenshot s = new Screenshot();
			s.getscreenshot(driver,name);
		}
		//driver.quit();
	}
	
	
}
