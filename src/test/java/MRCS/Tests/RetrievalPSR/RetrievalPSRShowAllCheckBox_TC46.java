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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalPSRShowAllCheckBox_TC46 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify  show all check box", groups = {"Retrieval PSR"})
    public void RetrievalPSRShowAllCheckBox() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        waitForPageLoadToComplete();
        $(RetrievalRepo.AIDFirstRow).waitUntil(Condition.appear,DEFAULT_WAIT).click();
        //$$x("//*[@class='description']").filter(Condition.visible).get(5).click();
        if($x("(//*[text()='Members']//following::*[@class='ui-chkbox ui-widget'])[1]").waitUntil(Condition.appear,DEFAULT_WAIT).isDisplayed())
        {
            logTestStepPass("chase grid is having a \"show all check box\"");
        }
        else
        {
            logTestStepFail("chase grid is not having a \"show all check box\"");
            Assert.fail("chase grid is not having a \"show all check box\"");
        }
        objLoginOut.logout();
    }
}
