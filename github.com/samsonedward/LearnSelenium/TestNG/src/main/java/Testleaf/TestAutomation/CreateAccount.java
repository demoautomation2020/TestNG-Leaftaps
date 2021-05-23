package Testleaf.TestAutomation;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class CreateAccount extends GenericWrappers {
	@Test
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
		enterById("numberEmployees", "5000");
		enterById("annualRevenue", "120,0000,00");

		/* Select Class used for dropdown Select by value; */
		selectVisibileTextById("currencyUomId", "ALL - Albanian Lek");
		selectVisibileTextById("initialTeamPartyId", "Demo Sales Team No. 1");
		selectVisibileTextById("marketingCampaignId", "Car and Driver");

		clickByXpath("//input[@value='Create Account']");
		closeBrowser();
	}

}
