package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRDetailsEditAddress_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify details page is refreshed with updated values", groups = {"Retrieval PSR"})
    public void RetrievalPSREditAddress() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        logTestStep("Clicking to edit address");
        objRetrieval.RetrievalAID();
        logTestStep("Comparing details successfully edited");
        String Expected="Address Details successfully edited.";
        String Actual=$x("//div[contains(text(),'Address Details successfully edited.')]").getText();
        assertText(Actual,Expected);
        sleep(5000);
        objLoginOut.logout();
    }
}
