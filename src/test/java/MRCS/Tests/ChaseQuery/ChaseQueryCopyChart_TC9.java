package MRCS.Tests.ChaseQuery;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class ChaseQueryCopyChart_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();

    @Test(description = "Verify copy chart", groups = {"Chase Query"})
    public void ChaseQueryCopyChart_TC9() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objProject.ProjectsLink();
        logTestStep("Click on project link");
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $(ProjectsRepo.Project).click();
        logTestStep("Click on filter project");
        sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        sleep(2000);
        //$x("(.//*[normalize-space(text()) and normalize-space(.)='Projects'])[4]/following::span[1]").click();
        //logTestStep("Selecting all projects");
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        $(ProjectsRepo.Update).click();
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        logTestStep("Click on update button");
        ElementsCollection col = $$(ProjectsRepo.member);
        System.out.println(col);
        Log.info("enter into comparison");
        int record = col.size(); // Will get total number of records
        System.out.println(record);
        Log.info("No of cols are : " + record);
        for (int i = 0; i <= record; i++) {
            String member = $x("//tr[" + (i +9) + "]//td[8]").getText();
            Log.info(member);
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Member')]").click();
            sleep(2000);
            $x("//input[@id='MemberSourceAliasID']").setValue(member);
            sleep(4000);
            $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Update')]").click();
            sleep(10000);
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
                   /* $x("(.//*[normalize-space(text()) and normalize-space(.)='Select a Type of Bulk Update'])[2]/following::div[1]").click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='CONTINUE'])[1]/following::li[1]").click();
                    sleep(2000);*/
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Move Chases'])[1]/following::span[1]").click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Client'])[1]/following::div[1]").click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Select Client'])[1]/following::li[1]").click();
                    sleep(2000);
                    $x("//textarea[@id='selectedChaseIds']").sendKeys(DestinationID);
                    sleep(2000);
                    $x("//span[contains(text(),'CONTINUE')]").click();
                   // $x("//span[contains(text(),'CONTINUE')]").click();
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
                    $(ProjectsRepo.ProjectsLink).click();
                    sleep(2000);
                    $(ProjectsRepo.ChaseQueryHEDIS).click();
                    //$(ClinicalRepo.Clinical).click();
                    logTestStep("Clicked on chasequery link");
                    sleep(2000);
                    $(ProjectsRepo.Filter).click();
                    sleep(2000);
                    $(ProjectsRepo.Project).click();
                    logTestStep("Click on filter project");
                    sleep(2000);
                    $x("//span[contains(text(),'2020 HEDIS 1')]").click();
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
                    $x("//span[contains(text(),'Copy Chart')]").click();
                    sleep(2000);
                    $x("//app-basic-grid[@class='grids-display']//p-tablecheckbox[@class='ng-star-inserted']").click();
                    sleep(2000);
                    $x("(//span[contains(text(),'Copy Chart')])[2]").click();
                    sleep(2000);
                    String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
                    assertText(Successfulmessage, "Chart copied Successfully.");
                    break;
                } else {

                }
            } else {

                Log.info("in else loop");
            }
            sleep(7000);
            $(CommonRepo.ResetButton).click();
            sleep(10000);
        }

        objLoginOut.logout();
        logTestStep("User get logged out");
    }
}