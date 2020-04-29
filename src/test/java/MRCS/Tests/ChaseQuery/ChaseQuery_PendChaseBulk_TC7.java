package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class ChaseQuery_PendChaseBulk_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify bulk chase is pended or not", groups = {"Chase Query"})
    public void ChaseQuery_PendChaseBulk_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Verifying ChaseQuery filter Status ");
        objProject.ProjectsLink();
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Status')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Pended')]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        logTestStep("Click on update button");
        Common.waitForPageLoadToComplete();
        sleep(5000);
        logTestStep("Selecting multiple chases.");
        $x("//tr[1]//td[1]").click();
        Selenide.sleep(2000);
        $x("//tr[2]//td[1]").click();
        Selenide.sleep(2000);
        Common.ClickElement(RetrievalFTRepo.PendChase,"Pend Chases");
        logTestStep("Clicked on pend chase option.");
        Thread.sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
        Thread.sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[@class='ng-star-inserted'][contains(text(),'New')]").click();
        logTestStep("Selecting status as new.");
        Thread.sleep(2000);
        Common.ClickElement(RetrievalFTRepo.TextArea,"Text area");
        logTestStep("Writing notes for pend chase.");
        Selenide.sleep(2000);
        $(RetrievalFTRepo.TextArea).sendKeys("For testing purpose");
        Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
        logTestStep("Clicked on save button.");
        Selenide.sleep(1000);
        String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(SuccessfulMessage, "Pend saved successfully");
        objLoginOut.logout();
    }
}
