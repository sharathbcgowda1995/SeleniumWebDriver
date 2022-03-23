package com.java.selenium.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interview {

	public static void main(String[] args) throws Exception {


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='mt-2 row']")).click();
		
		////div[@class='mt-2 row']
		
		

	}

}
