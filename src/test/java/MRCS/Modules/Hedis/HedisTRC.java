package MRCS.Modules.Hedis;

import MRCS.Locators.CommonRepo;
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
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HedisTRC {

    public static void NavigateToTRC() throws Exception {
//        Common.getUserAndAssignTo();
//        ClickElement(ProjectsRepo.Measure,"Clicking on Measure");
//        Log.info("Clicked on Measures tab");
//        ClickElement(MeasureRepo.TRC,"Selecting TRC");
//        ClickElement(ProjectsRepo.Update,"Clicking on Update");
//        sleep(5000);
//        Common.waitForPageLoadToComplete();
//        Common.SelectChaseAndOpenChart();
        String user=Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.TRC,"Selecting");
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
    public static void ClearData() throws InterruptedException {
        int ClearIcon = $$x("//button[@title='Clear']").size();
        for(int i=1;i<=ClearIcon;i++)
        {
            $x("(//button[@title='Clear'])[" +(i+0)+ "]").click();
            sleep(3000);
        }
        sleep(2000);
    }
    public static void SaveData() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        $x("//th[contains(text(),'Chase Compliance')]").click();
    }
}
