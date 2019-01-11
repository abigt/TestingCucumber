package test.org.test;



import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.testng.Assert;

public class Test {

	WebDriver driver;
	@Given("User is in telecom page")
	public void user_is_in_telecom_page() {
	    
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.M.Abirami\\eclipse-workspace\\ZabiNew\\test\\Driver\\chromedriver.exe");
	    driver =  new ChromeDriver();
	    driver.get("http://demo.guru99.com/telecom/");
	}



	@Given("The user navigates to add customer page")
	public void the_user_navigates_to_add_customer_page() {
	 WebElement btnAddCust = driver.findElement(By.xpath("//a[text()='Add Customer']"));
	 btnAddCust.click();
	}

	@When("The user fill in the details")
	public void the_user_fill_in_the_details(io.cucumber.datatable.DataTable dataTable) {
		String rdBtn=null;
		Map<String,String> custMap = dataTable.asMap(String.class, String.class);
		if(custMap.get("BGCHECK").equals("Done"))
		{
			rdBtn="//label[@for = 'done']";
		}
		else if(custMap.get("BGCHECK").equals("Done"))
		{
			rdBtn="//label[@for = 'pending']";
		}
		WebElement btnRd= driver.findElement(By.xpath(rdBtn));
	    btnRd.click();
	    WebElement txtFname = driver.findElement(By.xpath("//input[@id='fname']"));
	    txtFname.sendKeys(custMap.get("FNAME"));
	    WebElement txtLname = driver.findElement(By.xpath("//input[@id='lname']"));
	    txtLname.sendKeys(custMap.get("LNAME"));
	    WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
	    txtEmail.sendKeys(custMap.get("EMAIL"));
	    WebElement txtAddress = driver.findElement(By.xpath("//textarea[@id='message']"));
	    txtAddress.sendKeys(custMap.get("ADDRESS"));
	    WebElement txtMobile = driver.findElement(By.xpath("//input[@id='telephoneno']"));
	    txtMobile.sendKeys(custMap.get("PHONE"));
	}

	

	@When("The user clicks submit button")
	public void the_user_clicks_submit_button() {
		WebElement btnSubmit= driver.findElement(By.xpath("//input[@name='submit']"));
		btnSubmit.click();
	}

	@Then("User should see the generated customer id")
	public void user_should_see_the_generated_customer_id() {
		String txtConfirm= driver.findElement(By.xpath("//section[@id='main']//table//td[@colspan='2']")).getText();
		System.out.println(txtConfirm);
       Assert.assertEquals(txtConfirm, "Please Note Down Your CustomerID");

	}

}
