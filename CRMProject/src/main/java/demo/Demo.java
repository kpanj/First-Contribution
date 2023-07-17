package demo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Demo {

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
		
		Thread.sleep(2000);
		WebElement filterText = driver.findElement(By.id("quickFind_text_0"));
		wait.until(ExpectedConditions.elementToBeClickable(filterText)).sendKeys("52003");
		Thread.sleep(2000);
		driver.findElement(By.id("quickFind_arrow_button_0")).click();
		
		
		WebElement account = driver.findElement(By.xpath("//span[text()='ATLANTA MISC. CUSTOMER!!']"));
		wait.until(ExpectedConditions.elementToBeClickable(account)).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)","");
		js.executeScript("window.scrollBy(0,5000)");
		
		//driver.findElement(By.xpath("//*[@id=\"myTab\"]/li[1]")).sendKeys(Keys.PAGE_DOWN);
		
		//driver.switchTo().frame("WebResource_lj_AlertsOnAccount");
//		WebElement scroll = driver.findElement(By.id("info-tab"));
//		Actions a = new Actions(driver);
//		a.moveToElement(scroll);
//		a.perform();
		
		driver.findElement(By.xpath("//span[text()='Price Management Tool']")).click();
		WebElement sizeofFrame = driver.findElement(By.tagName("iframe"));
		System.out.println(sizeofFrame.getSize());
		//Thread.sleep(2000);
		//driver.switchTo().frame("FullPageWebResource");
		driver.switchTo().frame(1);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//button[text()='Review'])[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"tr0\"]/td[11]/button[1]")).click();
		//Thread.sleep(2000);
		
		driver.close();
		

	}

}
