package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBus {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//From
		driver.findElement(By.id("src")).sendKeys("Kashmere Gate Delhi");
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[1]/div/ul/li[1]")).click();
		driver.findElement(By.id("dest")).sendKeys("Shimla");
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]/div/ul/li[1]")).click();
		
		driver.findElement(By.xpath("//label[@for='onward_cal']")).click();
		////*[@id="rb-calendar_onward_cal"]/table/tbody/tr[1]/td[3]
		for(int i=0;i<=3;i++) {
			driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]")).click();
		}
		driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[4]/td[5]")).click();
		driver.findElement(By.id("search_btn")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver,20);
		
		
		driver.findElement(By.xpath("(//div[text()='View Seats'])[1]")).click();
		
		WebElement seat = driver.findElement(By.xpath("//*[@id=\"rt_21916204\"]/div/div/div/div[2]/div[3]/div[2]/canvas"));
		Dimension dimention = seat.getSize();
		int x = dimention.getWidth()/2;
		int y = dimention.getHeight()/2;
		int button_x = (x / 3)*2;
		int button_y = (y / 3)*2;
		
		
		
		Actions a = new Actions(driver);
		a.moveToElement(seat, button_x, button_y).click().perform();
		
		
		
		
		
	}
	
}
