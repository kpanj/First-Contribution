package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCase {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://larsonjuhl-sandbox.crm.dynamics.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//username and click
		driver.findElement(By.id("i0116")).sendKeys("srvcqa@larsonjuhl.com");
		driver.findElement(By.id("idSIButton9")).click();
		
		//password and click
		driver.findElement(By.id("i0118")).sendKeys("S0urceM@$h");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		//clicked on no button
		driver.findElement(By.id("idBtn_Back")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		//Clicking on sales hub app
		driver.switchTo().frame("AppLandingPage");
		Thread.sleep(2000);
		WebElement salesHub = driver.findElement(By.xpath("//div[text()='Sales Hub']"));
		wait.until(ExpectedConditions.elementToBeClickable(salesHub)).click();
		
		WebElement cases = driver.findElement(By.xpath("//span[text()='Cases']"));
		wait.until(ExpectedConditions.elementToBeClickable(cases)).click();
		
		WebElement myActiveCases = driver.findElement(By.xpath("//span[text()='My Active Cases']"));
		wait.until(ExpectedConditions.elementToBeClickable(myActiveCases)).click();
		
		driver.findElement(By.xpath("//*[@id=\"incident|NoRelationship|HomePageGrid|Mscrm.NewRecordFromGrid41-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"id-7e7e22ed-4e50-4961-b612-625b0285f4b5-1-customerid270bd3db-d9af-4782-9025-509e298d"
				+ "ec0a-customerid.fieldControl-LookupResultsDropdown_customerid_0_textInputBox_with_filter_new\"]")).sendKeys("52003");
		driver.findElement(By.xpath("//*[@id=\"id-7e7e22ed-4e50-4961-b612-625b0285f4b5-10-title4273edbd-ac1d-40d3-9fb2-095c621b552d-title.fieldControl-text-box-text\"]")).sendKeys("TEstManish");
		
		
		
		
		
	}

}
