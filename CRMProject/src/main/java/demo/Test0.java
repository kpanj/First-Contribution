package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test0 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dimension currentDimention = driver.manage().window().getSize();
		int height = currentDimention.getHeight();
		int width = currentDimention.getWidth();
		System.out.println("Current Height : "+height);
		System.out.println("Current Width : "+width);
		
		Dimension d = new Dimension(900,600);
		driver.manage().window().setSize(d);
		
		Dimension getDimension = driver.manage().window().getSize();
		int newHeight = getDimension.getHeight();
		int newWidth = getDimension.getWidth();
		System.out.println("New Height : "+newHeight);
		System.out.println("New Width : "+newWidth);
	}

}
