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

public class RetrievalPSRMemberViewTab_TC44 extends TestBase {
        LoginOut objLoginOut = new LoginOut();

        @Test(description = "Verify that PSR address detail is having a member view", groups = {"Retrieval PSR"})
        public void RetrievalPSRMemberViewTab() throws Exception {
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
            logTestStep("Log in to application");
            Common.PopUp();
            RetrievalPSR.NavigateToPSR();
            waitForPageLoadToComplete();
            $(RetrievalRepo.AIDFirstRow).waitUntil(Condition.appear,DEFAULT_WAIT).click();
            $$x("//*[text()='Members']").filter(Condition.visible).get(0).click();
            if($x("//tr[1]//td[2]").waitUntil(Condition.appear,DEFAULT_WAIT).isDisplayed())
            {
             logTestStepPass("PSR address detail is having a member view");
            }
            else
            {
              logTestStepFail("PSR address detail is not having a member view");
              Assert.fail("PSR address detail is not having a member view");
            }
            objLoginOut.logout();
        }
}
