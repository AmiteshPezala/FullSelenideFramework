package MRCS.Locators.MRRRepo;

import org.openqa.selenium.By;

public class MemberChasesRepo {
    public static By MemberChasesTab=By.xpath("//div[contains(text(),'Member Chases')]");
    public static By FirstCheckBox=By.xpath("//tr[1]//td[1]//p-tablecheckbox");
    public static By AssignChaseButton= By.xpath("//span[contains(text(),'Assign Chase(s)')]");
    public static By UnAssignChase= By.xpath("//span[contains(text(),'Unassign Chase(s)')]");
    public static By CheckBoxForBulkAssign= By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-state-default'])[1]");

}
