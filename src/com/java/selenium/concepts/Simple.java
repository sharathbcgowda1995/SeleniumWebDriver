package com.java.selenium.concepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Simple {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("Sharath B C");

		driver.findElement(By.cssSelector("input#confirmbtn")).click();

		Thread.sleep(3000);

		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,500)");
		
		int sum = 0;
		List<WebElement> values = driver.findElements(By.xpath("//td[4]"));
		
		for (int i = 0; i < values.size(); i++) {
			sum=sum+Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println(sum);
		

	}

}
