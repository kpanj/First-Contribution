package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountVerification {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://larsonjuhl-sandbox.crm.dynamics.com/");
		driver.get("https://larsonjuhl.crm.dynamics.com/");
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
		//(//div[@class='ms-StackItem truncatableText-479'])[1]
		
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Active Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		
		WebElement northAmerica = driver.findElement(By.xpath("//label[text()='All Accounts - North America']"));
		wait.until(ExpectedConditions.elementToBeClickable(northAmerica)).click();
		
		Thread.sleep(2000);
		WebElement filterText = driver.findElement(By.id("quickFind_text_0"));
		wait.until(ExpectedConditions.elementToBeClickable(filterText)).sendKeys("130075");
		Thread.sleep(2000);
		driver.findElement(By.id("quickFind_arrow_button_0")).click();
		
		driver.findElement(By.xpath("(//div[@class='ms-StackItem truncatableText-294'])[1]")).click();

	}

}
