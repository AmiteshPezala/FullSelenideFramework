package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
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
    ClinicalPend objPend = new ClinicalPend();
    Common objCommon = new Common();

    @Test(description = "Verify the filter functionality", groups = {"Clinical Pend"})
    public void PendGridFilter() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        ClinicalPend.navigateToClinicalPend();
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $(ClinicalPendRepo.pendStatus).click();
        sleep(2000);
        logTestStep("Checking filter with the pend code status option");
        $(ClinicalPendRepo.newStatus).click();
        sleep(2000);
        logTestStep("Checking for the status - New");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
        sleep(5000);
        if($x("//tr[1]//td[9]").exists()){
            String Status = $x("//tr[1]//td[9]").getText();
            assertText(Status,"New");
        }else {
            logTestStep("There is no record for this status ");
            $(ProjectsRepo.Filter).click();
            sleep(2000);
            $(ClinicalPendRepo.pendStatus).click();
            sleep(2000);
            $(ClinicalPendRepo.resetAll).click();
            sleep(2000);
            logTestStep("Checking for the status - In Progress");
            $(ClinicalPendRepo.inProgressStatus).click();
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
            sleep(5000);
            if($x("//tr[1]//td[9]").exists()) {
                String Status = $x("//tr[1]//td[9]").getText();
                assertText(Status, "In Progress");
            }else{
                logTestStep("There is no record for this status ");
                $(ProjectsRepo.Filter).click();
                sleep(2000);
                $(ClinicalPendRepo.pendStatus).click();
                sleep(2000);
                $(ClinicalPendRepo.resetAll).click();
                sleep(2000);
                logTestStep("Checking for the status - Resolved");
                $(ClinicalPendRepo.resolved).click();
                sleep(2000);
                $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
                sleep(5000);
                if($x("//tr[1]//td[9]").exists()) {
                    String Status = $x("//tr[1]//td[9]").getText();
                    assertText(Status, "Resolved");
                }else{
                    logTestStep("There is no record for this status ");
                    $(ProjectsRepo.Filter).click();
                    sleep(2000);
                    $(ClinicalPendRepo.pendStatus).click();
                    sleep(2000);
                    $(ClinicalPendRepo.resetAll).click();
                    sleep(2000);
                    logTestStep("Checking for the status - Closed");
                    $(ClinicalPendRepo.closed).click();
                    sleep(2000);
                    $x("(.//*[normalize-space(text()) and normalize-space(.)='Reset All'])[1]/following::span[1]").click();
                    sleep(5000);
                    if($x("//tr[1]//td[9]").exists()) {
                        String Status = $x("//tr[1]//td[9]").getText();
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
