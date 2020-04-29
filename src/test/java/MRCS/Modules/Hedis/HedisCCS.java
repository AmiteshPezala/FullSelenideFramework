package MRCS.Modules.Hedis;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisCCSRepo;
import MRCS.Locators.HedisRepo.HedisCOARepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.logTestStepFail;
import static MRCS.Utils.TestBase.logTestStepPass;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HedisCCS {
    public static void NavigateToCCS() throws Exception {
//        Common.getUserAndAssignTo();
//        ClickElement(ProjectsRepo.Measure,"Clicking on Measure");
//        Log.info("Clicked on Measures tab");
//        ClickElement(MeasureRepo.CCS,"Selecting CCS");
//        ClickElement(ProjectsRepo.Update,"Clicking on Update");
//        Common.waitForPageLoadToComplete();
//        sleep(5000);
//        Common.SelectChaseAndOpenChart();
        String user=Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.CCS,"Selecting");
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
    public static void VerifyPositiveCompliance() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        String GetMsg=$x("(//tr[1]//td[2])[1]").getText();
        if(GetMsg.equals("C/MR")){
            logTestStepPass("Cervical cancer screening Compliance shows +ve");
        }else{
            logTestStepFail("Cervical cancer screening Compliance not shows +ve");
            Assert.fail("Cervical cancer screening Compliance not shows +ve");
        }
    }
    public static void PapSmearPositiveCompliance() throws InterruptedException {
        String text=Common.getElementText(By.xpath("//*[contains(text(),'Pap Test with Results in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 5; i < 10; i++) {
            count = arrSplit_3[i];
            break;
        }
        $(HedisCCSRepo.PapSmearDate).setValue(count);
        sleep(2000);
        $(HedisCCSRepo.PapResultDropDown).click();
        sleep(1000);
        $(HedisCCSRepo.YesButton).click();
        sleep(2000);
        $(HedisCCSRepo.PapSmearPageNumber).setValue("1");
        sleep(2000);
    }
    public static void ClearData() throws InterruptedException {
        int ClearIcon = $$(HedisCOARepo.ClearIcon).size();
        for(int i=1;i<=ClearIcon;i++)
        {
            ClickElement($x("(//button[@title='Clear'])[" +(i+0)+ "]"),"Clearing data");
            sleep(3000);
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

    public static void HPVPositiveCompliance() throws InterruptedException {
//        String CurrentDate=Common.GetCurrentTimeStamp();
        String text=Common.getElementText(By.xpath("//*[contains(text(),'HPV (hrHPV) Test with Results in')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 6; i < 11; i++) {
            count = arrSplit_3[i];
            break;
        }
        System.out.println(count);
        $(HedisCCSRepo.HPVTestDate).setValue(count);
        sleep(2000);
        $(HedisCCSRepo.HPVTestDropDown).click();
        sleep(1000);
        $(HedisCCSRepo.YesButton).click();
        sleep(2000);
        $(HedisCCSRepo.HPVTestPageNumber).setValue("1");
        sleep(2000);
    }
}
