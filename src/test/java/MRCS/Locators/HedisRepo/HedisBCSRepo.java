package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisBCSRepo {

    public static By MammogramDate=By.xpath("(//div[contains(text(),'Mammogram')]//following::input)[1]");
    public static By MammogramPageNumber=By.xpath("(//div[contains(text(),'Mammogram')]//following::input)[2]");
    public static By ChaseCompliance=By.xpath("//span[contains(text(),'C/MR')]");
    public static By Delete=By.xpath("(//div[contains(text(),'Mammogram')]//following::button[@class='control__delete ng-star-inserted'])[1]");
    public static By ExclusionDropdown=By.xpath("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]");
    public static By ExclusionDate=By.xpath("//input[@id='Exclusion Date']");
    public static By ExclusionPageNumber=By.xpath("//input[@id='Exclusion Page Number']");
    public static By Contra=By.xpath("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]");
    public static By ContraDate=By.xpath("//input[@id='Contra Date']");
    public static By ContraPageNumber=By.xpath("//input[@id='Contra Page Number']");
    public static By NonCompliance=By.xpath("//span[contains(text(),'NC/C')]");
    public static By FirstElementInDropdown=By.xpath("//p-dropdownitem/li/span");
    public static By DeleteForExclusion=By.xpath("(//button[@class='control__delete'])[1]");
    public static By DeleteForContra=By.xpath("(//button[@class='control__delete'])[2]");


}
