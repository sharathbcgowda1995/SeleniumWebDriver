package com.java.selenium.streams;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingWebElementsUsingJavaStreams {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on the offer button to fetch the sorted elemnts.
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();

		// Now get all the elements whether they have sorted or not.
		List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));

		// you have got all the elements check the fruits are sorted or not and store
		// them
		List<String> sortedOriginal = webElements.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Now perform the sorting on the original one using the stream.
		List<String> sortedFromOriginal = sortedOriginal.stream().sorted().collect(Collectors.toList());

		// Perform assert operation.
		Assert.assertEquals(sortedOriginal, sortedFromOriginal);

	}

}
