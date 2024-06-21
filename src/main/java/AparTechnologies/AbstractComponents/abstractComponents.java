package AparTechnologies.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AparTechnologies.pageobjects.OrderHistoryPage;

public class abstractComponents {
	WebDriver driver;
	public abstractComponents(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='/cart'] ")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement OrderHistoryButton;
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement findBy) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	public OrderHistoryPage GoToOrderHistoryPage() {
		OrderHistoryButton.click();
		OrderHistoryPage orderHistroyPage = new  OrderHistoryPage(driver);
		return orderHistroyPage;
	}
	
	public  void cartClick() {
		
		cartHeader.click();
		
	}
	
	
	public void invisibilityElementToBeDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
}
