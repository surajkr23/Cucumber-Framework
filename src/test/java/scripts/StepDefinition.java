package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;



public class StepDefinition {
	public WebDriver driver;
	
	@Given("Open the browser and enter the valid URL")
	public void open_the_browser_and_enter_the_valid_url() {
		WebDriverManager.chromedriver().setup();
	   	driver=new ChromeDriver();
	   	driver.manage().window().maximize();
	   	driver.get("https://www.facebook.com/");
	   	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User enters valid username")
	public void user_enters_valid_username() {
		driver.findElement(By.id("email")).sendKeys("admin");
	}

	@When("User enters valid password")
	public void user_enters_valid_password() {
		driver.findElement(By.id("pass")).sendKeys("manager");

	}

	@When("Click on login button")
	public void click_on_login_button() {
	    driver.findElement(By.name("login")).click();
	}

	@Then("User should be in homepage of the application")
	public void user_should_be_in_homepage_of_the_application() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Facebook – log in or sign up");
		driver.close();
	}
}
