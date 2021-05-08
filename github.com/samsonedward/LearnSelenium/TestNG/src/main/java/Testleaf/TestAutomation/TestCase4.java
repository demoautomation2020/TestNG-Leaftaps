package Testleaf.TestAutomation;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class TestCase4 extends GenericWrappers{

	@Test
	public void MergeLead() throws InterruptedException {
			
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		//Entering UserName and Password for login and login
		enterById("username","DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		//Click on "CRM/SFA" link
		clickByLink("CRM/SFA");
		
		//Clciking Phone in Find leads link
		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("//img[@alt='Lookup']");
		//Thread.sleep(3000);
		switchToLastWindow();
		enterById("ext-gen26","11446");
		clickById("ext-gen114");
		Thread.sleep(3000);
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		switchToParentWindow();
		System.out.println("switched to parent window");
		clickByXpath("(//img[@alt='Lookup'])[2]");
		Thread.sleep(3000);
		switchToLastWindow();
		enterById("ext-gen26","12634");
		clickById("ext-gen114");
		Thread.sleep(3000);
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		switchToParentWindow();
		clickByClassNameNoSnap("buttonDangerous");
		acceptAlert();
		clickByLink("Find Leads");
		enterByXpath("(//div[@class='x-form-item x-tab-item'])[1]/div/input","11446");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		verifyTextByClassName("x-paging-info","No records to display");

	}

}
