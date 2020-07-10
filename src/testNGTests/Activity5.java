package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void LaunchBrowser() {
		driver=new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test(groups= {"HeaderTests","ButtonTests"})
	public void GetTitle() {
		Assert.assertEquals("Target Practice",driver.getTitle());
		System.out.println("Title-"+driver.getTitle());
	}
	@Test(dependsOnMethods = "GetTitle",groups = {"HeaderTests"})
	public void HeaderTest() {
		System.out.println("Header Test");
		Assert.assertEquals("Third header"
				,driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("ui green header"
				,driver.findElement(By.xpath("//h5[text()='Fifth header']")).getAttribute("class"));
	}
	
	@Test(dependsOnMethods = "GetTitle",groups = {"ButtonTests"})
	public void ButtonTest() {
		System.out.println("Button Test");
		Assert.assertEquals("Olive"
				,driver.findElement(By.xpath("//button[@class='ui olive button']")).getText());
		Assert.assertEquals("Brown"
				,driver.findElement(By.xpath("(//div[@class='column'])[2]/div[3]/button[1]")).getText());
	}
	
	@AfterClass(alwaysRun = true)
	public void CloseBrowser() {
		driver.close();
	}

}
