package MRCS.Locators.RetrievalRepo;

import org.openqa.selenium.By;

public class ThirdPartyRepo {
    public static By ThirdPartyLink=By.xpath("//span[contains(text(),'3rd Party')]");
    public static By FirstAID=By.xpath("//tr//td[2]");
    public static By EditAddress=By.xpath("//span[contains(text(),'EDIT')]");
    public static By CountOfChart=By.xpath("//ul//li//div//img");
    public static By RetrievalType=By.xpath("//span[contains(text(),'Retrieval Type')]");
    public static By ContactHistory=By.xpath("//div[contains(text(),'Contact History')]");
    public static By PendTab=By.xpath("//div[contains(text(),'Pends')]");
    public static By ChasesTab=By.xpath("//div[contains(text(),'Chases')]");
    public static By ProviderTab=By.xpath("//div[contains(text(),'Providers')]");
    public static By ExportAll=By.xpath("//span[contains(text(),'Export All')]");
    public static By PursuitTab=By.xpath("//div[contains(text(),'Pursuits')]");
}
