package MRCS.Locators.PendRepo;

import org.openqa.selenium.By;

public class RetrievalPendRepo {
    public static By Pend=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Pend')]");
    public static By Retrieval=By.xpath("/html/body/app-root/app-platform/div[2]/div[1]/nav/app-menu/p-panelmenu/div/div[4]/div[2]/div/p-panelmenusub/ul/li[1]/a/span[2]");
    public static By Clinical=By.xpath("/html/body/app-root/app-platform/div[2]/div[1]/nav/app-menu/p-panelmenu/div/div[4]/div[2]/div/p-panelmenusub/ul/li[2]/a/span[2]");
    public static By TotalDocument=By.xpath("//div[@class='document-list-info-container']");
    public static By TotalPend=By.xpath("(//span[contains(text(),'Total')]//following::a)[1]");
    public static By FirstPend=By.xpath("//tr[1]//td[2]");
    public static By PrintProvider=By.xpath("//span[contains(text(),'PRINT PROVIDER PACKAGE')]");
    public static By UploadMR=By.cssSelector(".ui-fileupload-choose>input");
    public static By SubmitButton=By.xpath("//span[contains(text(),'Submit')]");
    public static By DocumentsTab=By.xpath("//div[contains(text(),'Documents')]");
    public static By UploadDocumentButton=By.xpath("//span[contains(text(),'UPLOAD DOCUMENT')]");
    public static By Description=By.xpath("//textarea[@id='description']");
    public static By ToasterMessage=By.xpath("//div[@class='ui-toast-detail']");
    public static By FirstUploadedDocument=By.xpath("(//app-icon[@class='fa fa-file'])[1]");
    public static By UploadButton=By.xpath("(//span[contains(text(),'UPLOAD')])[3]");
    public static By RAD=By.xpath("//span[contains(text(),'REQUEST ADDITIONAL DOCUMENTATION')]");
    public static By RADDropdown=By.cssSelector(".ui-dropdown-trigger-icon");
    public static By FirstDropdownRecord=By.xpath("//span[contains(text(),'MedicalRecord')]");
    public static By NoteText=By.xpath("//textarea[@id='Note']");
    public static By SelectAll=By.xpath("//span[contains(text(),'Select All')]");
    public static By RequestButton=By.xpath("//label[@title='Note']//following::button");
    public static By PendInfo=By.xpath("//div[contains(text(),'Pend Info')]");
    public static By PendStatus=By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]");
    public static By NewPendStatus=By.xpath("//span[contains(text(),'New')]");
    public static By InProgressPendStatus=By.xpath("//span[contains(text(),'In Progress')]");
    public static By UpdatePend=By.xpath("(//span[contains(text(),'UPDATE PEND')])[1]");
    public static By StatusDropdown=By.xpath("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[3]");
    public static By ResolvedStatus=By.xpath("//span[contains(text(),'Resolved')]");
    public static By SecondCancelIcon=By.xpath("(//*[text()='Cancel'])[2]");
    public static By FirstCancelIcon=By.xpath("(//*[text()='Cancel'])[1]");


}
