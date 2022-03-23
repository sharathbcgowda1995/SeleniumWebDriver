package Locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocatorsInDifferentWays {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://sso.teachable.com/secure/9521/identity/login");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sharathbcgowda2@gmail.com");

		// Using linktext
		driver.findElement(By.linkText("Forgot Password")).click();

		driver.findElement(By.cssSelector("input[type='Email']")).sendKeys("sharathbcgowda2@gmail.com");

		// Parent child tag using css selector
		// driver.findElement(By.cssSelector("div a")).click();

		// Parent child tag using xpath selector
		// driver.findElement(By.xpath("//div/a")).click();

		// driver.findElement(By.cssSelector("div input")).click();

		// driver.findElement(By.className("button")).click();

		// css selector we have to pass the complete class name
		//driver.findElement(By.cssSelector("input[class='btn-primary button p-v-2-xs p-h-5-xs m-v-3-xs col-5-xs']")).click();

		// css selector using regular expression
		// driver.findElement(By.cssSelector("input[class*='btn-primary']")).click();
		
		//xpath we have to pass the complete class
		//driver.findElement(By.xpath("//input[@class='btn-primary button p-v-2-xs p-h-5-xs m-v-3-xs col-5-xs']")).click();
		
		//xpath using regular expression.
		driver.findElement(By.xpath("//input[contains(@class,'button')]")).click();

		System.out.println(driver.findElement(By.cssSelector("p.m-t-1-xs")).getText());
		
		Thread.sleep(2000);
		
		driver.get("https://sso.teachable.com/secure/9521/identity/login");
		
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("sharathbcgowda2@gmail.com");
		//driver.findElement(By.cssSelector("input#email']")).sendKeys("sharathbcgowda2@gmail.com");//not working
		
		//driver.findElement(By.xpath("//div[@class='password-container']/input")).sendKeys("1235");
		//driver.findElement(By.cssSelector("//div[class='password-container']/input")).sendKeys("1234");//not working
		//driver.findElement(By.cssSelector("div input")).sendKeys("12345");//not working
		//driver.findElement(By.id("password")).sendKeys("234565");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("12345");
		
		driver.findElement(By.xpath("//div[@class='dsp-flex-xs flex-justify-content-center-xs']/input")).click();

		//driver.quit();

	}

}
