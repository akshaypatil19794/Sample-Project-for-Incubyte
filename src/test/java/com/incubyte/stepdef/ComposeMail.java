package com.incubyte.stepdef;

import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.incubyte.base.BaseTestCase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComposeMail extends BaseTestCase {

	// We can pass data from excel sheet or json file.
	// we can also pass locators from object repository file.
	// We can avoid hard coding by doing so

	@Given("User launches Gmail web application")
	public void user_launches_Gmail_web_application() {
		try {
			launchBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User clicks on GmailButton")
	public void user_clicks_on_GmailButton() {
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
	}

	@When("User clicks on signButton")
	public void user_clicks_on_signButton() {
		driver.findElement(By.xpath("(//a[@class='h-c-header__nav-li-link '])[4]")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
	}

	@When("User enters EmailId in EmailTextField")
	public void user_enters_EmailId_in_EmailTextField() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email' and @autocomplete='username']")).sendKeys("userName");
	}

	@When("User clicks on NextButton")
	public void user_clicks_on_NextButton() {
		WebElement ele = driver.findElement(By.xpath("//div[@class='VfPpkd-Jh9lGc']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	// From below step gmail is not supporting for automation
	// Hence dummy xpath and dummy data is used for autoamtion
	
	@When("User enters Password in PasswordTextField")
	public void user_enters_Password_in_PasswordTextField() {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pwd");
	}
	
	@When("user clicks on compose mail")
	public void user_clicks_on_compose_mail() {
		driver.findElement(By.xpath("composemail button xpath")).click();
	}

	@When("user enters receiver email id")
	public void user_enters_receiver_email_id() {
		driver.findElement(By.xpath("//input[@type='receiver email']")).sendKeys("receiver email");
	}

	@When("user enters subject")
	public void user_enters_subject() {
		driver.findElement(By.xpath("//input[@type='subject']")).sendKeys("subject of email");
	}

	@When("user enters text email")
	public void user_enters_text_email() {
		driver.findElement(By.xpath("//input[@type='text message']")).sendKeys("message");
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		driver.findElement(By.xpath("send button xpath")).click();
	}

	@Then("user verify success message")
	public void user_verify_success_message() {
		String thisMessage = driver.findElement(By.xpath("successMessage xpath")).getText();
		assertThat("Success message is not matched : " ,thisMessage , equalTo("Expected message"));
	}

}
