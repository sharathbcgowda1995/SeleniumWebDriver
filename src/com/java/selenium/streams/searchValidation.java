package com.java.selenium.streams;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class searchValidation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.id("search-field")).sendKeys("rice");

		List<WebElement> searchedElement = driver.findElements(By.xpath("//tr/td[1]"));

		List<WebElement> afterValidation = searchedElement.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());

		Assert.assertEquals(searchedElement.size(), afterValidation.size());

	}

}
