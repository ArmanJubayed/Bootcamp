package Pracice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
//		 Locators- 1.ID 2.ClassName 3.Name 4. LinkText 5.PartialLinkText 6.Xpath
//		 7. CSS Selector 8.Tag Name
		
		
}
}