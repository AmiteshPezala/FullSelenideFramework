package MRCS.Locators;

import org.openqa.selenium.By;

public class ApprovalCenterRepo {
    public static By ApprovalCenter=By.xpath("//span[contains(text(),'Approval Center')]");
    public static By ApproveChaseMove=By.xpath("//span[contains(text(),'Approve Chase Moves')]");
    public static By ExportAll=By.xpath("//span[contains(text(),'Export All')]");
    public static By Chase=By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Chase')]");
}
