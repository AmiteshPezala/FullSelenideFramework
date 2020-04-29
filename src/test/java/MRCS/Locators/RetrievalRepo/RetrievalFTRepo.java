package MRCS.Locators.RetrievalRepo;

import org.openqa.selenium.By;

public class RetrievalFTRepo {
    public static By Count=By.xpath("(//span[@class='clearStat'])[6]");
    public static By FirstFTAID=By.xpath("//tr[1]//td[1]");
    public static By PendChase=By.xpath("//span[contains(text(),'Pend Chase(s)')]");
    public static By SaveButton=By.xpath("//span[contains(text(),'Save')]");
    public static By TextArea=By.xpath("//textarea[@id='notes']");
    public static By ScheduleTab=By.xpath("//*[text()='Schedule']");
    public static By FTUsers=By.xpath("//*[text()='Field Tech USERS']");
    public static By FTAppointments=By.xpath("//*[text()='Field Tech APPOINTMENTS']");
    public static By ExportAll=By.xpath("//*[text()='Export All']");
}
