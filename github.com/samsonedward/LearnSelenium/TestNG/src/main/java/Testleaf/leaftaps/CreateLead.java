package Testleaf.leaftaps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import wrappers.GenericWrappers;

public class CreateLead extends GenericWrappers {

	@Test()
	public void CreateLead() {

		// Initialize Web Driver and URL
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		// Entering UserName and Password for login and login
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		// Click on "CRM/SFA" link
		clickByLink("CRM/SFA");

		// click on create Lead
		clickByLink("Create Lead");

		// Entering the details in the form
		enterById("createLeadForm_companyName", "TVSNEXT");
		enterById("createLeadForm_firstName", "Samson");
		enterById("createLeadForm_lastName", "Edward");

		/* Select Class used for dropdown Select by value; */
		selectVisibileTextById("createLeadForm_dataSourceId", "Direct Mail");
		selectVisibileTextById("createLeadForm_marketingCampaignId", "Catalog Generating Marketing Campaigns");

		enterById("createLeadForm_firstNameLocal", "Kevin Sam ");
		enterById("createLeadForm_lastNameLocal", "Matthew");
		enterById("createLeadForm_personalTitle", "Welcome to Learn Automation");
		enterById("createLeadForm_generalProfTitle", "Welcome to Selenium");
		enterById("createLeadForm_departmentName", "Master of Computer Applications");
		enterById("createLeadForm_annualRevenue", "5.4 Million");

		/* Select Class used for dropdown Select by value; */
		selectVisibileTextById("createLeadForm_currencyUomId", "CAD - Canadian Dollar");
		selectVisibileTextById("createLeadForm_industryEnumId", "Finance");
		selectVisibileTextById("createLeadForm_ownershipEnumId", "Corporation");

		enterById("createLeadForm_numberEmployees", "10,000");
		enterById("createLeadForm_sicCode", "SE2020");
		enterById("createLeadForm_tickerSymbol", "1234567890");
		enterById("createLeadForm_description", "Samson Edward working in Senior Automation Test Engineer");
		enterById("createLeadForm_importantNote", "Selenium with Java, Agile Methodolgy, Docker, AWS,Jenkins");

		enterById("createLeadForm_primaryPhoneAreaCode", "91");
		enterById("createLeadForm_primaryPhoneNumber", "9962 765 260");
		enterById("createLeadForm_primaryPhoneAskForName", "Jason Roy");
		enterById("createLeadForm_primaryEmail", "mailtosam.cts@gmail.com");
		enterById("createLeadForm_primaryWebUrl",
				"https://dev.azure.com/TestAutomationonline" + "/Test_Automation/_git/Automation?path=%2FAutomation");
		enterById("createLeadForm_generalToName", "sam");
		enterById("createLeadForm_generalAttnName", "Edward");
		enterById("createLeadForm_generalAddress1", "502 Pleasant Avenue");
		enterById("createLeadForm_generalAddress2", "Devaraj Street V.O.C Nagar Pammal");
		enterById("createLeadForm_generalCity", "Wisconsin");

		/* Select Class used for dropdown Select by value; */
		selectVisibileTextById("createLeadForm_generalStateProvinceGeoId", "Florida");
		enterById("createLeadForm_generalPostalCode", "600199");
		enterById("createLeadForm_generalPostalCodeExt", "91");

		// Clicking the create lead link
		clickByXpath("//input[@value='Create Lead']");

		// Get the title of the page.
		verifyTitle("getTitle");
		verifycurrenturl("getCurrentUrl");
		closeBrowser();
	}
}
