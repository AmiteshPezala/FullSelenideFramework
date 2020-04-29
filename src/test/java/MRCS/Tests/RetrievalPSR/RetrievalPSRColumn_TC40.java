package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalPSRColumn_TC40 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify PSR Column", groups = {"Retrieval PSR"})
    public void RetrievalPSRColumn() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        waitForPageLoadToComplete();
        sleep(5000);
        int StatusCount = $$x("//tr//td[18]").size();
        for(int i=0;i<=StatusCount-1;i++)
        {
            String Status=$x("//tr[\" + (i + 1) + \"]//td[18]").getText();
            assertText(Status,"PSR");
            logTestStepPass("Grid data filters as per the filter option selected");
        }
        objLoginOut.logout();
    }
}
