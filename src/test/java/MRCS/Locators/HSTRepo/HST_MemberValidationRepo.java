package MRCS.Locators.HSTRepo;

import org.openqa.selenium.By;

public class HST_MemberValidationRepo {

    public static By NoButton= By.xpath("//span[contains(text(),'No')]");
    public static By SubmitButton= By.xpath("//span[contains(text(),'Submit')]");
    public static By PageNumber= By.xpath("//input[@id='PageNumber']");
    public static By SelectDropdown= By.xpath("//select[@class='input input__reasons ng-dirty ng-valid ng-touched']");
    public static By SubmitButtonNew= By.xpath("(//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-disabled'])[1]");
}
