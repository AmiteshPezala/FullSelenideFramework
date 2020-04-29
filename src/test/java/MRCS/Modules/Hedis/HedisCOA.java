package MRCS.Modules.Hedis;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisCOARepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HedisCOA {

    public static void NavigateToCOA() throws Exception {
//        Common.getUserAndAssignTo();
//        ClickElement(ProjectsRepo.Measure,"Clicking on Measure");
//        Log.info("Clicked on Measures tab");
//        ClickElement(MeasureRepo.COA,"Selecting");
//        ClickElement(ProjectsRepo.Update,"Clicking on Update");
//        sleep(5000);
//        Common.waitForPageLoadToComplete();
//        Common.SelectChaseAndOpenChart();
        String user=Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.COA,"Selecting");
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        Common.waitForLoader();
        //Common.waitForPageLoadToComplete();
        waitForElementToBeClickable(By.xpath("//tr[1]//th[1]")).click();
        waitForElementToBeClickable(CommonRepo.assignChase).click();
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(user);
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ARROW_DOWN);
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        waitForElementToBeClickable(CommonRepo.assignButton).click();
        Common.waitForLoader();
        Common.SelectChaseAndOpenChart();
        //Common.waitForPageLoadToComplete();

    }
    public static void ACPShowsPositiveCompliance() throws InterruptedException {
        String text=Common.getElementText(By.xpath("//*[contains(text(),'Advanced Care Planning Found On Qualifying Undated Document or in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 10; i < 11; i++) {
            count = arrSplit_3[i];
            break;
        }
        System.out.println(count);
        //String CurrentDate=Common.GetCurrentTimeStamp();
        //System.out.println(CurrentDate);
        $(HedisCOARepo.ACPDate).setValue(count);
        sleep(2000);
        $(HedisCOARepo.ACPPageNumber).setValue("1");
        sleep(2000);
    }
    public static void MRShowsPositiveCompliance() throws InterruptedException {
        String text=Common.getElementText(By.xpath("//*[contains(text(),'Medication Review in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 3; i < 4; i++) {
            count = arrSplit_3[i];
            break;
        }
        System.out.println(count);
//        String CurrentDate=Common.GetCurrentTimeStamp();
//        System.out.println(CurrentDate);
        $(HedisCOARepo.MRDate).setValue(count);
        sleep(2000);
        $(HedisCOARepo.MRPageNumber).setValue("1");
        sleep(2000);
        ClickElement($x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[2]"),"Dropdown");
        ClickElement($x("(//span[contains(text(),'Yes')])[2]"),"Selecting Yes");
        ClickElement($x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[3]"),"Dropdown");
        ClickElement($x("(//span[contains(text(),'Yes')])[2]"),"Selecting Yes");

    }
    public static void PainAssessmentShowPositiveCompliance() throws InterruptedException {
        String text=Common.getElementText(By.xpath("//*[contains(text(),'Pain Assessment in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 3; i < 4; i++) {
            count = arrSplit_3[i];
            break;
        }
        System.out.println(count);
//        String CurrentDate=Common.GetCurrentTimeStamp();
//        System.out.println(CurrentDate);
        $(HedisCOARepo.PainAssessmentDate).setValue(count);
        sleep(2000);
        $(HedisCOARepo.PainAssessmentPageNumber).setValue("1");
        sleep(2000);
    }
    public static void FSA() throws InterruptedException {
        String text=Common.getElementText(By.xpath("//*[contains(text(),'Functional Status Assessment in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 4; i < 5; i++) {
            count = arrSplit_3[i];
            break;
        }
        System.out.println(count);
//        String CurrentDate=Common.GetCurrentTimeStamp();
//        System.out.println(CurrentDate);
        $(HedisCOARepo.CognitiveDate).setValue(count);
        sleep(2000);
        $(HedisCOARepo.CognitivePageNumber).setValue("1");
        sleep(2000);
        $(HedisCOARepo.AmbulationDate).setValue(count);
        sleep(2000);
        $(HedisCOARepo.AmbulationPageNumber).setValue("1");
        sleep(2000);
        $(HedisCOARepo.OtherFunctionalDate).setValue(count);
        sleep(2000);
        $(HedisCOARepo.OtherFunctionalPageNumber).setValue("1");
        sleep(2000);
    }
    public static void ClearData() throws InterruptedException {
        int ClearIcon = $$(HedisCOARepo.ClearIcon).size();
        for(int i=1;i<=ClearIcon-1;i++)
        {
            ClickElement($x("(//button[@title='Clear'])[" +(i+0)+ "]"),"Clearing data");
            sleep(1000);
        }
        sleep(2000);
    }
    public static void DeleteData() throws InterruptedException {
        int ClearIcon = $$x("//button[@class='control__delete']").size();
        for(int i=1;i<=ClearIcon;i++)
        {
            ClickElement($x("(//button[@class='control__delete'])[" +(i+0)+ "]"),"Clearing data");
            sleep(3000);
        }
        sleep(2000);
    }
}
