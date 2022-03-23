package com.java.selenium.concepts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHangling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

		// Window handling - new tab is also treated as new window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();

		// need to switch after handled the window
		driver.switchTo().window(child);

		String str = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		System.out.println(str);

		String splitted[] = str.split(" ");
//		for (int i = 0; i < splitted.length; i++) {
//			System.out.println(splitted[i]);
//		}		
//		String name = splitted[4];
//		System.out.println(name);
		
		//switch back to the parent window
		driver.switchTo().window(parent);
		
		//user name
		driver.findElement(By.id("username")).sendKeys(splitted[4]);

	}

}
