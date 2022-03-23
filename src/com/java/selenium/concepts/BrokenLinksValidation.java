package com.java.selenium.concepts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksValidation {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// we can do it for a single element as well

		// need to take all the links by the generic locator another Locator is - $('li
		// a') , $('li[class="gf-li"] a')
		int size = driver.findElements(By.xpath("//li/a")).size();
		System.out.println(size);

		// 1.Take them in collection
		List<WebElement> links = driver.findElements(By.xpath("//li/a"));
		SoftAssert soft = new SoftAssert();

		// 2.Iterate them using the for each loop
		for (WebElement webElement : links) {
			// 3. Get Url
			String url = webElement.getAttribute("href");
			// 4.establishOpenConnection
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			// 5.Set the request method
			connection.setRequestMethod("GET");
			// 6.Made the connection
			connection.connect();
			// 7.Fetch the status code
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);

			// here the response code is not validated for the other links hence method two
			// written
			/*
			 * if (responseCode > 400) { System.out.println( "Broken link is : " +
			 * webElement.getText() + " with the response code is : " + responseCode);
			 * Assert.assertTrue(false); }
			 */

			// Method used for validation is softAssert
			soft.assertTrue(responseCode < 400,
					"Broken link is : " + webElement.getText() + " with the response code is : " + responseCode);

		}

		soft.assertAll();

		Thread.sleep(5000);
		driver.quit();

	}

}
