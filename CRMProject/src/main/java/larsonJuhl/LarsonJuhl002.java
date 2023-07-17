package larsonJuhl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class LarsonJuhl002 {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mcqa-shop.larsonjuhl.com/en-US/customer/account/login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testcase()throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("parmindersingh@sourcemash.com");
		driver.findElement(By.id("pass")).sendKeys("@111%PARMDr");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("(//span[text()='Wood Moulding'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Width']")).click();
		driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[2]/label/a")).click();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		driver.findElement(By.xpath("//div[text()='Height']")).click();
		
		
		
		
		try {
			//driver.findElement(By.xpath("//div[text()='Height']")).click();
		}
		catch (StaleElementReferenceException e) {
			WebElement heightFilter = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[2]/label/a"));
			
			a.moveToElement(heightFilter).click().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Color Family']")).click();
			driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[6]/div[2]/ol/li[3]/label/a")).click();
		}
		
		Thread.sleep(2000);
	}
	/*@AfterMethod
	public void teardown() {
		driver.quit();
	}*///CRM should be opened and qualify option should be over there when user clicks on that  link.

	
	
	

}
