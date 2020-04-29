package MRCS.Tests.RetrievalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class PendViewConversation_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Weather all conversations are available or not", groups = {"Retrieval Pend"})
    public void PendViewConversation_TC13() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        objPend.PendLink();
        sleep(2000);
        $(RetrievalPendRepo.TotalPend).click();
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
