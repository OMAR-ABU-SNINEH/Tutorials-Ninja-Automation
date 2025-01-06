package tutorialsninja.register;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_RF_003 {

	WebDriver driver;

//	public void backPage() {
//		driver.navigate().back();
//	}

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// 1~15
		driver.get("https://tutorialsninja.com/demo/");

	}

	@Test(priority = 1, enabled = true)
	public void registerWithAllFields() {

		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();

		WebElement registerBtn = driver.findElement(By.linkText("Register"));
		registerBtn.click();

		WebElement firstNameField = driver.findElement(By.id("input-firstname"));
		firstNameField.sendKeys("Omar");

		WebElement lastNameField = driver.findElement(By.id("input-lastname"));
		lastNameField.sendKeys("Abu Snineh");

		String randomEmail = "omar_" + UUID.randomUUID().toString().substring(0, 6) + "@gmail.com"; // UUID ~
																									// Universally
																									// Unique Identifier
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys(randomEmail);

		System.out.println("the email is " + randomEmail);

		WebElement phoneField = driver.findElement(By.id("input-telephone"));
		phoneField.sendKeys("078272800");

		WebElement passwordField = driver.findElement(By.id("input-password"));
		passwordField.sendKeys("12345678");

		WebElement passwordConField = driver.findElement(By.id("input-confirm"));
		passwordConField.sendKeys("12345678");

		WebElement newsletterSubscribeRadio = driver.findElement(By.cssSelector("input[value='1'][name='newsletter']"));
		newsletterSubscribeRadio.click();

		WebElement checkPolicy = driver.findElement(By.name("agree"));
		checkPolicy.click();

		WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueBtn.click();

		WebElement logout = driver.findElement(By.linkText("Logout"));

		boolean actualLogout = logout.isDisplayed();
		boolean expectLogout = true;
		Assert.assertEquals(actualLogout, expectLogout);

		WebElement createdAccountText = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

		String actualAccountText = createdAccountText.getText();
		String expectAccountText = "Your Account Has Been Created!";
		Assert.assertEquals(actualAccountText, expectAccountText);

		String actualProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";

		WebElement theDetailsDiv = driver.findElement(By.id("content"));

		Assert.assertTrue(theDetailsDiv.getText().contains(actualProperDetailsOne));
		Assert.assertTrue(theDetailsDiv.getText().contains(actualProperDetailsTwo));
		Assert.assertTrue(theDetailsDiv.getText().contains(actualProperDetailsThree));
		Assert.assertTrue(theDetailsDiv.getText().contains(actualProperDetailsFour));

		WebElement continueBtnOnSuccessPage = driver.findElement(By.linkText("Continue"));
		continueBtnOnSuccessPage.click();

		WebElement editAccountInfo = driver.findElement(By.linkText("Edit your account information"));
		boolean actualAccountInfoFound = editAccountInfo.isDisplayed();
		Assert.assertTrue(actualAccountInfoFound);
	}

	@AfterTest
	public void cleanUp() {

		if (driver != null) {
			driver.quit();
		}

	}
}
