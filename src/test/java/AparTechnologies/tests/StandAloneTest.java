package AparTechnologies.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import AparTechnologies.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage = new LandingPage(driver);
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("tarunchaturvedi1020@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Tarun123@");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		// for(int i=0;i<products.size();i++) {
		// products.get(i).getText();
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
	}

}
