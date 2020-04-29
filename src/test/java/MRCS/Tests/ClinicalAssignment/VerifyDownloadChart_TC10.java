package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class VerifyDownloadChart_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();

    @Test(description = "Verify download chart", groups = {"Clinical Assignment"})
    public void VerifyDownloadChart_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(10000);
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(4000);
        $x("(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]").click();
        sleep(2000);
        $x("(//p-dropdownitem//li)[4]").click();
        $x("(//p-dropdownitem//li)[4]").click();
        sleep(5000);
        ElementsCollection col = $$(ProjectsRepo.member);
        System.out.println(col);
        Log.info("enter into comparison");
        int record = col.size(); // Will get total number of records
        System.out.println(record);
        Log.info("No of cols are : " + record);
        for (int i = 0; i <= record; i++) {
            String member = $x("//tr[" + (i + 1) + "]//td[8]").getText();
            logTestStep(member);
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Member')]").click();
            sleep(2000);
            $x("//input[@id='MemberSourceAliasID']").setValue(member);
            sleep(4000);
            $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Update')]").click();
            //objWait.implicitwait();
            sleep(2000);

            String count = $x("//div[@class='total-container']").getText();
            String[] arrSplit_3 = count.split("\\s");
            String ActualCount = null;
            for (int j = 1; j < 2; j++) {
                ActualCount = arrSplit_3[j];
                break;
            }
            int result = Integer.parseInt(ActualCount);
            logTestStep(ActualCount);

            if (result > 1) {
                logTestStep("in if loop");
                String SourceId = $x("//tr[1]//td[2]//div").getText();
                logTestStep(SourceId);
                sleep(2000);
                String DestinationID = $x("//tr[2]//td[2]//div").getText();
                logTestStep(DestinationID);
                String Memberkey1 = $x("//tr[1]//td[8]").getText();
                Log.info(Memberkey1);
                String Memberkey2 = $x("//tr[2]//td[8]").getText();
                Log.info(Memberkey2);
                if (Memberkey1.equals(member) && Memberkey2.equals(member)) {
                    Log.info("in 2nd if loop");
                    sleep(2000);
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
                    $(ClinicalRepo.Clinical).click();
                    logTestStep("Clicked on clinical link");
                    sleep(2000);
                    $(ClinicalRepo.Assignment).click();
                    logTestStep("Clicked on MRR link");
                    sleep(2000);
                    $(ProjectsRepo.Filter).click();
                    sleep(2000);
                    $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
                    //$(ProjectsRepo.ChaseQueryHEDIS).click();
                    sleep(2000);
                    $x("//input[@id='ChaseIdAndClientChaseKey']").sendKeys(SourceId);
                    // $(ProjectsRepo.ChaseId).sendKeys(SourceId);
                    sleep(2000);
                    $(ProjectsRepo.Update).click();
                    sleep(2000);
                    $x("//span[@class='fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted']").click();
                    sleep(2000);
                    $(CommonRepo.CopyChart).click();
                    sleep(2000);
                    $x("//app-basic-grid[@class='grids-display']//p-tablecheckbox[@class='ng-star-inserted']").click();
                    sleep(2000);
                    $(CommonRepo.CopyChartButton).click();
                    sleep(2000);
                    String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
                    assertText(Successfulmessage, "Chart copied Successfully.");
                    sleep(2000);
                    $x("//span[@class='fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted']").click();
                    sleep(2000);
                    $x("//span[contains(text(),'Download Chart')]").click();
                    sleep(3000);
                    String SuccessfulDownloadMessage = $x("//div[@class='ui-toast-detail']").getText();
                    assertText(SuccessfulDownloadMessage, "Your request is being processed and you will be alerted when the file is ready for download");
                    sleep(3000);
                    WebDriverRunner.getWebDriver().navigate().refresh();
                    sleep(10000);
                    logTestStepPass("Clicked on notification icon");
                    $x("//div[@class='jobsqueue jobs__unread']").click();
                    sleep(4000);
                    $x("//span[@class='bold']").click();
                    logTestStepPass("Clicked on the chase id for which chart is downloaded");
                    sleep(4000);
                    $x("//tr[1]//td[4]//app-button[1]//p-button[1]//button[1]//span[1]").click();
                    sleep(2000);
                    $x("//span[contains(text(),'View File')]").click();
                    logTestStepPass("Clicked on view file option");
                    sleep(10000);
                    File folder = new File(System.getProperty("user.dir"));
                    //We find the download links
                    //List the files on that folder
                    boolean DownloadingFilePresence = false;
                    File[] listOfFiles = folder.listFiles();
                    for (int k = 0; k < listOfFiles.length; k++) {
                        if (listOfFiles[k].getName().endsWith(".pdf")) {
                            // File has been found, it can now be deleted:
                            DownloadingFilePresence = listOfFiles[k].getName().endsWith(".pdf");
                            logTestStep(listOfFiles[k].getName());
                            listOfFiles[k].delete();
                        }
                    }
                    Assert.assertTrue(DownloadingFilePresence, "Downloaded document is not found");
                    sleep(5000);
                    break;
                } else {

                }
            } else {

                Log.info("in else loop");
            }
            sleep(7000);
            $x("//div[@class='chip__item']").click();
            sleep(7000);
        }

        objLoginOut.logout();
        logTestStep("User get logged out");
    }
}
