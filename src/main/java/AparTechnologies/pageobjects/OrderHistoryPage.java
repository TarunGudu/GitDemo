package AparTechnologies.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AparTechnologies.AbstractComponents.abstractComponents;

public class OrderHistoryPage extends abstractComponents{
	WebDriver driver;
	public OrderHistoryPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productsInOrderHistory;
	

		public Boolean VerifyProductDisplayInOrderHistory(String productName) {
			Boolean match = productsInOrderHistory.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
			return match;
		}
	}

