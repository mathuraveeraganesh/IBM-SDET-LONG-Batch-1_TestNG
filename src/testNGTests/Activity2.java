package testNGTests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		driver=new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void GetTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title,"Target Practice");
	}
	
	@Test
	public void Displayed() {
		WebElement eleDisplayed = driver.findElement(By.xpath("//button[@class='ui black button']"));
		Assert.assertFalse(eleDisplayed.isDisplayed());
	}
	
	@Test(enabled = false)
	public void EnabledSkip() {
		System.out.println("Method will be skipped, but will not be shown as skipped.");
	}
	
	@Test
	public void SkipMethod() {
		String TestCase="Skip";
		if(TestCase.contains("Skip")) 
			throw new SkipException("Method will be skipped and it will be shown as skipped");
		else
			System.out.println("Method will not be skipped");
		
	}
	
	@AfterClass
	public void CloseBrower() {
		driver.close();
	}

}
