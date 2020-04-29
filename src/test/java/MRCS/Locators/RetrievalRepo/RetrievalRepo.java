package MRCS.Locators.RetrievalRepo;

import org.openqa.selenium.By;

public class RetrievalRepo {
    public static By RetrievalLink=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Retrieval')]");
    public static By DocIntake=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Doc Intake')]");
    public static By MRQA=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Doc QA')]");
    public static By PSR=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'PSR')]");
    public static By EMR=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'EMR')]");
    public static By FT=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Field Tech')]");
    public static By EditAddress=By.xpath("//span[contains(text(),'EDIT')]");
    public static By GroupName=By.id("groupName");
    public static By Email=By.id("email");
    public static By Phone=By.id("phone");
    public static By Fax=By.id("fax");
    public static By ContactName=By.xpath("//input[@id='contactName']");
    public static By ApplyEdits=By.xpath("//span[contains(text(),'APPLY EDITS')]");
    public static By Chart=By.xpath("//div[@class='description'][contains(text(),'Chart')]");
    public static By ChaseInfo=By.xpath("//div[@class='description'][contains(text(),'Chase Info')]");
    public static By MoveChase=By.xpath("//span[@class='ui-button-text ui-clickable'][contains(text(),'Move Chase(s)')]");
    public static By PrintRequest=By.xpath("//span[contains(text(),'Print Request(s)')]");
    public static By ScheduleButton=By.xpath("(//span[@class='ui-button-text ui-clickable'][contains(text(),'Schedule')])[2]");
    public static By Assignment=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Assignment')]");
    public static By AvlUserDropdown=By.xpath("//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']");
    public static By SelectUser=By.xpath("//*[@role='option']");
    public static By AddAppointment=By.xpath("//span[contains(text(),'Add Appointment')]");
    public static By DateDropdown=By.xpath("//input[@placeholder='Date']");
    public static By NextMonth=By.xpath("//span[contains(@class,'pi pi-chevron-right')]");
    public static By StartTime=By.xpath("//input[@placeholder='Start Time']");
    public static By SelectStartTime=By.xpath("//div[@class='ui-minute-picker']//span[@class='pi pi-chevron-down']");
    public static By EndTime=By.xpath("//input[@placeholder='End Time']");
    public static By SelectEndTime=By.xpath("//div[@class='ui-minute-picker']//span[@class='pi pi-chevron-up']");
    public static By SendText=By.xpath("//*[@id='appointmentNotes']");
    public static By ScheduleAppointment=By.xpath("//span[contains(text(),'Save')]");
    public static By CommitmentDate=By.xpath("//span[contains(text(),'Commitment Date')]");
    public static By FindButton=By.xpath("//span[contains(text(),'FIND ADDRESSES')]");
    public static By SelectedDate=By.xpath("//tr[2]//td[4]");
    public static By SelectedDate1=By.xpath("//tr[2]//td[4]//a");
    public static By Upload=By.xpath("(//span[@class='ui-button-text ui-clickable'][contains(text(),'Upload')])[2]");
    public static By AIDFirstRow=By.xpath("//tr[1]//td[2]");

    /** Move Chase */
    public static By CheckBoxForFirstChaseId=By.xpath("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]");
    public static By FindAddressLink=By.xpath("//span[contains(text(),'FIND ADDRESSES')]");
    public static By CreateNewAddress=By.xpath("//span[contains(text(),'Click here to create a new address')]");
    public static By Address1=By.xpath("//input[@id='address1']");
    public static By ContactData=By.xpath("//input[@id='contactData']");
    public static By Address2=By.xpath("//input[@id='address2']");
    public static By City=By.xpath("//input[@id='city']");
    public static By StateDropDown=By.cssSelector(".ui-dropdown");
    public static By State=By.cssSelector(".ui-dropdown-item");
    public static By PostalCode=By.xpath("//input[@id='postalCode']");
    public static By EnterNotes=By.xpath("//textarea[@placeholder='Enter Notes for Chase Move.']");
    public static By CreateAddressMoveChase=By.xpath("//span[contains(text(),'CREATE ADDRESS + MOVE CHASE')]");
    public static By ViewThisAddress=By.xpath("//span[contains(text(),'VIEW THIS ADDRESS')]");
    public static By ContainerAID=By.xpath("//*[contains(text(),'ADDRESS ID')]");

    /** Comment & Timeline **/

    public static By CommentTab=By.xpath("//*[contains(text(),'Comments')]");
    public static By TimeLine=By.xpath("//*[contains(text(),'Timeline')]");
    public static By TextArea=By.xpath("//*[@placeholder='Type here to reply.']");
    public static By AddComment=By.xpath("//*[contains(text(),'ADD COMMENT')]");


}
