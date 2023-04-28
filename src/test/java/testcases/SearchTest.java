package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.TestBase;

@Listeners(testcases.IListeners.class)
public class SearchTest extends TestBase {

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys("Iphone");
		driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		Assert.assertTrue(driver.findElement(By.linkText("iPhone")).isDisplayed());
	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		driver.findElement(By.name("search")).sendKeys("TCL");
		driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		String actualInvalidProductMessage = driver
				.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]"))
				.getText();
		String expectedInvalidProductMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(actualInvalidProductMessage, expectedInvalidProductMessage);
	}

	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {

		driver.findElement(By.name("search"));
		driver.findElement(By.cssSelector("button.btn.btn-default")).click();
		String actualNoProductMessage = driver
				.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]"))
				.getText();
		String expectedNoProductMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(actualNoProductMessage, expectedNoProductMessage);
	}
}
