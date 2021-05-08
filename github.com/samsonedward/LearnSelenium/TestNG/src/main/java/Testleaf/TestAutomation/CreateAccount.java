package Testleaf.TestAutomation;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class CreateAccount extends GenericWrappers {
	@Test(groups = { "smoke", })
	public void CreateAccounts() {

		// Initialize Web Driver and URL
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		// Entering UserName and Password for login and login
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		// Click on "CRM/SFA" link
		clickByLink("CRM/SFA");

		// click on create Lead
		clickByLink("Create Account");

		// Entering the details in the form
		enterById("accountName", "ICICI Credit Card Account ");
		enterById("groupNameLocal", "Samson");
		enterById("officeSiteName", "Edward");
		enterById("annualRevenue", "120,0000,00");
		enterById("numberEmployees","5000");
		selectVisibileTextByxpath("//*[@id=\"ext-gen621\"]", "Partnership");
		
		 
		 
		 
		

		/*
		 * Select Class used for dropdown Select by value;
		 * 
		 * 
		 * //selectVisibileTextById("industryEnumId", "IND_SOFTWARE");
		 * 
		 * enterByName("numberEmployees", "250000"); enterByName("sicCode", "4444");
		 * 
		 * selectVisibileTextById("dataSourceId", "LEAD_EMPLOYEE");
		 * selectVisibileTextById("marketingCampaignId", "CATRQ_AUTOMOBILE");
		 * selectVisibileTextById("initialTeamPartyId", "DemoSalesTeam2");
		 * enterByName("description", "Create Account in Testleaf	");
		 * enterByName("importantNote", "Leaf taps Applications	");
		 * enterByName("primaryPhoneAreaCode","91");
		 */

	}

	private void selectVisibileTextByxpath(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	private void selectVisibileTextbyxpath(String string) {
		// TODO Auto-generated method stub
		
	}

}
