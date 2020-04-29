package MRCS.Tests.RetrievalPend;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class PendDetailsAdditionalDocRequest_TC21 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Verify RetrievalPend Details Additional Doc Request", groups = {"Retrieval Pend"})
    public void PendDetailsAdditionalDocRequest() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPend.RAD();
        //Common.ClickElement(RetrievalPendRepo.RequestButton,"Request Button");
        sleep(2000);
        objLoginOut.logout();
    }
}
