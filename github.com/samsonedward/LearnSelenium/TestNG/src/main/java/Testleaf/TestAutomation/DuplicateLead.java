package Testleaf.TestAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class DuplicateLead extends GenericWrappers {

	@Test
	public void DuplicateLead() throws InterruptedException {

		// Initialize Web Driver and URL
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		// Entering UserName and Password for login and login
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		// Click on "CRM/SFA" link
		clickByLink("CRM/SFA");
		clickByLink("Leads");
		clickByLink("Find Leads");

		clickByXpath("//span[text()='Phone']");
		enterByXpath("//input[@name='phoneNumber']", "99");
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		clickByLink("Duplicate Lead");
		clickByClassName("smallSubmit");

		closeBrowser();

	}
}
