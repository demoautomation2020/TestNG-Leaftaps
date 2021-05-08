package Testleaf.TestAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class Createcontacts extends GenericWrappers {

	@Test 
	public void Createcontact() {

		// Initialize Web Driver and URL
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");

		// Entering UserName and Password for login and login
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");

		// Click on "CRM/SFA" link
		clickByLink("CRM/SFA");

		// click on create Lead
		clickByLink("Create Contact");
		//Entering the details in the form
		enterById("firstNameField", "Cognizant Technology Solutions");
		enterById("lastNameField", "Prophoenix Technology");
		enterById("createContactForm_firstNameLocal","Samson");
		enterById("createContactForm_lastNameLocal","Edward");
		enterById("createContactForm_personalTitle","Contact Lead");
		enterById("createContactForm_generalProfTitle","Learn Automation Contact");
		enterById("createContactForm_departmentName","SDET");
		
		/*Select Class used for dropdown Select by value;*/
		selectVisibileTextById("createContactForm_preferredCurrencyUomId", "BOB - Bolivian Boliviano");
		
		enterById("createContactForm_description","SDET Working in Amazon");
		enterById("createContactForm_importantNote","SDET Working in Thoughtworks");
		enterById("createContactForm_primaryPhoneAreaCode","91");
		enterById("createContactForm_primaryPhoneNumber","9962 765 260 ");
		enterById("createContactForm_primaryPhoneExtension","1234");
		enterById("createContactForm_primaryPhoneAskForName","Beeshma");
		enterById("createContactForm_generalAttnName","Anandhi Jayaraman");
		enterById("generalToNameField","Madison Municipal Building");
		enterById("createContactForm_generalAddress1","City-County Building");
		enterById("createContactForm_generalAddress2","215 Martin Luther King Jr. Blvd");
		enterById("createContactForm_generalCity","Madison");
		
		/*Select Class used for dropdown Select by value;*/
		selectVisibileTextById("createContactForm_generalStateProvinceGeoId", "Wisconsin");
		
		enterById("createContactForm_generalPostalCode","543703");
		
		//Clicking the create lead link
		 clickByXpath("//input[@value='Create Contact']");
		 
		 //Get the title of the page.
		 verifyTitle("getTitle");
		 verifycurrenturl("getCurrentUrl");
		 closeBrowser();
		
			
		
		
		
		
				 
				

	}

}
