package AparTechnologies.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AparTechnologies.TestComponents.BaseTest;
import AparTechnologies.pageobjects.LandingPage;
import AparTechnologies.pageobjects.OrderHistoryPage;
import AparTechnologies.pageobjects.ProductCatalogue;
import AparTechnologies.pageobjects.checkoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void testSubmitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

		LandingPage landingPage = launchApp();
		ProductCatalogue productcatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		driver.manage().window().maximize();

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("product"));
		productcatalogue.cartClick();
		productcatalogue.Checkout();
		Thread.sleep(3000);
		checkoutPage checkoutpage = new checkoutPage(driver);
		Thread.sleep(3000);
		checkoutpage.checkouts();
		Thread.sleep(3000);
		checkoutpage.lastSubmit();

	}

	@Test(dependsOnMethods= {"testSubmitOrder"})
	public void OrderHistoryTest() throws IOException {
		LandingPage landingPage = launchApp();
		ProductCatalogue productcatalogue = landingPage.loginApplication("akshita.sharma@gmail.com", "Tarun123@");
		OrderHistoryPage orderHistroyPage = productcatalogue.GoToOrderHistoryPage();
		Assert.assertTrue(orderHistroyPage.VerifyProductDisplayInOrderHistory(productName));
	}
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException  {
	
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+ "//src//test//java//AparTechnologies//data//PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
	}
	//@DataProvider
	//public Object [][] getData(){
		//return new Object[][] {{"akshita.sharma@gmail.com", "Tarun123@","ZARA COAT 3"},{"aloha@gmail.com","Tarun123@","ADIDAS ORIGINAL"}};
	//}
	
}
//
//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email", "akshita.sharma@gmail.com");
//map.put("password", "Tarun123@");
//map.put("productName", "ZARA COAT 3");

//return map;
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email", "aloha@gmail.com");
//map1.put("password", "Tarun123@");
//map1.put("productName", "ADIDAS ORIGINAL");
