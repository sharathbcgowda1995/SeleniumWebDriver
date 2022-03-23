package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsUsingTagName {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver dirver = new ChromeDriver();
		dirver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

//		dirver.get("https://sso.teachable.com/secure/9521/identity/login");
//		dirver.getCurrentUrl();
//		dirver.getClass();
//		dirver.findElement(By.className("form-input")).sendKeys("sharathbcgowda2@gmail.com");
//		dirver.findElement(By.id("password")).sendKeys("Rahul@1995");
//		dirver.findElement(By.cssSelector("input[class*='btn-primary']")).click();

		/*------upto above is paracticed and from today new concepts -----*/

		/* we use it when the web page is having unique tag */
		// dirver.findElement(By.tagName("i"));

		// One more operation Login.
		dirver.get("https://sso.teachable.com/secure/9521/identity/login");
		dirver.findElement(By.className("form-input")).sendKeys("sharathbcgowda2@gmail.com");
		dirver.findElement(By.id("password")).sendKeys("Rahul@1995");
		dirver.findElement(By.cssSelector("input[class*='btn-primary']")).click();
		Thread.sleep(3000);
		// System.out.println(dirver.findElement(By.className("navbar-current-user").g
		// dirver.findElement(By.className("navbar-current-user")).click();
		dirver.findElement(By.cssSelector("span[class='navbar-current-user']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(dirver.findElement(By.cssSelector("span[class='navbar-current-user']")).getText(),
				"Sharath B C");

		/*
		 * We can write the xpath locators for the link buttons where there is no <a tag
		 * using the text
		 */
		// dirver.findElement(By.xpath("button[text()='Log Out']")).click();
		
		/* using star but we can not use this if the two tags having the same of attribute */
		//dirver.findElement(By.xpath("*[text()='Log Out']")).click();

	}

}
