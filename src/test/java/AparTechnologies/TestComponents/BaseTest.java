package AparTechnologies.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AparTechnologies.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\tarun\\eclipse-workspace\\Framework\\SeleniumFrameworkDesign\\src\\main\\java\\AparTechnologies\\resources\\GlobalData.properties");
		properties.load(fis);
		String browserName = System.getProperty("browser")!= null ? System.getProperty("browser") : properties.getProperty("browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(
				(System.getProperty("user.dir") + "//src//test//java//AparTechnologies//data//PurchaseOrder.json")),
				StandardCharsets.UTF_8);
		// next step is convert string into Hasmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenShot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApp() throws IOException {
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
