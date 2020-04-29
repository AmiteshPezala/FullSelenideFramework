package MRCS.Modules.Hedis;

import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class IVAHST {

    public static void FilterByUserAndMeasure() throws Exception {
       Common.getUserAndAssignTo();
        ClickElement(ProjectsRepo.Measure, "Clicking on Measure");
       sleep(2000);
        Log.info("Clicked on Measures tab");
        ClickElement(MeasureRepo.HST, "Selecting HST");
        sleep(2000);
        ClickElement(ProjectsRepo.Update, "Clicking on Update");
       sleep(2000);
       Common.waitForPageLoadToComplete();
        sleep(10000);
        Common.SelectChaseAndOpenChart();
        /*String user=Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.HST,"Selecting");
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
        Common.SelectChaseAndOpenChart();*/
    }
}
