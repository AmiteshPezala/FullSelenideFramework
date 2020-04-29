package MRCS.Locators;

import org.openqa.selenium.By;

public class CommonRepo {
    public static By ClickToSave=By.xpath("//th[@title='Numerator']");
    public static By SubmitMeasure=By.xpath("(//span[contains(text(),'Submit')])[2]");
    public static By AssignToUser=By.xpath("//input[@id='AssignedToUserId']");
    public static By AssignTo=By.xpath("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]");
    public static By FirstChaseId=By.xpath("//tr[1]//td[2]");
    public static By FirstMRQARecord=By.xpath("//tr[1]//td[2]//div");
    public static By Save=By.xpath("//span[contains(text(),'Save')]");
    public static By FirstCheckbox=By.xpath("//tr[1]//td[1]");
    public static By ResetButton=By.xpath("//div[contains(text(),'Reset All')]");
    public static By CopyChart=By.xpath("(//span[contains(text(),'Copy Chart')])[1]");
    public static By CopyChartButton=By.xpath("(//span[contains(text(),'Copy Chart')])[2]");
    public static By BackwardButton=By.cssSelector(".fa.fa-step-backward");
    public static By SecondChaseId=By.xpath("//tr[2]//td[1]");
    public static By Loader=By.cssSelector(".loader.fa.fa-spinner");
    public static By assignChase=By.xpath("//*[text()='Assign Chase(s)']");
    public static By assignChaseToUser=By.xpath("//*[@id='assignToUsers']");
    public static By assignButton=By.xpath("//*[text()='ASSIGN']");

}
