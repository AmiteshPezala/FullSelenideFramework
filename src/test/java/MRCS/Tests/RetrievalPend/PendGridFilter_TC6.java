package MRCS.Tests.RetrievalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendGridFilter_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();
    Common objCommon = new Common();

    @Test(description = "Verify the filter functionality", groups = {"Retrieval Pend"})
    public void PendGridFilter_TC6() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        sleep(2000);
        $(RetrievalPendRepo.TotalPend).click();
        sleep(5000);
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
        sleep(2000);
        logTestStep("Checking filter with the pend code status option");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[4]/following::span[2]").click();
        sleep(2000);
        logTestStep("Checking for the status - New");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
        sleep(5000);
        if($x("//tr[1]//td[8]").exists()){
            String Status = $x("//tr[1]//td[8]").getText();
            assertText(Status,"New");
        }else {
            logTestStep("There is no record for this status ");
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
            sleep(2000);
            $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Reset All')]").click();
            sleep(2000);
            logTestStep("Checking for the status - In Progress");
            $x("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::span[2]").click();
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
            sleep(5000);
            if($x("//tr[1]//td[8]").exists()) {
                String Status = $x("//tr[1]//td[8]").getText();
                assertText(Status, "In Progress");
            }else{
                logTestStep("There is no record for this status ");
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
                sleep(2000);
                $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Reset All')]").click();
                sleep(2000);
                logTestStep("Checking for the status - Resolved");
                $x("(.//*[normalize-space(text()) and normalize-space(.)='In Progress'])[1]/following::span[2]").click();
                sleep(2000);
                $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
                sleep(5000);
                if($x("//tr[1]//td[8]").exists()) {
                    String Status = $x("//tr[1]//td[8]").getText();
                    assertText(Status, "Resolved");
                }else{
                    logTestStep("There is no record for this status ");
                    $(ProjectsRepo.Filter).click();
                    sleep(2000);
                    $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
                    sleep(2000);
                    $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Reset All')]").click();
                    sleep(2000);
                    logTestStep("Checking for the status - Closed");
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Resolved'])[1]/following::div[2]").click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
                    sleep(5000);
                    if($x("//tr[1]//td[8]").exists()) {
                        String Status = $x("//tr[1]//td[8]").getText();
                        assertText(Status, "Closed");
                    }else{
                        Assert.fail("No record found");
                    }


                }


            }


        }

      objLoginOut.logout();
    }

}
