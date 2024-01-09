package MLL_WMS_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		driver.get("https://logipickqa.mlldev.com/login");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("korivi");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome@123");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".log_in_bt ")).click();
	}
	
	

}
