package com.java.selenium.unwanted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDowns {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.findElement(By.id("withOptGroup")).click();
		driver.findElement(By.xpath("//div[@class='css-1uccc91-singleValue']")).click();

//		Load the driver
//		Load the url
//		click on the dropdown
//		xpath for the dropdown suggestions

	}

}
