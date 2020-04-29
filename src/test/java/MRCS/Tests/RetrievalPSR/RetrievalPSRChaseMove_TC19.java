package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class RetrievalPSRChaseMove_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather chase is assigned from one address to other", groups = {"Retrieval PSR"})
    public void RetrievalPSRChaseMove_TC19() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        logTestStep("Clicked on address id");
        ClickElement(RetrievalRepo.AIDFirstRow,"Selecting first chase");
        waitForPageLoadToComplete();
        sleep(5000);
        $(CommonRepo.BackwardButton).click();
        Retrieval.MoveChase();
        objLoginOut.logout();
    }
}
