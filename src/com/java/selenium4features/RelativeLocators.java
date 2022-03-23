package com.java.selenium4features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;

import org.openqa.selenium.By;

public class RelativeLocators {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//WebElement element = driver.findElement(By.xpath("//input[contains(@class,'ng-touched')]"));

		WebElement element = driver.findElement(By.className("ng-touched"));
		
		String name = driver.findElement(with(By.tagName("label")).above(element)).getText();

		System.out.println(name);

	}

}
