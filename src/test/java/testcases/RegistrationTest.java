package testcases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.TestBase;

@Listeners(testcases.IListeners.class)
public class RegistrationTest extends TestBase {

	@Test(priority = 1)
	public void FillingAllMondatoryFieldsWithValidCredentials() throws InterruptedException {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.name("firstname")).sendKeys("Md Arman");
		driver.findElement(By.name("lastname")).sendKeys("Khan");
		driver.findElement(By.name("email")).sendKeys("arman_" + timeStamp() + "@gmail.com");
		driver.findElement(By.name("telephone")).sendKeys("123456789");
		driver.findElement(By.name("password")).sendKeys("Armanjk@692334");
		driver.findElement(By.name("confirm")).sendKeys("Armanjk@692334");
		driver.findElement(By.cssSelector("input[value='1'][name='newsletter']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualSuccessfullRegistrationMessage = driver.findElement(By.xpath("//div[@id = 'content']/child :: h1"))
				.getText();
		System.out.println(actualSuccessfullRegistrationMessage);
		String expectedSuccessfullRegistrationMessage = "Your Account Has Been Created!";
		// Assert.assertTrue(actualSuccessfullRegistrationMessage.contains(expectedSuccessfullRegistrationMessage),
		// "false text appears");
		Assert.assertEquals(actualSuccessfullRegistrationMessage, expectedSuccessfullRegistrationMessage);
	}

	@Test(priority = 2)
	public void verifyRegistrationWithoutFillingAnyDetails() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

		String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]"))
				.getText();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),
				"Privacy Policy Warning not displaying");
		// Assert.assertEquals(actualPrivacyPolicyWarning,"Warning: You must agree to
		// the Privacy Policy!");

		String actualFirstNameWarning = driver
				.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertTrue(actualFirstNameWarning.contains("First Name must be between 1 and 32 characters!"),
				"First name warning message is not displayed");

		String actualLastNameWarning = driver
				.findElement(By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertTrue(actualLastNameWarning.contains("Last Name must be between 1 and 32 characters!"),
				"Last name warning message is not displayed");

		String emailWarning = driver
				.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]"))
				.getText();
		Assert.assertTrue(emailWarning.contains("E-Mail Address does not appear to be valid!"),
				"Email warning message is not displayed");

		String telephoneWarning = driver
				.findElement(By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]"))
				.getText();
		Assert.assertTrue(telephoneWarning.contains("Telephone must be between 3 and 32 characters!"),
				"Telephone warning message is not displayed");

		String passwordWarning = driver
				.findElement(By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]"))
				.getText();
		Assert.assertTrue(passwordWarning.contains("Password must be between 4 and 20 characters!"),
				"Telephone warning message is not displayed");

	}

	@Test(priority = 3)
	public void FillingRegistrationFormWithEmptyEmailBox() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.name("firstname")).sendKeys("Md Arman");
		driver.findElement(By.name("lastname")).sendKeys("Khan");
		driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.name("telephone")).sendKeys("123456789");
		driver.findElement(By.name("password")).sendKeys("Mypassword@123");
		driver.findElement(By.name("confirm")).sendKeys("Mypassword@123");
		driver.findElement(By.cssSelector("input[value='1'][name='newsletter']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningRegistrationMessage = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		System.out.println(actualWarningRegistrationMessage);
		String expectedWarningRegistrationMessage = "E-Mail Address does not appear to be valid!";
		// Assert.assertTrue(actualWarningRegistrationMessage.contains(expectedWarningRegistrationMessage),
		// "false text appears");
		Assert.assertEquals(actualWarningRegistrationMessage, expectedWarningRegistrationMessage);
	}

	@Test(priority = 4)
	public void FillingRegistrationFormWithRegisteredEmail() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.name("firstname")).sendKeys("Md Arman");
		driver.findElement(By.name("lastname")).sendKeys("Khan");
		driver.findElement(By.name("email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.name("telephone")).sendKeys("123456789");
		driver.findElement(By.name("password")).sendKeys("Mypassword@123");
		driver.findElement(By.name("confirm")).sendKeys("Mypassword@123");
		driver.findElement(By.cssSelector("input[value='1'][name='newsletter']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualSuccessfullRegistrationMessage = driver
				.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		System.out.println(actualSuccessfullRegistrationMessage);
		String expectedSuccessfullRegistrationMessage = "Warning: E-Mail Address is already registered!";
		// Assert.assertTrue(actualSuccessfullRegistrationMessage.contains(expectedSuccessfullRegistrationMessage),
		// "false text appears");
		Assert.assertEquals(actualSuccessfullRegistrationMessage, expectedSuccessfullRegistrationMessage);
	}

	@Test(priority = 5)
	public void FillingRegistrationFormWithInvalidPassword() throws InterruptedException {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.name("firstname")).sendKeys("Md Arman");
		driver.findElement(By.name("lastname")).sendKeys("Khan");
		driver.findElement(By.name("email")).sendKeys("arman_" + timeStamp() + "@gmail.com");
		driver.findElement(By.name("telephone")).sendKeys("976966184864");
		driver.findElement(By.name("password")).sendKeys("ie");
		driver.findElement(By.name("confirm")).sendKeys("ie");
		driver.findElement(By.cssSelector("input[value='1'][name='newsletter']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();

		String expectedWarningMessage = "Password must be between 4 and 20 characters!";
		// Assert.assertTrue(actualSuccessfullRegistrationMessage.contains(expectedWarningMessage),
		// "false text appears");
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
	}

}
