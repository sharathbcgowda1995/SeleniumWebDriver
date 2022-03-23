package Locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsInSelenium {

	public static void main(String[] args) {
		
		//1st step in all the automation script.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//inplicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//write a code to perform the actions.
		driver.get("https://sso.teachable.com/secure/9521/identity/login");
		
		//Selenium webdriver locators
		driver.findElement(By.name("email")).sendKeys("sharath");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.className("button")).click();
		
		//Css selector
		System.out.println(driver.findElement(By.cssSelector("div.bodySmall")).getText());
		
		//linkText
		//driver.findElement(By.linkText("Forgot Password")).click();
		
		//xpath
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Sharath B C");
		
		//driver.get("https://sso.teachable.com/secure/9521/identity/forgot_password");
		
		
		//Last step in all the script
		//driver.close();
		
		//if all the fields are having the same html attributes then go for the indexing.
		//driver.findElement(By.linkText("Sign Up")).click();
		driver.get("https://sso.teachable.com/secure/9521/identity/sign_up/with_email");
		
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Sharath B C");
		
		driver.findElement(By.id("user_email")).sendKeys("sharathbchinniah@gmail.com");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sharath@1234");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sharath@1234");
		
		driver.findElement(By.name("allow_marketing_emails")).click();	
		
		driver.findElement(By.cssSelector("input.button")).click();
		
		
		

	}

}
