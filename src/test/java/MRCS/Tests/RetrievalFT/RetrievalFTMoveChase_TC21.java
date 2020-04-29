package MRCS.Tests.RetrievalFT;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;
public class RetrievalFTMoveChase_TC21 extends TestBase {
        LoginOut objLoginOut = new LoginOut();
        WaitTool objWait = new WaitTool();
        Retrieval objRetrieval = new Retrieval();

        @Test(description = "Verify weather chase is assigned from one address to other", groups = {"Retrieval FT"})
        public void RetrievalFTMoveChase() throws Exception {
            logTestStep("Log in to application");
            objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
            Common.PopUp();
            //objWait.implicitwait();
            RetrievalFT.NavigateToFT();
            ClickElement(RetrievalFTRepo.FirstFTAID,"Selecting first chase");
            waitForPageLoadToComplete();
            sleep(5000);
            Retrieval.MoveChase();
            objLoginOut.logout();
        }
}


