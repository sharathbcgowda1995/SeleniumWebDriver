package com.java.selenium.dropdown_navigate_manageWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDowns_Dynamic {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// This has to be used after we call the URL
		driver.manage().window().fullscreen();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		Thread.sleep(2000);//we are not clicking to option as once we select the from option it goes to To option directly
		
		//Few may not like this step so go with the parent child xpath
		//driver.findElement(By.xpath("(//a[@text='Chennai (MAA)'])[2]")).click();
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		Thread.sleep(5000);
		driver.close();
	}

}
