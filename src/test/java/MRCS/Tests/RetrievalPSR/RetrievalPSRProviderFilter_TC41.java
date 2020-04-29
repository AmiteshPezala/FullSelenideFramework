package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalPSRProviderFilter_TC41 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify filter by Provider Name", groups = {"Retrieval PSR"})
    public void RetrievalPSRProviderFilter() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        String RecordBeforeSorting=$x("//tr[1]//td[4]").getText();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE,"Provider Name:"+ RecordBeforeSorting);
        ClickElement(ProjectsRepo.Filter,"Filter");
        //ClickElement(MemberRepo.MemberIdFilter,"Member Id Filter");
        $x("//span[contains(text(),'Provider Name')]").click();
        sleep(2000);
        $x("//input[@id='ProviderName']").sendKeys(RecordBeforeSorting);
        ClickElement(ProjectsRepo.Update,"update");
        waitForPageLoadToComplete();
        sleep(5000);
        int StatusCount = $$x("//tr//td[2]").size();
        for(int i=0;i<=StatusCount-1;i++)
        {
            String Status=$x("//tr[\" + (i + 1) + \"]//td[4]").getText();
            assertText(Status,RecordBeforeSorting);
            logTestStepPass("Grid data filters as per the filter option selected");
        }
        objLoginOut.logout();
    }
}
