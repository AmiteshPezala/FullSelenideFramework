package MRCS.Locators.InvoicesRepo;

import org.openqa.selenium.By;

public class InvoicesRepo {

    public static By invoicesLink= By.cssSelector(".fa-dollar-sign");
    public static By chasesTabs= By.xpath("//*[text()='Chases']");
    public static By documentsTabs= By.xpath("//*[text()='Documents']");
    public static By thirdPartyVendorsTabs= By.xpath("//*[text()='3rd Party Vendors']");
    public static By invoicesTabs= By.xpath("//*[@class='description']//following::*[text()='Invoices']");
    public static By filterLinks= By.cssSelector(".ui-tabview-title");


    /** cards **/
    public static By totalInvoiceCard= By.xpath("//*[text()='Total Invoice']");
    public static By newCard= By.xpath("//*[text()='New']");
    public static By toBePaidCard= By.xpath("//*[text()='To Be Paid']");
    public static By closedPaidCard= By.xpath("//*[text()='Closed Paid']");
    public static By closedUnpaidCard= By.xpath("//*[text()='Closed Unpaid']");

/** grid data **/
    public static By invoiceGrid= By.xpath("//tr//th[2]");
    public static By invoiceNumberGrid= By.xpath("//tr//th[3]");
    public static By chaseIdGrid= By.xpath("//tr//th[4]");
    public static By projectGrid= By.xpath("//tr//th[5]");
    public static By aidGrid= By.xpath("//tr//th[6]");
    public static By groupNameGrid= By.xpath("//tr//th[7]");
    public static By vendorGrid= By.xpath("//tr//th[8]");
    public static By typeGrid= By.xpath("//tr//th[9]");
    public static By thresoldAmountGrid= By.xpath("//tr//th[10]");
    public static By approvalStatusGrid= By.xpath("//tr//th[11]");
    public static By paymentTypeGrid= By.xpath("//tr//th[12]");
    public static By paymentDateGrid= By.xpath("//tr//th[13]");
    public static By paidByGrid= By.xpath("//tr//th[14]");
    public static By amountPerChaseGrid= By.xpath("//tr//th[15]");
    public static By invoiceStatusGrid= By.xpath("//tr//th[16]");
    public static By uploadDateGrid= By.xpath("//tr//th[17]");

    /**   Invoice page       **/
    public static By addCodInvoiceButton= By.xpath("//*[contains(text(),'ADD COD INVOICE')]");
    public static By selectDocumentButton= By.xpath("//*[contains(text(),'SELECT DOCUMENT')]");
    public static By submitButton= By.xpath("//*[contains(text(),'Submit')]");
    public static By associatedChasesText= By.xpath("//*[@id='chaseIds']");
    public static By validateButton= By.xpath("//*[text()='VALIDATE']");
    public static By continueButton= By.xpath("//*[text()='CONTINUE']");
    public static By searchButton= By.xpath("//*[text()='SEARCH']");
    public static By paymentMethodDropDown= By.cssSelector(".ui-dropdown-trigger");
    public static By cancelButton= By.xpath("//*[text()='CANCEL']");


    /**   search chase       **/
    public static By aidText= By.xpath("//*[@id='addressId']");
    public static By searchButton2= By.xpath("//*[text()='Search']");
    public static By useThisChaseButton= By.xpath("//*[text()='USE THIS CHASE']");

    /** Document Tab **/
    public static By DocumentTab=By.xpath("//div[contains(text(),'Documents')]");
    public static By ExportAll=By.xpath("//span[contains(text(),'Export All')]");
    public static By InvoiceIdGrid=By.xpath("//tr//th[1]");
    public static By RetrievalMethodGrid=By.xpath("//tr//th[2]");
    public static By CaptureDateGrid=By.xpath("//tr//th[3]");
    public static By UploadDateGrid=By.xpath("//tr//th[4]");
    public static By InvoiceStatucGrid=By.xpath("//tr//th[5]");

    /** Filter**/
    public static By DocumentID=By.xpath("//span[contains(text(),'Document ID')]");
    public static By IdInput=By.xpath("//span[contains(text(),'Document ID')]//following::input");
    public static By RetrievalMethod=By.xpath("//span[contains(text(),'Retrieval Method')]");

    /**Third party vendors**/
    public static By ThirdPartyVendorTab=By.xpath("//div[contains(text(),'3rd Party Vendors')]");
    public static By VendorNameGrid=By.xpath("//tr//th[1]");
    public static By VendorIdGrid=By.xpath("//tr//th[2]");
    public static By TypeGrid=By.xpath("//tr//th[3]");
    public static By ChasesGrid=By.xpath("//tr//th[4]");
    public static By InvoicesGrid=By.xpath("//tr//th[5]");
    public static By AmountGrid=By.xpath("//tr//th[6]");

    /** invoices tab **/
    public static By invoicesNumber=By.xpath("//tr//th[2]");
    public static By vendor=By.xpath("//tr//th[3]");
    public static By invoicesType=By.xpath("//tr//th[4]");
    public static By paymentType=By.xpath("//tr//th[5]");
    public static By amountInvoices=By.xpath("//tr//th[6]");
    public static By statusInvoicesTabs=By.xpath("//tr//th[8]");
    public static By chasesInvoicesTabs=By.xpath("//tr//th[7]");
}
