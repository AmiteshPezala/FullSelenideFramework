package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisMRPRepo {

    public static By AdminDate=By.xpath("(//label[contains(text(),'Discharge Date (admin)')]//following::input)[1]");
    public static By RevisedDischargedDate=By.xpath("//label[contains(text(),'Revised Discharge Date')]//following::input");
    public static By RevisedDischargedPage=By.xpath("(//label[contains(text(),'Revised Discharge Date')]//following::input)[2]");
    public static By MedicationReconciliationDate=By.xpath("(//div[contains(text(),'Members who had medication reconciliation')]//following::input)[1]");
    public static By MedicationReconciliationPage=By.xpath("(//div[contains(text(),'Members who had medication reconciliation')]//following::input)[3]");
    public static By MedicationReconciliationDropDown=By.xpath("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[1]");

}
