package com.java.selenium.concepts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingGrids {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

		// need traverse to the component using the parent child relationship
		List<WebElement> elements = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;
		for (int i = 0; i < elements.size(); i++) {
			sum = sum + Integer.parseInt(elements.get(i).getText());
		}
		System.out.println(sum);

		// For validation purpose with the total mentioned in page
		int sumAnotherWay = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		String str[] = driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ");
		String sumcomp = "296";
		for (int i = 0; i < str.length; i++) {
			if (str[i].contentEquals(sumcomp)) {
				Assert.assertEquals(Integer.parseInt(str[i]), sumAnotherWay);
				System.out.println("Both are equal");
			}
		}
	}

}
