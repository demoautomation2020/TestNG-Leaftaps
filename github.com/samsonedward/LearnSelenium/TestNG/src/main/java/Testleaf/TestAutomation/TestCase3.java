package Testleaf.TestAutomation;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class TestCase3 extends GenericWrappers {

	@Test
	public void deleteLead() throws InterruptedException {
				
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		//Entering UserName and Password for login and login
		enterById("username","DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		//Click on "CRM/SFA" link
		clickByLink("CRM/SFA");
		
		//Clciking Phone in Find leads link
		clickByLink("Leads");
		clickByLink("Find Leads");
		//clickByXpath("(//span[@class='x-tab-strip-text '])[2]");
		
		//Entering Phonenumber to Search
		enterByXpath("//input[@name='phoneNumber']","9876543210");
		
		//clicking Find leads link
		clickByXpath("//button[contains(text(),'Find Leads')]");
		
		Thread.sleep(3000);
		//Capture lead ID of First Resulting lead
		String leadId=getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]/a");
		
		//Click First Resulting lead
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		
		clickByClassName("subMenuButtonDangerous");
		clickByLink("Find Leads");
		
		enterByXpath("//label[contains(text(),'Lead ID:')]//following-sibling::div/input",leadId);
		
		clickByXpath("//button[contains(text(),'Find Leads')]");
		
		verifyTextContainsByXpath("//div[contains(text(),'No records to display')]","No records to display");

	}

	

}
