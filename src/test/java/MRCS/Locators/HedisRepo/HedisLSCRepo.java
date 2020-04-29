package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisLSCRepo {
    public static  By DeleteIcon=By.xpath("//button[contains(text(),'×')]");
    public static  By AddIcon=By.xpath("//button[@class='control__add']");
    public static  By BloodLeadDate=By.xpath("(//div[contains(text(),'Blood Lead Screening')]//following::input)[1]");
    public static  By BloodLeadLevel=By.xpath("(//div[contains(text(),'Blood Lead Screening')]//following::input)[2]");
    public static  By BloodLeadDropDown=By.xpath("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[1]");
    public static  By BloodLeadPage=By.xpath("(//div[contains(text(),'Blood Lead Screening')]//following::input)[4]");


}
