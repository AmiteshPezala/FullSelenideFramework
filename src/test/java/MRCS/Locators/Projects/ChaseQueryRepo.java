package MRCS.Locators.Projects;

import org.openqa.selenium.By;

public class ChaseQueryRepo {
    //Locator for creating new chase
    public static By CreateNewChase=By.xpath("//span[contains(text(),'CREATE A NEW CHASE')]");
    public static By GetStartedButton=By.xpath("//span[contains(text(),'GET STARTED')]");
    public static By NextButton=By.xpath("//span[contains(text(),'NEXT STEP')]");
    public static By SearchButton=By.xpath("//span[contains(text(),'SEARCH')]");
    public static By FirstRecord=By.xpath("//tr[1]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]");
    public static By FinalizeButton=By.xpath("//span[contains(text(),'FINALIZE')]");
    public static By OptionYes=By.xpath("(//span[@class='ui-radiobutton-icon ui-clickable'])[1]");
    public static By OptionNo=By.xpath("(//span[@class='ui-radiobutton-icon ui-clickable'])[2]");

    //locator for Project Details
    public static By ProjectDropdown=By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down'][1]");
    public static By NameOfProject=By.xpath("//span[contains(text(),'2020 HEDIS 1')]");
    public static By ProductDropdown=By.xpath("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down'])[2]");
    public static By ProductName=By.xpath("//span[contains(text(),'Commercial')]");
    public static By MeasureDropdown=By.xpath("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down'])[3]");
    public static By ChaseKey=By.xpath("//label[contains(text(),'CHASE KEY')]//following::input");

    //locator for member

    public static By ClientMemberId=By.xpath("//label[contains(text(),'CLIENT MEMBER ID')]//following::input");
    public static By EnrollId=By.xpath("//label[contains(text(),'ENROLLEE ID')]//following::input");
    public static By FirstName=By.xpath("//label[contains(text(),'FIRST NAME')]//following::input");
    public static By MiddleName=By.xpath("//label[contains(text(),'MIDDLE NAME')]//following::input");
    public static By LastName=By.xpath("//label[contains(text(),'LAST NAME')]//following::input");
    public static By DOB=By.xpath("//label[contains(text(),'DATE OF BIRTH')]//following::input");
    public static By GenderDropDown=By.xpath("//label[contains(text(),'GENDER')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']");
    public static By OptionFemale=By.xpath("//span[contains(text(),'Female')]");
    public static By AddMember=By.xpath("//span[contains(text(),'ADD MEMBER')]");
    public static By NextButtonForMember=By.xpath("(//div[@class='grids-display ng-star-inserted']//following::span[contains(text(),'NEXT STEP')])");


    //locator for address
    public static By OptionYesForAddress=By.xpath("(//label[contains(text(),'IS THIS AN EXISTING ADDRESS?')]//following::span[@class='ui-radiobutton-icon ui-clickable'])[1]");
    public static By OptionNoForAddress=By.xpath("(//label[contains(text(),'IS THIS AN EXISTING ADDRESS?')]//following::span[@class='ui-radiobutton-icon ui-clickable'])[2]");
    public static By GroupName=By.xpath("//label[contains(text(),'GROUP NAME')]//following::input");
    public static By Address1=By.xpath("//label[contains(text(),'ADDRESS 1')]//following::input");
    public static By Address2=By.xpath("//label[contains(text(),'ADDRESS 2')]//following::input");
    public static By City=By.xpath("//label[contains(text(),'CITY')]//following::input");
    public static By StateDropDown=By.xpath("//label[contains(text(),'STATE')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']");
    public static By StateName=By.xpath("//span[contains(text(),'Alaska')]");
    public static By ZipCode=By.xpath("//label[contains(text(),'ZIP CODE')]//following::input");
    public static By Contact=By.xpath("//label[contains(text(),'CONTACT')]//following::input");
    public static By PhoneNumber=By.xpath("//label[contains(text(),'Phone Number')]//following::input");
    public static By FaxNumber=By.xpath("//label[contains(text(),'Fax Number')]//following::input");
    public static By ClientAddressId=By.xpath("//label[contains(text(),'CLIENT ADDRESS ID')]//following::input");
    public static By AddAddress=By.xpath("//span[contains(text(),'ADD ADDRESS')]");
    public static By NextButtonForAddress=By.xpath("(//label[contains(text(),'IS THIS AN EXISTING ADDRESS?')]//following::span[contains(text(),'NEXT STEP')])");
    public static By AddressId=By.xpath("//label[contains(text(),'ADDRESS ID')]//following::input");


    //locator for provider
    public static By OptionYesForProvider=By.xpath("(//label[contains(text(),'IS THIS AN EXISTING PROVIDER?')]//following::span[@class='ui-radiobutton-icon ui-clickable'])[1]");
    public static By OptionNoForProvider=By.xpath("(//label[contains(text(),'IS THIS AN EXISTING PROVIDER?')]//following::span[@class='ui-radiobutton-icon ui-clickable'])[2]");
    public static By NPI=By.xpath("(//label[contains(text(),'NPI')]//following::input)[1]");
    public static By FirstNameOfProvider=By.xpath("(//label[contains(text(),'NPI')]//following::input)[2]");
    public static By LastNameOfProvider=By.xpath("(//label[contains(text(),'NPI')]//following::input)[3]");
    public static By Speciality=By.xpath("(//label[contains(text(),'NPI')]//following::input)[4]");
    public static By ClientProviderId=By.xpath("(//label[contains(text(),'NPI')]//following::input)[5]");
    public static By AddProvider=By.xpath("//span[contains(text(),'ADD PROVIDER')]");
    public static By NextButtonForProvider=By.xpath("(//label[contains(text(),'IS THIS AN EXISTING PROVIDER?')]//following::span[contains(text(),'NEXT STEP')])");





}
