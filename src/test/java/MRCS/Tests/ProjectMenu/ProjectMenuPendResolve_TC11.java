package MRCS.Tests.ProjectMenu;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Modules.ProjectMenu;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectMenuPendResolve_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Pend resolve functionality", groups = {"Project Menu"})
    public void ProjectMenuPendResolve_TC11() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        ProjectMenu.NavigateToPend();
        ProjectMenu.FilterPend();
        if (($x("//tr[1]//td[2]")).exists()) {
            String FirstPendId = $x("//tr[1]//td[2]").getText();
            Log.info("FirstPendId = " + FirstPendId);
            sleep(2000);
            String FirstChaseId = $x("//tr[1]//td[9]").getText();
            Log.info("FirstChaseId = " + FirstChaseId);
            sleep(2000);
            logTestStep("Getting current pend code status");
            String FirstPendCodeStatus = $x("//tr[1]//td[8]").getText();
            Log.info("FirstPendCodeStatus = " + FirstPendCodeStatus);
            sleep(2000);
            logTestStep("Changing the pend code status through bulk update option.");
            sleep(2000);
            $x("//span[contains(text(),'Bulk Actions')]").click();
            sleep(2000);
            $x("//span[contains(text(),'Bulk Changes')]").click();
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Select a Type of Bulk Update'])[1]/following::div[1]").click();
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Chases'])[1]/following::span[1]").click();
            sleep(2000);
            $x("(.//*[normalize-space(text()) and normalize-space(.)='Choose a Bulk Action'])[1]/following::label[1]").click();
            sleep(2000);
            $x("//span[contains(text(),'Close')]").click();
            sleep(2000);
            $x("//textarea[@id='selectedChaseIds']").setValue(FirstPendId);
            sleep(2000);
            $x("//span[contains(text(),'CONTINUE')]").click();
            sleep(2000);
            $x("//textarea[@id='chasesNotes']").setValue("Testing purpose");
            sleep(2000);
            $x("//span[contains(text(),'CONTINUE TO VALIDATION')]").click();
            sleep(2000);
            $x("//span[contains(text(),'FINISH BULK UPDATE')]").click();
            sleep(2000);
            String message = $x("//div[@class='ui-toast-detail']").getText();
            assertText(message, "You have successfully completed bulk update.");
            logTestStep("Checking weather the pend status changed or not.");
            sleep(2000);
                $(RetrievalPendRepo.Pend).click();
                sleep(2000);
                $x("//a[@class='headerStatsItem ng-star-inserted']").click();
                sleep(2000);
                $(ProjectsRepo.Filter).click();
                logTestStep("Clicked on filter option");
                sleep(2000);
                logTestStep("Checking the changed status by chase id ");
                $x("//span[contains(text(),'Chase Id')]").click();
                sleep(2000);
                $x("//input[@id='ChaseId']").setValue(FirstChaseId);
                sleep(2000);
                $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Update')]").click();
                sleep(10000);
                $(CommonRepo.BackwardButton).click();
                sleep(2000);
                String NewPendCodeStatus1 = $x("//tr[1]//td[8]").getText();
                Log.info("NewPendCodeStatus1 = " + NewPendCodeStatus1);
                sleep(2000);
                if (FirstPendCodeStatus.equals(NewPendCodeStatus1) ) {
                    logTestStepFail("Pend code status not changed ");
                }else{
                    logTestStepPass("Pend code status changed successfully to " + NewPendCodeStatus1);
                }

        }else{
            logTestStepFail("No records available");
        }
        objLoginOut.logout();
    }
}
