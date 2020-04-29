package MRCS.Tests.OR2;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CopyChart_TC27 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Copy chart functionality.", groups = {"OR2"})
    public void CopyChart_TC27() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        sleep(2000);
        objclinical.ClinicalLink();
        $(ClinicalRepo.OR2).click();
        sleep(2000);
        ElementsCollection col = $$(ProjectsRepo.member);
        System.out.println(col);
        Log.info("enter into comparison");
        int record = col.size(); // Will get total number of records
        System.out.println(record);
        Log.info("No of cols are : " + record);
        for (int i = 0; i <= record; i++) {
            String member = $x("//tr[" + (i +1) + "]//td[8]").getText();
            Log.info(member);
            $(ProjectsRepo.Filter).click();
            Selenide.sleep(2000);
            $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Member')]").click();
            Selenide.sleep(2000);
            $x("//input[@id='MemberSourceAliasID']").setValue(member);
            Selenide.sleep(4000);
            $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Update')]").click();
            Selenide.sleep(5000);
            String count = $x("//div[@class='total-container']").getText();
            String[] arrSplit_3 = count.split("\\s");
            String ActualCount = null;
            for (int j = 1; j < 2; j++) {
                ActualCount = arrSplit_3[j];
                break;
            }
            int result = Integer.parseInt(ActualCount);
            Log.info(ActualCount);

            if (result > 1) {
                Log.info("in if loop");
                String SourceId = $x("//tr[1]//td[2]//div").getText();
                logTestStep("Source chase Id is = " + " " + SourceId);
                Selenide.sleep(2000);
                String DestinationID = $x("//tr[2]//td[2]//div").getText();
                logTestStep("Destination chase Id is = " + "  " + DestinationID);
                String Memberkey1 = $x("//tr[1]//td[8]").getText();
                Log.info(Memberkey1);
                String Memberkey2 = $x("//tr[2]//td[8]").getText();
                Log.info(Memberkey2);
                if (Memberkey1.equals(member) && Memberkey2.equals(member)) {
                    Log.info("in 2nd if loop");
                    Selenide.sleep(2000);
                    // $(ProjectsRepo.Project).click();
                    //sleep(2000);
                    logTestStep("Clicked on Bulk update link");
                    $x("//span[contains(text(),'Bulk Actions')]").click();
                    Selenide.sleep(2000);
                    $x("//span[contains(text(),'Bulk Changes')]").click();
                    Selenide.sleep(2000);
                    $x("//label[contains(text(),'Select a Type of Bulk Update')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
                    Selenide.sleep(2000);
                    $x("//p-dropdownitem//li").click();
                    Selenide.sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Move Chases'])[1]/following::span[1]").click();
                    Selenide.sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Client'])[1]/following::div[1]").click();
                    Selenide.sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Client'])[1]/following::li[1]").click();
                    Selenide.sleep(2000);
                    $x("//textarea[@id='selectedChaseIds']").sendKeys(DestinationID);
                    Selenide.sleep(2000);
                    $x("//span[contains(text(),'CONTINUE')]").click();
                    $x("//span[contains(text(),'CONTINUE')]").click();
                    Selenide.sleep(3000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Status'])[1]/following::span[1]").click();
                    Selenide.sleep(2000);
                    $x("//span[contains(text(),'Chart collection')]").click();
                    Selenide.sleep(2000);
                    $x("//textarea[@id='chasesNotes']").sendKeys("for testing purpose");
                    Selenide.sleep(2000);
                    $x("//span[contains(text(),'CONTINUE TO VALIDATION')]").click();
                    Selenide.sleep(2000);
                    $x("//span[contains(text(),'FINISH BULK UPDATE')]").click();
                    Selenide.sleep(2000);
                    String message = $x("//div[@class='ui-toast-detail']").getText();
                    assertText(message, "You have successfully completed bulk update.");
                    Selenide.sleep(3000);
                    ClickElement(ClinicalRepo.Clinical,"Clinical link");
                    ClickElement(ClinicalRepo.OR2,"Clicking on OR2");
                    //$(ClinicalRepo.Clinical).click();
                    logTestStep("Clicked on chasequery link");
                    Selenide.sleep(2000);
                    $(ProjectsRepo.Filter).click();
                    Selenide.sleep(2000);
                    $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
                    Selenide.sleep(2000);
                    $x("//input[@id='ChaseIdAndClientChaseKey']").sendKeys(SourceId);
                    Selenide.sleep(2000);
                    $(ProjectsRepo.Update).click();
                    Selenide.sleep(5000);
                    $x("//app-icon[@class='fa fa-step-backward']").click();
                    Selenide.sleep(2000);
                    $x("//span[@class='fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted']").click();
                    Selenide.sleep(2000);
                    $(CommonRepo.CopyChart).click();
                    Selenide.sleep(2000);
                    $x("//app-basic-grid[@class='grids-display']//p-tablecheckbox[@class='ng-star-inserted']").click();
                    Selenide.sleep(2000);
                    $(CommonRepo.CopyChartButton).click();
                    Selenide.sleep(2000);
                    String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
                    assertText(SuccessfulMessage, "Chart copied Successfully.");
                    break;
                } else {

                }
            } else {

                Log.info("in else loop");
            }
            Selenide.sleep(7000);
            $(CommonRepo.ResetButton).click();
            Selenide.sleep(7000);
        }
        objLoginOut.logout();
    }
}
