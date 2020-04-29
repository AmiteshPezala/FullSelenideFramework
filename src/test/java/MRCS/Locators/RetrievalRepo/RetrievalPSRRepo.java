package MRCS.Locators.RetrievalRepo;

import org.openqa.selenium.By;

public class RetrievalPSRRepo {
    public static By Count=By.xpath("//span[@class='clearStat']");
    public static By FirstPSRAID=By.xpath("//tr[1]//td[1]");
    public static By AssignAddress=By.xpath("//span[contains(text(),'Assign Address')]");
    public static By AssignToUser=By.xpath("//input[@id='assignToUsers']");
    public static By AssignButton=By.xpath("//span[contains(text(),'ASSIGN')]");
    public static By AssignedToUser=By.xpath("//input[@id='AssignedToUserId']");
    public static By AID=By.xpath("//tr[1]//td[2]");
    public static By EditAddress=By.xpath("//span[contains(text(),'EDIT')]");
    public static By Emails=By.xpath("//input[@id='email']");
    public static By FirstRecordInAID=By.xpath("//div[@class='grids-display']//tr[1]//td[1]//p-tablecheckbox[1]");
    public static By EmailsRequest=By.xpath("//span[contains(text(),'Email Request(s)')]");
    public static By SelectTemplateDropdown=By.cssSelector(".ui-dropdown-trigger-icon");
    public static By InitialRequest=By.xpath("//span[contains(text(),'Initial Request')]");
    public static By EmailButton=By.xpath("//label[contains(text(),'Select Template')]//following::span[contains(text(),'EMAIL')]");
    public static By ScheduleTab=By.xpath("//div[contains(text(),'Schedule')]");
    public static By CancelButton=By.xpath("//span[contains(text(),'Cancel')]");
    public static By FaxRequest=By.xpath("//span[contains(text(),'Fax Request(s)')]");
    public static By FaxButton=By.xpath("(//span[contains(text(),'FAX')])[2]");

}
