package larsonJuhl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LarsonJuhl001 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mcqa-shop.larsonjuhl.com/en-US/customer/account/login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("btn-cookie-allow")).click();
		//----------------Log-In------------
		driver.findElement(By.id("email")).sendKeys("parmindersingh@sourcemash.com");
		driver.findElement(By.id("pass")).sendKeys("@111%PARMDr");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("(//span[text()='Wood Moulding'])[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"layer-product-list\"]/div[2]/ol/li[1]/div/div/div[3]/a")).click();
		Thread.sleep(2000);
		WebElement unitOfMeasure = driver.findElement(By.id("unitofmeasure"));
		Select s = new Select(unitOfMeasure);
		s.selectByVisibleText("CHOP");
		
		
		driver.findElement(By.id("product_height")).sendKeys("8");
		driver.findElement(By.id("product_width")).sendKeys("8");
		driver.findElement(By.xpath("//button[text()='Calculate Price']")).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add To Cart']"));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
		
		
		WebElement myCart = driver.findElement(By.xpath("//*[@id=\"minicart-wrapper\"]/a/i"));
		myCart.click();
		//delete the product from cart
		//driver.findElement(By.id("deleteCartItem-89807")).click();
		Thread.sleep(2000);
		//Edit the Item
		driver.findElement(By.id("editCartItem-89909")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("qty")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("qty")).sendKeys("2");
		Thread.sleep(2000);
		driver.findElement(By.id("update-item")).click();
		Thread.sleep(2000);
		//Proceed to Checkout
		WebElement proceed = driver.findElement(By.xpath("//span[text()='Proceed To Checkout']"));
		wait.until(ExpectedConditions.elementToBeClickable(proceed)).click();
		
		Thread.sleep(7000);
		Actions a = new Actions(driver);
		WebElement submitBtn = driver.findElement(By.xpath("//span[text()='Submit Order']"));
		a.moveToElement(submitBtn).click(submitBtn).perform();
		
		
		System.out.println("Test Case is Pass");
		driver.close();
		

	}

}
