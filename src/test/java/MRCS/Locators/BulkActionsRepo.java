package MRCS.Locators;

import org.openqa.selenium.By;

public class BulkActionsRepo {
    public static By BulkAction=By.xpath("//span[contains(text(),'Bulk Actions')]");
    public static By BulkChanges=By.xpath("//span[contains(text(),'Bulk Changes')]");
    public static By BulkUpdateDropDown=By.xpath("//label[contains(text(),'Select a Type of Bulk Update')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']");
    public static By OptionPend=By.xpath("//span[@class='ng-star-inserted'][contains(text(),'Pend')]");
    public static By BulkActionDropDown=By.xpath("//label[contains(text(),'Choose a Bulk Action')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']");
    public static By Notes=By.xpath("//textarea[@id='selectedChaseIds']");
    public static By Continue=By.xpath("//span[contains(text(),'CONTINUE')]");
    public static By ContinueToValidation=By.xpath("//span[contains(text(),'CONTINUE TO VALIDATION')]");
    public static By FinishBulkUpdate=By.xpath("//span[contains(text(),'FINISH BULK UPDATE')]");
    public static By BulkOutreach=By.xpath("//span[contains(text(),'Bulk Outreach')]");
    public static By SelectAll=By.xpath("//span[contains(text(),'Select All')]");
    public static By ActionTypeDropDown=By.xpath("//label[contains(text(),'Action Type')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']");
    public static By OptionFax=By.xpath("//span[contains(text(),'Fax')]");
    public static By LoggedInUserName=By.xpath("//div[@class='username--container']");
    public static By WhoIsSendingFax=By.xpath("//label[contains(text(),'WHO IS SENDING THIS FAX')]//following::input");
    public static By FaxNo=By.xpath("//label[contains(text(),'WHAT NUMBER IS THE FAX COMING FROM?')]//following::input");
    public static By RunQuery=By.xpath("//span[contains(text(),'RUN QUERY')]");
    public static By IncludePendsYes=By.xpath("(//label[contains(text(),'WOULD YOU LIKE TO INCLUDE PENDS?')]//following::span['ui-radiobutton-icon ui-clickable'])[1]");
    public static By CoverLetterDropDown=By.xpath("//label[contains(text(),'COVER LETTER TEMPLATE')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']");
    public static By SubmitFax=By.xpath(("//span[contains(text(),'SUBMIT FAX REQUEST')]"));
    public static By IncludePendsNo=By.xpath("(//label[contains(text(),'WOULD YOU LIKE TO INCLUDE PENDS?')]//following::span['ui-radiobutton-icon ui-clickable'])[2]");
    public static By ViewPendingAction=By.xpath("//span[contains(text(),'VIEW PENDING ACTIONS')]");

    /** Bulk Changes **/
    public static By DropDownIcon=By.cssSelector(".ui-dropdown-trigger-icon");
    public static By DropDownElement=By.xpath("//p-dropdownitem/li/span");
    public static By InvoiceTextField=By.xpath("//*[@id='invoiceNumber']");
    public static By PendIdText=By.xpath("//*[@id='selectedChaseIds']");
    public static By FirstChaseId=By.xpath("//tr[1]//td[2]");
    public static By SecondChaseId=By.xpath("//tr[2]//td[2]");
    public static By TextField=By.xpath("//*[@id='chasesNotes']");
    public static By InvoiceAmount=By.xpath("//*[@id='amount']");
    public static By PendText=By.xpath("//tr/th[1]");
    public static By OldInvoiceNumberText=By.xpath("//tr/th[2]");
    public static By OldInvoiceAmountText=By.xpath("//tr/th[3]");
    public static By OldCompanyText=By.xpath("//tr/th[4]");
    public static By ValidationMessageText=By.xpath("//tr/th[5]");
    public static By MessageText=By.xpath("//tr/th[6]");

}
