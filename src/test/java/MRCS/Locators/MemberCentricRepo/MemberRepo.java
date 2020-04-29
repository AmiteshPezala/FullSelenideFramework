package MRCS.Locators.MemberCentricRepo;

import org.openqa.selenium.By;

public class MemberRepo {
    public static By MemberLink= By.xpath("//div[contains(text(),'Members')]");
    public static By RecordBeforeSorting= By.xpath("//tr[1]//td[3]//span[2]");
    public static By MemberIdTabColumn= By.xpath("//tr//th[3]");
    public static By MemberIdFilter= By.xpath("//a[@id='ui-tabpanel-16-label']/span");
    public static By MemberIdTextField= By.xpath("//input[@id='MemberId']");
    public static By CheckBox= By.xpath("//tr[1]//td[2]//p-tablecheckbox");
    public static By AssignMemberChasesButton= By.xpath("//span[contains(text(),'Assign Member Chase(s)')]");
    public static By DropDown=By.cssSelector(".ui-autocomplete-dropdown");
    public static By DropDownVaule=By.cssSelector("ng-tns-c73-228 ng-star-inserted ui-autocomplete-list-item ui-corner-all");
    public static By User= By.xpath("//div/ul/li[3]");
    public static By AssignButton= By.xpath("//span[@class='ui-button-text ui-clickable'][contains(text(),'ASSIGN')]");
    public static By AssignedMessage= By.xpath("//div[@class='ui-toast-detail']");
    public static By CheckBoxForBulk= By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-state-default'])[1]");
    public static By FirstExpandButton= By.xpath("(//i[@class='pi pi-chevron-right'])[1]");
    public static By FirstCheckBoxInSubGrid= By.xpath("(//tr[1]//td[1]//p-tablecheckbox)[1]");
    public static By AssignChaseButtonInSubGrid= By.xpath(" //span[contains(text(),'Assign Chase(s)')]");
    public static By FirstChaseIdInSubGrid=By.xpath("(//tr[1]//td[2])[2]");
}
