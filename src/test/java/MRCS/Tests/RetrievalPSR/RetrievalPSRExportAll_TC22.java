package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRExportAll_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather address list get exported or not", groups = {"Retrieval PSR"})
    public void RetrievalPSRExportAll_TC22() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        //objWait.implicitwait();
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        sleep(10000);
        $x("//span[contains(text(),'Export All')]").waitUntil(visible, DEFAULT_WAIT).click();
        sleep(20000);
        Common.DownloadCsv();
        sleep(5000);
        objLoginOut.logout();
    }
}