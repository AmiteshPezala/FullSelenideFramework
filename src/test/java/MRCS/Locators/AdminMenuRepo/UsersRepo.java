package MRCS.Locators.AdminMenuRepo;

import org.openqa.selenium.By;

public class UsersRepo {
    public static By ExportButton=By.xpath("//span[contains(text(),'Export All')]");
    public static By InActiveRadioButton=By.xpath("(//span[@class='ui-radiobutton-icon ui-clickable'])[2]");
    public static By AddUserButton=By.xpath("//span[contains(text(),'ADD USER')]");
    public static By FirstNameTextField=By.xpath("//*[@id='firstName']");
    public static By LastNameTextField=By.xpath("//*[@id='lastName']");
    public static By EmailTextField=By.xpath("//*[@id='email']");
    public static By LoginNameTextField=By.xpath("//*[@id='loginName']");
    public static By Role=By.xpath("//span[contains(text(),'Role')]");
    public static By DropDown=By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']");
    public static By AdminRole=By.xpath("//html/body/div[2]/div/ul/li[3]/span");
    public static By FirstRecord=By.xpath("//tr[1]//td[1]//a");
    public static By RoleSetup=By.xpath("//div[contains(text(),'Role Setup')]");
    public static By AdminRoles=By.xpath("//*[@class='fa fa-user']");
    public static By LeadRoles=By.xpath("//*[@class='fa fa-star']");
    public static By FirstCheckboxRole=By.xpath("//span[@class='checkmark']");
    public static By SaveButton=By.xpath("//span[contains(text(),'SAVE USER')]");
    public static By Name=By.xpath("//span[contains(text(),'Name')]");
    public static By NameTextField=By.xpath("//input[@id='Name']");
    public static By SecondRecord=By.xpath("//tr[1]//td[2]");
    public static By UserCount=By.xpath("(//a[@class='users-land-stats-item bold'])[1]");

}
