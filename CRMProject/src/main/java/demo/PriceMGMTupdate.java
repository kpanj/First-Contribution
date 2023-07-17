package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceMGMTupdate {

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
		
		
		/*driver.switchTo().frame("FullPageWebResource");
		WebElement innerFrame2 = driver.findElement(By.xpath("//*[@id=\"iframe\"]/iframe"));
		driver.switchTo().frame(innerFrame2);*/
		//WebElement backtomainBtn = driver.findElement(By.id("hreflink"));
		Thread.sleep(5000);
		WebElement backtomainBtn = driver.findElement(By.xpath("//*[@id=\"hreflink\"]"));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(backtomainBtn)).click();
		Thread.sleep(2000);
		WebElement reviewBtn2 = driver.findElement(By.xpath("(//button[text()='Review'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(reviewBtn2)).click();
		Thread.sleep(15000);
		WebElement selectRanking = driver.findElement(By.id("opendrpdownbutton"));
		wait.until(ExpectedConditions.elementToBeClickable(selectRanking));
		driver.findElement(By.id("productgroup")).click();
		
		driver.findElement(By.id("pbutton")).click();
		driver.findElement(By.id("productgroup6")).click();
		
		driver.findElement(By.id("searchgroupdrp")).click();
		
		Thread.sleep(5000);
		
		WebElement costType = driver.findElement(By.id("costtype"));
		Select s = new Select(costType);
		s.selectByVisibleText("Base Price");
		
		driver.findElement(By.id("changecostfield")).sendKeys("5");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		
		System.out.println("Test Case is passed");
		
		driver.quit();
		

	}

}
