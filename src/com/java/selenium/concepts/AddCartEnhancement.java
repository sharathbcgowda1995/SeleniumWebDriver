package com.java.selenium.concepts;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCartEnhancement {

	static String[] vegetables = { "Brocolli", "Tomato", "Mushroom", "Beans" };
	static List<String> vegiesInList = Arrays.asList(vegetables);
	static int numberOfProducts = vegetables.length;
	static int counter = 0;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Added explicit wait - specific to the locator
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		// code optimised
		add(driver, vegiesInList);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// Will wait for 5 seconds as we are giving the explicit wait here
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));

		System.out.println(driver.findElement(By.xpath("//span[text()='Code applied ..!']")).getText());

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		Thread.sleep(5000);
		driver.close();

	}

	static public void add(WebDriver driver, List<String> vegiesInList) {
		List<WebElement> vegList = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < vegList.size(); i++) {

			String veg = vegList.get(i).getText();

			String[] vegExreatcteName = veg.split("-");
			String finalExtractedName = vegExreatcteName[0].trim();
			System.out.println(finalExtractedName);

			if (vegiesInList.contains(finalExtractedName)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				counter++;

				if (counter == numberOfProducts) {
					System.out.println("Counter rached for maximum numberOfProducts : " + numberOfProducts);
					break;
				}
			}

		}
	}
}