package MRCS.Modules.Hedis;

import MRCS.Locators.CommonRepo;
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
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class HedisCOL {

    public static void NavigateToCOL() throws Exception {
//        Common.getUserAndAssignTo();
//        ClickElement(ProjectsRepo.Measure,"Clicking on Measure");
//        Log.info("Clicked on Measures tab");
//        ClickElement(MeasureRepo.COL,"Selecting Col");
//        ClickElement(ProjectsRepo.Update,"Clicking on Update");
//        sleep(5000);
//        Common.waitForPageLoadToComplete();
//        Common.SelectChaseAndOpenChart();
        String user=Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.COL,"Selecting");
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
    public static void DeleteIcon() throws InterruptedException {
        int DeleteIcon=$$x("//button[contains(text(),'×')]").size();
        for(int j=1;j<=DeleteIcon;j++)
        {
            ClickElement($x("(//button[contains(text(),'×')])[" +(j+0)+ "]"),"Deleting data");
            sleep(1000);
        }
        sleep(2000);
    }
    public static void ClearIcon() throws InterruptedException {
        int ClearIcon = $$x("//button[@title='Clear']").size();
        for(int i=1;i<=ClearIcon;i++)
        {
            ClickElement($x("(//button[@title='Clear'])[" +(i+0)+ "]"),"Clearing data");
            sleep(1000);
        }
        sleep(2000);
    }
}
