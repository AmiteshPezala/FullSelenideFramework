package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisCOARepo {
    public static By ACPDate=By.xpath("(//div[contains(text(),'Advanced Care Planning Found On Qualifying Undated Document or in 2018')]//following::input)[1]");
    public static By ACPPageNumber=By.xpath("(//div[contains(text(),'Advanced Care Planning Found On Qualifying Undated Document or in 2018')]//following::input)[2]");
    public static By MRDate=By.xpath("(//div[contains(text(),'Medication Review in 2018')]//following::input)[1]");
    public static By MRPageNumber=By.xpath("(//div[contains(text(),'Medication Review in 2018')]//following::input)[4]");
    public static By PainAssessmentDate=By.xpath("(//div[contains(text(),'Pain Assessment in 2018')]//following::input)[1]");
    public static By PainAssessmentPageNumber=By.xpath("(//div[contains(text(),'Pain Assessment in 2018')]//following::input)[2]");
    public static By CognitiveDate=By.xpath("(//div[contains(text(),'Three of four of the following:')]//following::input)[1]");
    public static By CognitivePageNumber=By.xpath("(//div[contains(text(),'Three of four of the following:')]//following::input)[2]");
    public static By AmbulationDate=By.xpath("(//div[contains(text(),'Three of four of the following:')]//following::input)[3]");
    public static By AmbulationPageNumber=By.xpath("(//div[contains(text(),'Three of four of the following:')]//following::input)[4]");
    public static By OtherFunctionalDate=By.xpath("(//div[contains(text(),'Three of four of the following:')]//following::input)[5]");
    public static By OtherFunctionalPageNumber=By.xpath("(//div[contains(text(),'Three of four of the following:')]//following::input)[6]");
    public static By ADLDate=By.xpath("(//div[contains(text(),'ADL Assessment')]//following::input)[1]");
    public static By ADLPageNumber=By.xpath("(//div[contains(text(),'ADL Assessment')]//following::input)[2]");
    public static By IADLAssessmentNumber=By.xpath("(//div[contains(text(),'IADL Assessment')]//following::input)[2]");
    public static By IADLAssessmentDate=By.xpath("(//div[contains(text(),'IADL Assessment')]//following::input)[1]");
    public static By ClearIcon=By.xpath("//button[@title='Clear']");

}
