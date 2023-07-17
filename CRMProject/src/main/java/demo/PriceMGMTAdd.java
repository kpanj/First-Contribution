package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceMGMTAdd {

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
		
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Active Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		
		WebElement northAmerica = driver.findElement(By.xpath("//label[text()='All Accounts - North America']"));
		wait.until(ExpectedConditions.elementToBeClickable(northAmerica)).click();
		
		driver.findElement(By.xpath("//span[text()='Price Management Tool']")).click();
		WebElement sizeofFrame = driver.findElement(By.tagName("iframe"));
		System.out.println(sizeofFrame.getSize());
		Thread.sleep(2000);
		driver.switchTo().frame("FullPageWebResource");
		
		WebElement innerFrame = driver.findElement(By.xpath("//*[@id=\"iframe\"]/iframe"));
		driver.switchTo().frame(innerFrame);
		WebElement reviewBtn = driver.findElement(By.xpath("(//button[text()='Review'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(reviewBtn)).click();
		Thread.sleep(13000);
		WebElement addMode = driver.findElement(By.id("addmode"));
		//wait.until(ExpectedConditions.elementToBeClickable(addMode)).click();//exception occurrs
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",addMode );
		/*Actions a = new Actions(driver);
		a.moveToElement(addMode).click().build().perform();*/
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"opendrpdownbutton\"]")).click();
		driver.findElement(By.id("productgroup")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("srp2")).click();
		driver.findElement(By.id("srp4")).click();
		
		WebElement productGrpDD = driver.findElement(By.id("pbutton"));
		wait.until(ExpectedConditions.elementToBeClickable(productGrpDD)).click();
		
		driver.findElement(By.id("productgroup10")).click();
		
		WebElement srp2DD = driver.findElement(By.id("s2button"));
		wait.until(ExpectedConditions.elementToBeClickable(srp2DD)).click();
		driver.findElement(By.id("srp20")).click();
		
		WebElement srp4DD = driver.findElement(By.id("s4button"));
		wait.until(ExpectedConditions.elementToBeClickable(srp4DD)).click();
		driver.findElement(By.id("srp40")).click();
		
		driver.findElement(By.xpath("(//button[text()='Search'])[2]")).click();
		
		System.out.println("Test Case is passed");
		driver.quit();

	}

}
