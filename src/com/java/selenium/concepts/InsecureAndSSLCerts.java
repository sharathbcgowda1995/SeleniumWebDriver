//package com.java.selenium.concepts;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//public class InsecureAndSSLCerts {
//
//	public static void main(String[] args) {
//		
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\sharabc\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); 
//		
//		// SSl certificates
//
//		// 1.General desired capabilities
//		DesiredCapabilities ch = DesiredCapabilities.chrome();
//		
//		
//		// first way
//		ch.acceptInsecureCerts();
//		// Second way to accept the insecure and SSL but choose any one of them
//		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		
//		// 2. passing the general capabilities to the chrome options to merge
//		ChromeOptions c = new ChromeOptions();
//		c.merge(ch);
//
//		// 3.Set as usual and then pass it in the constructor
//		System.setProperty("webdriver.chrome.driver", "");
//		WebDriver driver = new ChromeDriver(c);
//		driver.get("www.---");
//
//	}
//
//}
