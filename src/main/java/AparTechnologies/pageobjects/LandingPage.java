package AparTechnologies.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AparTechnologies.AbstractComponents.abstractComponents;

public class LandingPage extends abstractComponents {
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail =driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement redTextErrorMessage;
	
	
	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}
	public WebElement getMeErrorMessage() {
		waitForElementToAppear(redTextErrorMessage);
		redTextErrorMessage.getText();
		return redTextErrorMessage;
	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}

