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

public class RetrievalPSRChaseView_TC45 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify that by default chase view is available on address detail page", groups = {"Retrieval PSR"})
    public void RetrievalPSRChaseView() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        waitForPageLoadToComplete();
        $(RetrievalRepo.AIDFirstRow).waitUntil(Condition.appear,DEFAULT_WAIT).click();
        //$$x("//*[@class='description']").filter(Condition.visible).get(5).click();
        if($x("//tr[1]//td[2]").waitUntil(Condition.appear,DEFAULT_WAIT).isDisplayed())
        {
            logTestStepPass("By default chase view is available on address detail page");
        }
        else
        {
            logTestStepFail("By default chase view is available on address detail page");
            Assert.fail("By default chase view is available on address detail page");
        }
        objLoginOut.logout();
    }
}
