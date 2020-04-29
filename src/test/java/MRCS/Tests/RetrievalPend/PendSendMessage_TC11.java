package MRCS.Tests.RetrievalPend;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class PendSendMessage_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Verify weather message sent or not", groups = {"Retrieval Pend"})
    public void PendSendMessage_TC11() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        objPend.PendLink();
        sleep(2000);
        $x("//a[@class='headerStatsItem ng-star-inserted']").click();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
        logTestStep("Selecting pend status option");
        sleep(2000);
        logTestStep("Selecting all status except closed ");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[4]/following::div[5]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::div[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='In Progress'])[1]/following::li[1]").click();
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
        assertText(Message,"For testing purpose");
        sleep(2000);
        objLoginOut.logout();
    }
}
