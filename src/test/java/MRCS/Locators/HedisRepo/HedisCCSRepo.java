package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisCCSRepo {
    public static By PapSmearDate=By.xpath("//div[contains(text(),'Pap Smear for Ages 21-64')]//following::input[1]");
    public static By PapSmearPageNumber=By.xpath("//div[contains(text(),'Pap Smear for Ages 21-64')]//following::input[3]");
    public static By YesButton=By.xpath("(//span[contains(text(),'Yes')])[2]");
    public static By PapResultDropDown=By.xpath("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[1]");
    public static By HPVTestDate=By.xpath("//div[contains(text(),'HPV (hrHPV) Test for Ages 30-64')]//following::input[1]");
    public static By HPVTestPageNumber=By.xpath("//div[contains(text(),'HPV (hrHPV) Test for Ages 30-64')]//following::input[3]");
    public static By HPVTestDropDown=By.xpath("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[2]");
    public static By ExclusionDropdown=By.xpath("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]");
    public static By ExclusionDate=By.xpath("//input[@id='Exclusion Date']");
    public static By ExclusionPageNumber=By.xpath("//input[@id='Exclusion Page Number']");
    public static By Contra=By.xpath("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]");
    public static By ContraDate=By.xpath("//input[@id='Contra Date']");
    public static By ContraPageNumber=By.xpath("//input[@id='Contra Page Number']");
}
