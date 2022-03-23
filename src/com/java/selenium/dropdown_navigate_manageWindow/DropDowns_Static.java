package com.java.selenium.dropdown_navigate_manageWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDowns_Static {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// This has to be used after we call the URL
		driver.manage().window().fullscreen();

		// Mandatory steps for dropdowns
		WebElement static_dropdowns = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDowns = new Select(static_dropdowns);

		// Selecting using the Select class
		dropDowns.selectByIndex(1);
		System.out.println(dropDowns.getFirstSelectedOption().getText());
		dropDowns.selectByVisibleText("USD");
		System.out.println(dropDowns.getFirstSelectedOption().getText());
		dropDowns.selectByValue("AED");
		System.out.println(dropDowns.getFirstSelectedOption().getText());

		// Validation
		Assert.assertEquals(dropDowns.getFirstSelectedOption().getText(), "AED");
		

		Thread.sleep(5000);
		driver.close();
	}

}
