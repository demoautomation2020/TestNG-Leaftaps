package Testleaf.TestAutomation;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class FindLead extends GenericWrappers {
@Test
	public  void DuplicateLead() throws InterruptedException {
				
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
		clickByLink("Leads");
		clickByLink("Find Leads");
		clickByXpath("//span[contains(text(),'Email')]");
		enterByName("emailAddress", "mailtosam.cts@gmail.com");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		String leadName= getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		Thread.sleep(3000);		
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		clickByLink("Duplicate Lead");
		verifyTitle("Duplicate Lead");
		clickByClassName("smallSubmit");
		verifyTextById("viewLead_firstName_sp", leadName);

	}

}
