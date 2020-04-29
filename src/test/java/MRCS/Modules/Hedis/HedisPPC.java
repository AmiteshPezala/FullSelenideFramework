package MRCS.Modules.Hedis;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisPPCRepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.logTestStep_ColorGreen;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HedisPPC {
    public static void NavigateToPPC() throws Exception {
//        Common.getUserAndAssignTo();
//        sleep(2000);
//        ClickElement(ProjectsRepo.Measure,"Clicking on Measure");
//        sleep(2000);
//        Log.info("Clicked on Measures tab");
//        ClickElement(MeasureRepo.PPC,"Selecting TRC");
//        sleep(2000);
//        ClickElement(ProjectsRepo.Update,"Clicking on Update");
//        sleep(5000);
//        Common.waitForPageLoadToComplete();
//        Common.SelectChaseAndOpenChart();
        String user=Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.PPC,"Selecting");
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
    }
    public static void DODFromMedRecords() throws Exception {
        String CurrentDate = Common.GetCurrentTimeStamp();
        $(HedisPPCRepo.DODFromMedRecordsDate).setValue("10/07/2019");
        Thread.sleep(2000);
        $(HedisPPCRepo.DODFromMedRecordsPage).setValue("1");
        Thread.sleep(2000);
        ClickElement(CommonRepo.ClickToSave, "Click to save");
        logTestStep_ColorGreen("Date of Delivery (Admin):" + "10/07/2019");
    }
    public static void SaveData() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
    }
}
