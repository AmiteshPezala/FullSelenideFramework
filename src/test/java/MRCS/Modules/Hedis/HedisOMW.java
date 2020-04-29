package MRCS.Modules.Hedis;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class HedisOMW {

    public static void navigateToOMW() throws Exception {
        String user= Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.OMW,"Selecting");
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        Common.waitForLoader();
        //Common.waitForPageLoadToComplete();
        waitForElementToBeClickable(By.xpath("//tr[1]//th[1]")).click();
        waitForElementToBeClickable(CommonRepo.assignChase).click();
        sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(user);
        sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ENTER);
        sleep(2000);
        waitForElementToBeClickable(CommonRepo.assignButton).click();
        Common.waitForLoader();
        Common.SelectChaseAndOpenChart();
    }
}
