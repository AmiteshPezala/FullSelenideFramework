package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendLatestComment_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    ClinicalPend objPend = new ClinicalPend();

    @Test(description = "Verify whether sent message is added in the latest comment or not", groups = {"Clinical Pend"})
    public void PendLatestComment_TC12() throws Exception {
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
        sleep(2000);
        $x("//tr[1]//td[2]").click();
        sleep(2000);
        $x("//div[contains(text(),'Comments')]").click();
        logTestStep("Clicked on comments tab");
        sleep(2000);
        $x("//textarea[@placeholder='Type here to reply.']").sendKeys("For testing purpose");
        logTestStep("Enter message to send");
        sleep(2000);
        $x("//span[contains(text(),'SEND MESSAGE')]").click();
        logTestStep("Clicked on send message option");
        sleep(3000);
        String Message = $x("//div[@class='othercomment-body']").getText();
        assertText(Message, "For testing purpose");
        logTestStep("Message added in the last comment tab");
        sleep(2000);
        objLoginOut.logout();
    }
}
