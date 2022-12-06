package com.qa.fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import org.testng.asserts.Assertion;


import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

	
	@Test
	public void validateSearch() {
		// set up chromedriver
		WebDriverManager.chromedriver().setup();
		
		// create a webdriver object
		WebDriver driver = new ChromeDriver();
		
		// open the url
		driver.get("https://www.google.com");
		
		// maximize the window
		driver.manage().window().maximize();
		
		// type the search
		driver.findElement(By.name("q")).sendKeys("fifa world cup 2022");
		
		// enter 
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		// capture the webelement
		WebElement firstLink = driver.findElement(By.xpath("(//div[@class='ofy7ae'])[1]"));
		String actualTest = firstLink.getText();
		
		String expected = "FIFA World Cup Qatar 2022™";
		
		
//		Assert.assertTrue(actualTest.equalsIgnoreCase(expected),
//				"Expected" +expected+ " but found >> " + actualTest);
		Assert.isTrue(actualTest.equalsIgnoreCase(expected), "Expected" +expected+ " but found >> " + actualTest );
	}
	

	
	
	
	
	
	
}
