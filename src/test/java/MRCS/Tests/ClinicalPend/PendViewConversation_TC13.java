package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class PendViewConversation_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    ClinicalPend objPend = new ClinicalPend();

    @Test(description = "Whether all conversations are available or not", groups = {"Clinical Pend"})
    public void PendViewConversation_TC13() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        objPend.PendLink();
        ClinicalPend.navigateToClinicalPend();
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $(ClinicalPendRepo.pendStatus).click();
        logTestStep("Selecting pend status option");
        sleep(2000);
        logTestStep("Selecting all status except closed ");
        $(ClinicalPendRepo.newStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.inProgressStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.resolved).click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Closed'])[1]/following::span[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Request to Resolve'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        $x("//tr[1]//td[2]").click();
        sleep(5000);
        $x("//span[contains(text(),'VIEW CONVERSATION')]").click();
        logTestStep("Clicked on view conversation button");
        sleep(2000);
        if($x("//span[@class='timestamp']").exists())
        {
            logTestStep("All conversations are displayed with times stamp");
        }else{
            Assert.fail("Conversations are not available");
        }
        objLoginOut.logout();
    }
}
