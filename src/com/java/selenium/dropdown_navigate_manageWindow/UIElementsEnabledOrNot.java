package com.java.selenium.dropdown_navigate_manageWindow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UIElementsEnabledOrNot {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		// click dependent UI elemnt
		driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();

		// Method-1-check the UI element is enbled or not(Sometimes it won't work because
		// now a days few pages are enabled in backend if we click on them then they get
		// displayed)
		System.out.println(driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date2")).isEnabled());
		driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date2")).click();
		System.out.println(driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date2")).isEnabled());

		//Meth-2 we have a work around for this.
		System.out.println(driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date2")).getAttribute("style"));
		
		if(driver.findElement(By.cssSelector("span#spclearDate")).getAttribute("style").contains("display: block")) {
			System.out.println("UI element is Enabled");
			Assert.assertTrue(true);
		}else {
			System.out.println("UI element is not Enabled");
			Assert.assertFalse(false);
		}
		
		
		Thread.sleep(5000);
		driver.close();

	}

}
