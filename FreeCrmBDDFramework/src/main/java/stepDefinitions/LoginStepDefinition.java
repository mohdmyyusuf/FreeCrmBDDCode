package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition{

	//LoginStepDefinition obj = new LoginStepDefinition();
	 public static WebDriver driver;
	 
	 private By loginLink=By.xpath("//a[@id = 'login2']");
//	 @FindBy(xpath = "//a[@id = 'login2']")
//	 @CacheLookup
//	 WebElement loginLink;
	 
	 @FindBy(xpath = "//input[@id = 'loginusername']")
	 @CacheLookup
	 WebElement user_name;
	 
	 @FindBy(xpath = "//input[@id = 'loginpassword']")
	 @CacheLookup
	 WebElement pass_word;
	 
	 @FindBy(xpath = "//button[@onclick = 'logIn()']")
	 @CacheLookup
	 WebElement loginbtn;
	 
	 
	
		
	 

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page() throws InterruptedException
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\myusuf\\Downloads\\CucumberSeleniumFramework-master\\CucumberSeleniumFramework-master\\tools\\updatedChromeDriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.demoblaze.com/index.html");
		 Thread.sleep(10000);
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM()
	 {
		 String title = driver.getTitle();
		 System.out.println(title);
		 try 
		 {
			 Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);
		 }
		 catch(AssertionError e) 
		 {
			 e.printStackTrace();
		 }
	 }
	
	 @Then("^user clicks login link$")
	 public void clickLoginLink() {
		 
		 driver.findElement(By.xpath("//a[@id = 'login2']")).click();
		 
		//((WebElement) loginLink).click();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
		 driver.findElement(By.xpath("//input[@id = 'loginusername']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@id = 'loginpassword']")).sendKeys(password);
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
		 
		 driver.findElement(By.xpath("//button[@onclick = 'logIn()']")).click();
//	 WebElement loginBtn =
//	 driver.findElement(By.xpath("//input[@type='submit']"));
//	 JavascriptExecutor js = (JavascriptExecutor)driver;
//	 js.executeScript("arguments[0].click();", loginBtn);
	 }
	
	
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page()
	 {
	  String title = driver.getTitle();
	  System.out.println("Home Page title ::"+ title);
	  Assert.assertEquals("STORE", title);
	 }
	 
	 @Then("^user moves to new contact page$")
	 public void user_moves_to_new_contact_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		
		}
	 
	 
	 @Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	 public void user_enters_contacts_details(String firstname, String lastname, String position){
		 driver.findElement(By.id("first_name")).sendKeys(firstname);
		 driver.findElement(By.id("surname")).sendKeys(lastname);
		 driver.findElement(By.id("company_position")).sendKeys(position);
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	 }
	 

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	

}
