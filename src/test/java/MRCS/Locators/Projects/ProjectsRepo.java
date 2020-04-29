package MRCS.Locators.Projects;

import org.openqa.selenium.By;

public class ProjectsRepo {
    public static By ProjectsLink = By.xpath("(//span[contains(.,'Projects')])[1]");
    public static By ChaseQueryHEDIS = By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Chase Query')]");
    public static By Filter = By.cssSelector(".pi.pi-filter");
    public static By Canclebutton = By.xpath("//span[contains(@class,'pi pi-times')]");
    public static By Measure = By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Measures')]");
    public static By SelectedMeasure = By.xpath("//span[@class='ng-star-inserted'][contains(text(),'HCC')]");
    public static By Update = By.xpath("//span[@class='ui-button-text ui-clickable'][contains(text(),'Update')]");
    public static By Comparison = By.xpath("//span[@class='ui-column-title'][contains(text(),'Measure')]");
    public static By CheckBox = By.xpath("//tr//td//a");
    public static By ChaseId = By.xpath("//span[contains(.,'Chase ID / Client Chase Key')]");
    public static By EnterChaseId = By.id("ChaseIdAndClientChaseKey");
    public static By Status = By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Status')]");
    public static By Pended = By.xpath(".//*[@id='Statuses']/div/div[2]/ul/li[1]/span");
    public static By StatusPended = By.xpath("//tr[\" + (i + 1) + \"]//td[16]//span[2]");
    public static By Compliance = By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Compliance')]");
    public static By NC = By.xpath("//li[@aria-label='NC']");
    public static By PendCodes = By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Codes')]");
    public static By PC100 = By.xpath(".//*[@id='PendCodes']/div/div[2]/ul/li[1]/span");
    public static By PendCodePC100 = By.xpath("//td[@class='hdvi-gridcol hdvi-gridcol-pendCode ng-star-inserted']");
    public static By Risk = By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Risk')]");
    public static By HccNo = By.xpath("(//label[@class='ui-radiobutton-label ng-star-inserted'][contains(text(),'No')])[3]");
    public static By HccDep = By.xpath("//td[@class='hdvi-gridcol hdvi-gridcol-hccDiscrepency ng-star-inserted']");
    public static By Client = By.xpath("//*[@id=\'ui-tabpanel-2-label\']");
    public static By Project = By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Projects')]");
    public static By ProjectName = By.xpath(".//*[@id='Projects']/div/div[2]/ul/li[6]/span");
    public static By Member = By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Member')]");
    public static By member = By.xpath("//td[@class='hdvi-gridcol hdvi-gridcol-memberSourceAliasID ng-star-inserted']");
    public static By CheckboxOfProject = By.xpath("//td[@class='hdvi-gridcol hdvi-gridcol-projectName ng-star-inserted']");
    public static By Projectfiles = By.xpath("//span[contains(.,'Project Files')]");
    public static By Folder = By.xpath("(//app-icon[@class='fa fa-folder'])[1]");
    public static By ProjectFileUpload = By.xpath("//span[@class='ui-button-text ui-clickable'][contains(text(),'Upload')]");
    public static By Pages = By.xpath("//td[@class='hdvi-gridcol hdvi-gridcol-chaseDocumentPageCount ng-star-inserted']");
    public static By ApprovalCenter = By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Approval Center')]");
    public static By Statusforapprovalcenter = By.xpath("//td[@class='hdvi-gridcol hdvi-gridcol-approvalState ng-star-inserted']");
}