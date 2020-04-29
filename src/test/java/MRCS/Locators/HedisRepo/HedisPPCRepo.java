package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisPPCRepo {
    public static By DateOfEnrollmentDate2=By.xpath("//div[contains(text(),'Date of Enrollment (Admin)')]//following::input[2]");
    public static By DateOfEnrollmentDate1=By.xpath("//div[contains(text(),'Date of Enrollment (Admin)')]//following::input[1]");
    public static By PrenatalStartDate=By.xpath("(//label[contains(text(),'Prenatal Start Date')]//following::div)[1]");
    public static By PostpartumStartDate=By.xpath("(//label[contains(text(),'Postpartum Start Date')]//following::div)[1]");
    public static By DODPostpartumStartDate=By.xpath("(//label[contains(text(),'DOD Postpartum Start Date')]//following::div)[1]");
    public static By DODFromMedRecordsDate=By.xpath("//div[contains(text(),'DOD from Med. Records')]//following::input[1]");
    public static By DODFromMedRecordsPage=By.xpath("//div[contains(text(),'DOD from Med. Records')]//following::input[2]");
    public static By DODPrenatalStartDate=By.xpath("(//label[contains(text(),'DOD Prenatal Start Date')]//following::div)[1]");
    public static By PrenatalVisitDate=By.xpath("//div[contains(text(),'Prenatal Visit:')]//following::input[1]");
    public static By PrenatalVisitDropDown1=By.xpath("//div[contains(text(),'Prenatal Visit:')]//following::button[1]");
    public static By PrenatalVisitDropDown2=By.xpath("//div[contains(text(),'Prenatal Visit:')]//following::button[2]");
    public static By PrenatalVisitPage=By.xpath("//div[contains(text(),'Prenatal Visit:')]//following::input[4]");
    public static By PostPartumVisitDate=By.xpath("//div[contains(text(),'PostPartum Visit:')]//following::input[1]");
    public static By PostPartumVisitDown1=By.xpath("//div[contains(text(),'PostPartum Visit:')]//following::button[1]");
    public static By PostPartumVisitDropDown2=By.xpath("//div[contains(text(),'PostPartum Visit:')]//following::button[2]");
    public static By PostPartumVisitPage=By.xpath("//div[contains(text(),'PostPartum Visit:')]//following::input[4]");

}
