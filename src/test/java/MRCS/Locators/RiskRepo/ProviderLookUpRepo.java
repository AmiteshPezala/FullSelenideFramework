package MRCS.Locators.RiskRepo;

import org.openqa.selenium.By;

public class ProviderLookUpRepo {
    public static By MagnifyingIconInEncounter=By.xpath("(//h3[contains(text(),'Encounters')]//following::span[@class='pi pi-search ui-clickable ui-button-icon-left ng-star-inserted'])[1]");
    public static By MagnifyingIconInDiagnostic=By.xpath("//h3[contains(text(),'Diagnoses')]//following::span[@class='pi pi-search ui-clickable ui-button-icon-left ng-star-inserted']");
    public static By BackwardButton=By.cssSelector(".fa.fa-step-backward");
    public static By NPI=By.xpath("//th[@title='NPI']");
    public static By FirstName=By.xpath("//th[@title='First Name']");
    public static By LastName=By.xpath("//th[@title='Last Name']");
    public static By Specialty=By.xpath("//th[@title='Specialty']");
    public static By AID=By.xpath("//th[@title='AID']");
    public static By CrossIcon=By.xpath("//span[contains(text(),'Cancel')]");
    public static By SearchButton=By.xpath("//span[contains(text(),'Search')]");
    public static By SearchForProviderText=By.xpath("//input[@id='SearchProviderInput']");
    public static By SecondSelectButton=By.xpath("(//span[contains(text(),'Select')])[2]");
    public static By ProviderDropdown=By.xpath("(//label[@title='Provider']//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]");
    public static By GetDropdownSize=By.xpath("//p-dropdownitem/li/span");
    public static By ENC=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Specific service dates found in document (ENC)?'])[1]/following::label[1]");
    public static By ENCAsNo=By.xpath("//li[@aria-label='No']");
    public static By YesButton=By.xpath("(//span[contains(text(),'Yes')])[2]");
    public static By SaveContainer=By.xpath("//div[@class='coding-container']");
    public static By FirstTextField=By.xpath("(//label[contains(text(),'Page Number')]//following::input)[1]");
    public static By NoButton=By.xpath("(//span[contains(text(),'No')])[2]");
    public static By Address1=By.xpath("//th[contains(text(),'Address1')]");
    public static By Address2=By.xpath("//th[contains(text(),'Address2')]");
    public static By City=By.xpath("//th[contains(text(),'City')]");
    public static By State=By.xpath("//th[contains(text(),'State')]");
    public static By Zip=By.xpath("//th[contains(text(),'Zip')]");
    public static By Phone=By.xpath("//th[contains(text(),'Phone')]");
    public static By Fax=By.xpath("//th[contains(text(),'Fax')]");

}
