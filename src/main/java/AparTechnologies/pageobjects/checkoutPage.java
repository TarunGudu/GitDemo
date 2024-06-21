package AparTechnologies.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AparTechnologies.AbstractComponents.abstractComponents;

public class checkoutPage extends abstractComponents{
	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
    @FindBy(css=".btnn.action__submit.ng-star-inserted")
    WebElement actionSubmit;
    @FindBy(xpath="//body//app-root//button[2]")
    WebElement ele;
	public void checkouts() {
		selectCountry.sendKeys("Ind");
		ele.click();
		
		
		
	}
	public void lastSubmit() {
		actionSubmit.click();
	}
}
