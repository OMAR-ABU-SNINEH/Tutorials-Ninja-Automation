package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_RF_004 {

	WebDriver driver;

//	public void backPage() {
//		driver.navigate().back();
//	}

	public WebElement errorMsg(WebElement elementField) {
		return elementField.findElement(By.xpath("./following-sibling::div[@class='text-danger']"));
	}

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// 1~15
		driver.get("https://tutorialsninja.com/demo/");

	}

	@Test(priority = 1, enabled = true)
	public void registerWithoutEnterAnything() throws InterruptedException {

		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();

		WebElement registerBtn = driver.findElement(By.linkText("Register"));
		registerBtn.click();

		WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueBtn.click();

		WebElement firstNameField = driver.findElement(By.id("input-firstname"));

		WebElement lastNameField = driver.findElement(By.id("input-lastname"));

		WebElement emailField = driver.findElement(By.id("input-email"));

		WebElement phoneField = driver.findElement(By.id("input-telephone"));

		WebElement passwordField = driver.findElement(By.id("input-password"));

		WebElement passwordConField = driver.findElement(By.id("input-confirm"));

		WebElement checkPolicy = driver.findElement(By.name("agree"));

		WebElement firstNameDiv = errorMsg(firstNameField);
		WebElement lastNameDiv = errorMsg(lastNameField);
		WebElement emailDiv = errorMsg(emailField);
		WebElement phoneFieldDiv = errorMsg(phoneField);
		WebElement passwordFieldDiv = errorMsg(passwordField);

		String actualFirstNameError = firstNameDiv.getText();
		String expectFirstNameError = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualFirstNameError, expectFirstNameError);

		String actualLastNameError = lastNameDiv.getText();
		String expectLastNameError = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(actualLastNameError, expectLastNameError);

		String actualMailError = emailDiv.getText();
		String expectMailError = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(actualMailError, expectMailError);

		String actualPhoneError = phoneFieldDiv.getText();
		String expectPhoneError = "Telephone must be between 3 and 32 characters!";
		Assert.assertEquals(actualPhoneError, expectPhoneError);

		String actualPassError = passwordFieldDiv.getText();
		String expectPassError = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(actualPassError, expectPassError);
	}

	@AfterTest
	public void cleanUp() {

		if (driver != null) {
			driver.quit();
		}

	}
}
