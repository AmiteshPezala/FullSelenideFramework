package MRCS.Tests.RetrievalFT;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class RetrievalFTDetailsEditAddress_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify FT Details - Edit Address", groups = {"Retrieval FT"})
    public void RetrievalFTEditAddress() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        logTestStep("Clicking to edit address");
        //objRetrieval.RetrievalAID();
        RetrievalFT.EditAID();
        objLoginOut.logout();
    }
}
