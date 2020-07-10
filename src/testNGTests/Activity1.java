package testNGTests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	
	@BeforeMethod
	public void Launch() {
		driver=new FirefoxDriver();
		driver.get("https://www.training-support.net");
	}
	
	@Test
	public void TestCase() {
		
		String title = driver.getTitle();
		System.out.println("The Title-"+title);
		Assert.assertEquals("Training Support", title);
		driver.findElement(By.id("about-link")).click();
		String title1 = driver.getTitle();
		System.out.println("The Title-"+title1);
		Assert.assertEquals(title1,"About Training Support");
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
