package AparTechnologies.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import AparTechnologies.TestComponents.BaseTest;
import AparTechnologies.pageobjects.LandingPage;
import AparTechnologies.pageobjects.ProductCatalogue;
import AparTechnologies.pageobjects.checkoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalogue productcatalogue;
	public checkoutPage checkoutpage;
	
    @Given("I landed on LoginPage")
    public void I_landed_on_LoginPage() throws IOException {
    	landingPage=launchApp();
    }
    @Given ("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String username, String password) {
    	productcatalogue = landingPage.loginApplication(username, password);
    }
    //When I add product <productName> to cart
    @When("^I add product (.+) to cart$")
    public void I_add_product_to_cart(String productName) throws InterruptedException {
    	List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		productcatalogue.cartClick();
    	productcatalogue.Checkout();
    }
    //Then Checkout <productName> and submit the order
    @Then("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productName) {
    	checkoutPage checkoutpage = new checkoutPage(driver);
		checkoutpage.checkouts();
		checkoutpage.lastSubmit();

    	

    }
}
