package testNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity10 {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void LaunchBrowser() {
		Reporter.log("Before Test Browser Launch ");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/sliders");
		Reporter.log("Before Test Ended");
	}
	
	
	@Test(priority = 0)
	public void Middlevalue() {
		Actions builder=new Actions(driver);
		builder.clickAndHold(driver.findElement(By.id("slider")))
		.moveByOffset(0,50).release().perform();
	}
	
	@Test(priority = 1)
	public void MaximumValue() {
		Actions builder=new Actions(driver);
		builder.clickAndHold(driver.findElement(By.id("slider")))
		.moveByOffset(50,100).release().perform();
	}
	
	@Test(priority = 2)
	public void MinimumValue() {
		Actions builder=new Actions(driver);
		builder.clickAndHold(driver.findElement(By.id("slider")))
		.moveByOffset(100,0).release().perform();
	}
	
	@Test(priority = 3)
	public void ThirthyPercentageValue() {
		Actions builder=new Actions(driver);
		builder.clickAndHold(driver.findElement(By.id("slider")))
		.moveByOffset(0,30).release().perform();
	}
	
	@Test(priority = 4)
	public void EightyPercentageValue() {
		Actions builder=new Actions(driver);
		builder.clickAndHold(driver.findElement(By.id("slider")))
		.moveByOffset(30,80).release().perform();
	}
	
	
	@AfterTest
	public void CloseBrowser() {
		Reporter.log("After Test Started");
		//driver.close();
		Reporter.log("After Test Ended");
	}
	
	

}
