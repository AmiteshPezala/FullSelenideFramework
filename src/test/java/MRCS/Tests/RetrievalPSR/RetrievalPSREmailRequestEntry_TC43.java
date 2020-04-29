package MRCS.Tests.RetrievalPSR;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;

public class RetrievalPSREmailRequestEntry_TC43 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify email  request entry is available in contact history grid", groups = {"Retrieval PSR"})
    public void RetrievalPSREmailRequestEntry() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        RetrievalPSR.SendEmail();
        $(".description",2).click();
        String CurrentDate=Common.GetCurrentDate();
        System.out.println(CurrentDate);
        String ContactDate=Common.getElementText(By.xpath("//tr[1]//td[2]"),5);
        Common.assertText(CurrentDate,ContactDate);
        objLoginOut.logout();
    }
}
