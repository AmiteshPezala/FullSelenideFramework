package MRCS.Locators.ClinicalRepo;

import org.openqa.selenium.By;

public class ClinicalRepo {

    public static By Clinical=By.xpath("//span[contains(.,'Clinical')]");
    public static By MRR=By.xpath("//span[contains(.,'MRR')]");
    public static By OR1=By.xpath("//span[contains(.,'OR1')]");
    public static By OR2=By.xpath("//span[contains(.,'OR2')]");
    public static By Assignment=By.xpath("(//span[contains(text(),'Assignment')])[2]");
    public static By pageno = By.xpath("//td[@class='hdvi-gridcol hdvi-gridcol-claimId ng-star-inserted']");
    public static By Status=By.xpath("//span[contains(text(),'Status')]");
}
