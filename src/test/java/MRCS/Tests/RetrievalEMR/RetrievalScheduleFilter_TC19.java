package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalScheduleFilter_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify Schedule filter.", groups = {"Retrieval EMR"})
    public void RetrievalScheduleFilter() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalEMR.NavigateToEMR();
        $(RetrievalEMRRepo.ScheduleTab).click();
        logTestStep("User on Schedule tab");
        sleep(5000);
        String RecordBeforeSorting=$x("//tr[1]//td[6]").getText();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE,"UserName:"+ RecordBeforeSorting);
        $$(ProjectsRepo.Filter).filter(Condition.enabled).last().click();
        //ClickElement(MemberRepo.MemberIdFilter,"Member Id Filter");
        $(RetrievalEMRRepo.AssignTo).sendKeys(RecordBeforeSorting);
        sleep(1000);
        $(RetrievalEMRRepo.AssignTo).sendKeys(Keys.ARROW_DOWN);
        sleep(1000);
        $(RetrievalEMRRepo.AssignTo).sendKeys(Keys.ENTER);
        sleep(2000);
        ClickElement(ProjectsRepo.Update,"update");
        waitForPageLoadToComplete();
        sleep(5000);
        int StatusCount = $$x("//tr//td[2]").size();
        for(int i=0;i<=StatusCount-1;i++)
        {
            String Status=$x("//tr[\" + (i + 1) + \"]//td[6]").getText();
            assertText(Status,RecordBeforeSorting);
            logTestStepPass("Grid data filters as per the filter option selected");
        }
        objLoginOut.logout();
    }
}
