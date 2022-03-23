package com.java.selenium.dropdown_navigate_manageWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate_ManageWindow {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/");

		/* manage maximize */
		driver.manage().window().maximize();

		/* navigation of tabs */
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html");
		driver.navigate().back();

		Thread.sleep(3000);
		driver.close();

	}

}
