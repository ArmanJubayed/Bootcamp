package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream data;

	@BeforeMethod
	public void setUp() throws IOException {
//		driver = new ChromeDriver();
		data = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\config.properties");
		prop = new Properties();
		prop.load(data);
		if ((prop.getProperty("browserName").equalsIgnoreCase("chrome"))) {
			driver = new ChromeDriver();
		} else if ((prop.getProperty("browserName").equalsIgnoreCase("edge"))) {
			driver = new EdgeDriver();
		} else if ((prop.getProperty("browserName").equalsIgnoreCase("firefox"))) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	public String timeStamp() {

		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return timeStamp;

	}
}