package MRCS.Locators.RetrievalRepo;

import org.openqa.selenium.By;

public class IntakeRepo {

    public static By MrrFirstChaseId=By.xpath("//tr[1]//td[2]//div[1]");
    public static By IntakeFileName=By.xpath("//tr[1]//td[2]//a");
    public static By AcceptButton=By.xpath("//span[contains(text(),'ACCEPT')]");
    public static By DeleteIcon=By.xpath("(//div[@class='delete-button'])[1]");
    public static By ToasterMsg=By.cssSelector(".pi.pi-times");
    public static By CoverLetter=By.xpath("//span[contains(text(),'THIS IS A COVER LETTER')]");
    public static By CoverBegPage=By.xpath("//input[@formcontrolname='coverBegPage']");
    public static By CoverEndPage=By.xpath("//input[@formcontrolname='coverEndPage']");
    public static By CoverChaseId=By.xpath("//input[@formcontrolname='coverChaseId']");
    public static By YesButton=By.xpath("//span[contains(text(),'YES')]");

}
