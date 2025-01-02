package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_RF_001 {

	WebDriver driver;

	public void backPage() {
		driver.navigate().back();
	}

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// 1~15
		driver.get("https://tutorialsninja.com/demo/");

	}

	@Test
	public void myTest() {

	}

	@AfterTest
	public void cleanUp() {

		if (driver != null) {
			driver.quit();
		}

	}
}
