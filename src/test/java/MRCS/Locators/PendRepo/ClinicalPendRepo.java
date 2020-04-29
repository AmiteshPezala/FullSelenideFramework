package MRCS.Locators.PendRepo;

import org.openqa.selenium.By;

public class ClinicalPendRepo {

    public static By startCount= By.cssSelector(".headerStatsItem");
    public static By clinicalLink= By.xpath("(//*[contains(text(),'Clinical')])[2]");
    public static By pendStatus= By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]");
    public static By resetAll= By.xpath("//span[@class='ui-button-text ui-clickable'][contains(text(),'Reset All')]");
    public static By newStatus= By.xpath("//p-listbox[@id='PendsStatus']/div/div[2]/ul/li/div/div");
    public static By inProgressStatus= By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::span[2]");
    public static By resolved= By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='In Progress'])[1]/following::span[2]");
    public static By closed= By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Resolved'])[1]/following::div[2]");

}
