package MRCS.Locators.RetrievalRepo;

import org.openqa.selenium.By;

public class MRQARepo {
    public static By MRQAChaseId=By.xpath("//tr[1]//td[2]");
    public static By ViewSource=By.xpath("//span[contains(text(),'VIEW SOURCE')]");
    public static By Description=By.xpath("(//div[@class='description'])[2]");
    public static By HideSource=By.xpath("//span[contains(text(),'HIDE SOURCE')]");
    public static By YesButton=By.xpath("//span[contains(text(),'Yes')]");
    public static By SubmitButton=By.xpath("//span[contains(text(),'Submit')]");
    public static By BackwardButton=By.cssSelector(".fa.fa-step-backward");
    public static By AcceptButton=By.xpath("//span[contains(text(),'ACCEPT')]");
    public static By RestoreButton=By.xpath("(//a[contains(text(),'RESTORE ')])[1]");
    public static By FirstCheckBox=By.xpath("//tr[1]//td[1]");
    public static By AssignChases=By.xpath("//span[contains(text(),'Assign Chase(s)')]");
    public static By AssignToUsers=By.xpath("//input[@id='assignToUsers']");
    public static By AssignButton=By.xpath("//span[contains(text(),'ASSIGN')]");
    public static By ExportAll=By.xpath("//span[contains(text(),'Export All')]");
    public static By UnAssign=By.xpath("//span[contains(text(),'Unassign Chase(s)')]");
    public static By ReadOnlyView=By.xpath("//span[contains(text(),'Readonly View')]");
    public static By NoButton=By.xpath("//span[contains(text(),'No')]");
    public static By PageNumber=By.xpath("//input[@id='PageNumber']");
    public static By DropDown=By.cssSelector(".input.input__reasons");
    public static By CoverLetter=By.xpath("//span[contains(text(),'THIS IS A COVER LETTER')]");
    public static By CoverLetterBeg=By.xpath("//input[@formcontrolname='coverBegPage']");
    public static By CoverLetterEnd=By.xpath("//input[@formcontrolname='coverEndPage']");
    public static By CoverLetterChaseId=By.xpath("//input[@formcontrolname='coverChaseId']");
    public static By DocId=By.xpath("//span[@class='pageId']");
    public static By Invoice=By.xpath("//span[contains(text(),'THIS PAGE IS PART OF AN INVOICE')]");
    public static By InvoiceBeg=By.xpath("//input[@formcontrolname='invoiceBegPage']");
    public static By InvoiceEnd=By.xpath("//input[@formcontrolname='invoiceEndPage']");
    public static By InvoiceChaseId=By.xpath("//input[@formcontrolname='invoiceChaseId']");
    public static By InvoiceDropDown=By.xpath("//select[@formcontrolname='invoiceType']");
    public static By ContainerTitle=By.xpath("//h3[@class='container-title']");
    public static By PageCount=By.xpath("//span[@class='pagecount']");
    public static By RightForward=By.xpath("//app-icon[@class='fa fa-arrow-right']");
    public static By SubmitAndNext=By.xpath("//span[contains(text(),'SUBMIT & GET NEXT')]");
    public static By ChartIcon=By.xpath("(//div[@class='description'])[1]");

}
