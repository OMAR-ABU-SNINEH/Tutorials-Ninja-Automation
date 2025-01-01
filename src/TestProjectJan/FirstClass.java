package TestProjectJan;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstClass {

	WebDriver driver;

	public void backPage() {
		driver.navigate().back();
	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
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
