package com.java.selenium.streams;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateSeleniumMethodUsingStreams {

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

		List<String> price = webElements.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> getPriceOfVegie(s)).collect(Collectors.toList());
		price.forEach(s -> System.out.println(s));

	}

	public static String getPriceOfVegie(WebElement element) {
		 String price = element.findElement(By.xpath("following-sibling::td[1]")).getText();
		 return price;
	}

}
