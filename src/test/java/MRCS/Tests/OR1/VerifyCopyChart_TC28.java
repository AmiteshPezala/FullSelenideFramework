package MRCS.Tests.OR1;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCopyChart_TC28 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    Clinical objClinical = new Clinical();

    @Test(description = "Verify copy chart", groups = {"OR1"})
    public void VerifyCopyChart() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        logTestStep("Clicking on OR1");
        ClickElement(ClinicalRepo.OR1,"Clicking on OR1");
        sleep(5000);
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
            sleep(2000);
            $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Member')]").click();
            sleep(2000);
            $x("//input[@id='MemberSourceAliasID']").setValue(member);
            sleep(4000);
            $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Update')]").click();
            sleep(5000);
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
                sleep(2000);
                String DestinationID = $x("//tr[2]//td[2]//div").getText();
                logTestStep("Destination chase Id is = " + "  " + DestinationID);
                String Memberkey1 = $x("//tr[1]//td[8]").getText();
                Log.info(Memberkey1);
                String Memberkey2 = $x("//tr[2]//td[8]").getText();
                Log.info(Memberkey2);
                if (Memberkey1.equals(member) && Memberkey2.equals(member)) {
                    Log.info("in 2nd if loop");
                    sleep(2000);
                    // $(ProjectsRepo.Project).click();
                    //sleep(2000);
                    logTestStep("Clicked on Bulk update link");
                    $x("//span[contains(text(),'Bulk Actions')]").click();
                    sleep(2000);
                    $x("//span[contains(text(),'Bulk Changes')]").click();
                    sleep(2000);
                    $x("//label[contains(text(),'Select a Type of Bulk Update')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
                    sleep(2000);
                    $x("//p-dropdownitem//li").click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Move Chases'])[1]/following::span[1]").click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Client'])[1]/following::div[1]").click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Client'])[1]/following::li[1]").click();
                    sleep(2000);
                    $x("//textarea[@id='selectedChaseIds']").sendKeys(DestinationID);
                    sleep(2000);
                    $x("//span[contains(text(),'CONTINUE')]").click();
                    $x("//span[contains(text(),'CONTINUE')]").click();
                    sleep(3000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Status'])[1]/following::span[1]").click();
                    sleep(2000);
                    $x("//span[contains(text(),'Chart collection')]").click();
                    sleep(2000);
                    $x("//textarea[@id='chasesNotes']").sendKeys("for testing purpose");
                    sleep(2000);
                    $x("//span[contains(text(),'CONTINUE TO VALIDATION')]").click();
                    sleep(2000);
                    $x("//span[contains(text(),'FINISH BULK UPDATE')]").click();
                    sleep(2000);
                    String message = $x("//div[@class='ui-toast-detail']").getText();
                    assertText(message, "You have successfully completed bulk update.");
                    sleep(3000);
                    ClickElement(ClinicalRepo.Clinical,"Clinical link");
                    ClickElement(ClinicalRepo.OR1,"Clicking on OR1");
                    //$(ClinicalRepo.Clinical).click();
                    logTestStep("Clicked on chasequery link");
                    sleep(2000);
                    $(ProjectsRepo.Filter).click();
                    sleep(2000);
                    $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
                    sleep(2000);
                    $x("//input[@id='ChaseIdAndClientChaseKey']").sendKeys(SourceId);
                    sleep(2000);
                    $(ProjectsRepo.Update).click();
                    sleep(2000);
                    $x("//app-icon[@class='fa fa-step-backward']").click();
                    sleep(2000);
                    $x("//span[@class='fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted']").click();
                    sleep(2000);
                    $(CommonRepo.CopyChart).click();
                    sleep(2000);
                    $x("//app-basic-grid[@class='grids-display']//p-tablecheckbox[@class='ng-star-inserted']").click();
                    sleep(2000);
                    $(CommonRepo.CopyChartButton).click();
                    sleep(2000);
                    String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
                    assertText(SuccessfulMessage, "Chart copied Successfully.");
                    break;
                } else {

                }
            } else {

                Log.info("in else loop");
            }
            sleep(7000);
            $(CommonRepo.ResetButton).click();
            sleep(7000);
        }
        objLoginOut.logout();
    }
}
