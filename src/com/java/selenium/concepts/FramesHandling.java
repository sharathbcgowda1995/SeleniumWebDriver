package com.java.selenium.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		driver.get("https://jqueryui.com/droppable/");

		// Switch to the frame first.
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		// Use the actions class to perform the operations of dragging
		Actions a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		
		Thread.sleep(3000);

		// once the drag and drop done we need to come back to perform other operations.
		// one more step written outside the frame context to show this.
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Accordion")).click();

	}

}
