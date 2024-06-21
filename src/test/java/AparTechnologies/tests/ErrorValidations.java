package AparTechnologies.tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AparTechnologies.TestComponents.BaseTest;
import AparTechnologies.TestComponents.IRetryListeners;
import AparTechnologies.pageobjects.LandingPage;
import AparTechnologies.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {
//To test the negative scenario
	@Test(retryAnalyzer = IRetryListeners.class)
	public void ErrorValidation() throws InterruptedException, IOException {
		String productName= "ZARA COAT 3";
		LandingPage landingPage = launchApp();
		landingPage.loginApplication("yatharth123@gmail.com", "Tarun12@");
		driver.manage().window().maximize();
		//driver.findElement(By.cssSelector("div[aria-label='Incorrect email or password.']")).isDisplayed();
		Assert.assertEquals("Incorrect email password.", landingPage.getMeErrorMessage());
		
		
		
	}

}
