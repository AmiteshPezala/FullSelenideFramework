package MRCS.Locators.RetrievalRepo;

import org.openqa.selenium.By;

public class RetrievalEMRRepo {
    public static By Count=By.xpath("//span[@class='clearStat']");
    public static By FirstEMRAID=By.xpath("//tr[1]//td[1]");
    public static By FirstChaseInUpload=By.xpath("//tr[1]//td[2]");
    public static By SelectAll=By.xpath("//span[contains(text(),'Select All: YES')]");
    public static By SubmitButton=By.xpath("//span[contains(text(),'Submit')]");
    public static By RadioButtonToUpload=By.xpath("//tr[1]//td[1]//p-tableradiobutton[1]//div[1]//div[2]//span[1]");
    public static By ExportAll=By.xpath("//*[text()='Export All']");
    public static By ScheduleTab=By.xpath("//*[text()='Schedule']");
    public static By AssignTo=By.xpath("//*[@id='AssignedTo']");
    public static By EMRAID=By.xpath("//h3[@class='container-emrId']");
    public static By SelectAllNo=By.xpath("//*[text()='Select All: NO']");
    public static By PendThisChase=By.xpath("//*[text()='Pend This Chase']");
    public static By AlReadyPended=By.xpath("//*[text()='This chase is already Pended.']");
    public static By DropDownButton=By.cssSelector(".ui-dropdown-trigger");
    public static By DropDownValue=By.cssSelector(".ui-dropdown-item");
    public static By TextArea=By.xpath("//*[@id='notes']");
    public static By SaveButton=By.xpath("//*[text()='Save']");
    public static By ToasterMessage=By.xpath("//div[@class='ui-toast-detail']");
    public static By AccessInfo=By.xpath("//*[text()='Access Info']");
    public static By EditAccessInfo=By.xpath("(//*[text()='EDIT'])[2]");
    public static By AdminContactName=By.xpath("//*[@id='accessAdminContact']");
    public static By AdminPhoneNumber=By.xpath("//*[@id='accessAdminPhone']");
    public static By ITContactName=By.xpath("//*[@id='accessITContact']");
    public static By ITPhoneNumber=By.xpath("//*[@id='accessITPhone']");
    public static By EMRSystem=By.xpath("//*[@id='accessEmrSystem']");
    public static By EditNotes=By.xpath("//*[@id='accessEditNotes']");
    public static By providersTab=By.xpath("//*[text()='Providers']");
    public static By pursuitsTab=By.xpath("//*[text()='Pursuits']");


}
