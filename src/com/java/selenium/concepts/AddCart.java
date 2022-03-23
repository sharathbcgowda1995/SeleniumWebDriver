package com.java.selenium.concepts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCart {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		String[] vegetables = { "Brocolli", "Tomato", "Mushroom", "Beans" };
		int numberOfProducts = vegetables.length;
		int counter = 0;
		List<String> vegiesInList = Arrays.asList(vegetables);

		List<WebElement> vegList = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < vegList.size(); i++) {

			String veg = vegList.get(i).getText();

			String[] vegExreatcteName = veg.split("-");
			String finalExtractedName = vegExreatcteName[0].trim();
			System.out.println(finalExtractedName);

			if (vegiesInList.contains(finalExtractedName)) {

				// Commented because this locator is dynamic when we click it changes it's name
				// to added for some time during that the index will miss from name add to cart
				// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				counter++;

				if (counter == numberOfProducts) {
					System.out.println("Counter rached for maximum numberOfProducts : " + numberOfProducts);
					break;
				}
			}

		}

		Thread.sleep(5000);
		driver.close();

	}
}

//		for (WebElement webElement : vegList) {
//
//			String veg = webElement.getText();
//			String[] vegExreatcteName = veg.split("-");
//			String finalExtractedName = vegExreatcteName[0].trim();
//			System.out.println(finalExtractedName);
//			if (vegiesInList.contains(finalExtractedName)) {
//
//			}
//		}

// driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[" + i +
// "]")).click();