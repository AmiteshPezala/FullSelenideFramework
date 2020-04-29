package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRGridData_TC48 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify the grid data available in member view tab", groups = {"Retrieval PSR"})
    public void RetrievalPSRGridData() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        waitForPageLoadToComplete();
        $(RetrievalRepo.AIDFirstRow).waitUntil(Condition.appear,DEFAULT_WAIT).click();
        $$x("//*[text()='Members']").filter(Condition.visible).get(0).click();
        if($x("//tr[1]//td[2]").waitUntil(Condition.appear,DEFAULT_WAIT).isDisplayed())
        {
            logTestStepPass("Grid data available in member view tab");
        }
        else
        {
            logTestStepFail("Grid data is not available in member view tab");
            Assert.fail("Grid data is not available in member view tab");
        }
        objLoginOut.logout();
    }
}
