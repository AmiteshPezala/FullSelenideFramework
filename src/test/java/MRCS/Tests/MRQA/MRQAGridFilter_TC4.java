package MRCS.Tests.MRQA;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.MRQARepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class MRQAGridFilter_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify grid filters", groups = {"MRQA"})
    public void VerifyGridFilter() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        MRQA.NavigateToDocQA();
        String RecordBeforeSorting=$(MRQARepo.MRQAChaseId).getText();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE,"First Member Id:"+ RecordBeforeSorting);
        ClickElement(ProjectsRepo.Filter,"Filter");
        //ClickElement(MemberRepo.MemberIdFilter,"Member Id Filter");
        $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
        sleep(2000);
        $x("//input[@id='ChaseIdAndClientChaseKey']").sendKeys(RecordBeforeSorting);
        ClickElement(ProjectsRepo.Update,"update");
        waitForPageLoadToComplete();
        sleep(5000);
        int StatusCount = $$x("//tr//td[2]").size();
        for(int i=0;i<=StatusCount-1;i++)
        {
            String Status=$x("//tr[\" + (i + 1) + \"]//td[2]").getText();
            assertText(Status,RecordBeforeSorting);
            logTestStepPass("Grid data filters as per the filter option selected");
        }
        objLoginOut.logout();
    }
}
