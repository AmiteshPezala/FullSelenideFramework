package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalPSRTimelineTab_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify whether recent events are added in timeline tab or not", groups = {"Retrieval PSR"})
    public void RetrievalPSRTimelineTab_TC10() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        //objWait.implicitwait();
        RetrievalPSR.NavigateToPSR();
        logTestStep("Adding new comment to check whether it is added in timeline tab or not");
        $x("//tr[1]//td[2]").click();
        Retrieval.TimeLine();
        objLoginOut.logout();
    }
}
