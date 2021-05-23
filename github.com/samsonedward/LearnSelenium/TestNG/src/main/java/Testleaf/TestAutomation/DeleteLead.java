package Testleaf.TestAutomation;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class DeleteLead extends GenericWrappers {

	@Test
	public void DeleteLead() throws InterruptedException {

		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		// Entering UserName and Password for login and login
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		// Click on "CRM/SFA" link
		clickByLink("CRM/SFA");

		// Clicking Phone in Find leads link
		clickByLink("Leads");

		// Click Findleads
		clickByLink("Find Leads");

		clickByXpath("//span[text()='Phone']");

		// Entering Phonenumber to Search
		enterByXpath("//input[@name='phoneNumber']", "9");

		// clicking Find leads link
		clickByXpath("//button[contains(text(),'Find Leads')]");

		Thread.sleep(3000);
		// Capture lead ID of First Resulting lead
		String leadId = getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a");

		// Click First Resulting lead
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");

		// Click Delete in View lead

		clickByClassName("subMenuButtonDangerous");

		// Click Findleads

		clickByLink("Find Leads");

		enterByXpath("//label[contains(text(),'Lead ID:')]//following-sibling::div/input", leadId);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		verifyTextContainsByXpath("//div[contains(text(),'No records to display')]", "No records to display");
	}

	}
		
		