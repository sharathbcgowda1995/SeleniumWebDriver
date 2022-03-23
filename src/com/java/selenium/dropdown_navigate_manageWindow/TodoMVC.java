package com.java.selenium.dropdown_navigate_manageWindow;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TodoMVC {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://todomvc.com/");
		driver.manage().window().maximize();

		// select Backbone.js
		driver.findElement(By.linkText("Backbone.js")).click();

		String arr[] = { "one", "two", "three", "four", "five" };

		// creating 5 todos
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).click();
			driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys(arr[i]);
			Thread.sleep(2000);
		}

		// Delete the 5th element
		// Hover on it to select the delete option
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//li[4]//div[1]//label[1]"))).build().perform();
		driver.findElement(By.xpath("(//button[@class='destroy'])[4]")).click();

		// complete the tasks 1,2,5
		driver.findElement(By.xpath("//label[normalize-space()='One']")).click();
		driver.findElement(By.xpath("//label[normalize-space()='two']")).click();
		driver.findElement(By.xpath("//label[normalize-space()='five']")).click();
		driver.findElement(By.cssSelector(".clear-completed")).click();

		// left is 3
		driver.findElement(By.cssSelector("div[class='view'] label")).isDisplayed();
		
		//Only one is left
		Assert.assertEquals(driver.findElement(By.xpath("//input[@class='toggle']")).getSize(),1);

	}

}
