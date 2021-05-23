package Testleaf.TestAutomation;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class RunDeleteLead extends GenericWrappers {

	@Test
	public void runDeleteLead() throws InterruptedException {

		// Initialize Web Driver and URL
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		// Entering UserName and Password for login and login
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		// Click on "CRM/SFA" link
		clickByLink("CRM/SFA");
		clickByLink("Create Lead");
		clickByLink("Find Leads");
		clickByXpath("//span[text()='Phone']");
		enterByXpath("//input[@name='phoneNumber']", "9");
		clickByXpath("//button[text()='Find Leads']");
		Thread.sleep(2000);
		WebElement leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		String lead = leadID.getAttribute("leadID");

		System.out.println("lead");

		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		clickByLink("Delete");

		driver.findElementByLinkText("Find Leads").click();

		// driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElementByClassName("x-paging-info").getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}

	}
}
