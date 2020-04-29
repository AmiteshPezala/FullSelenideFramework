package MRCS.Tests.RetrievalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class PendGridExport_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();
    Common objCommon = new Common();

    @Test(description = "Verify the exportall functionality", groups = {"Retrieval Pend"})
    public void PendGridExport_TC5() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        sleep(2000);
        $(RetrievalPendRepo.TotalPend).click();
        sleep(10000);
        $x("//span[contains(text(),'Export All')]").click();
        logTestStep("Clicked on Export all button");
        sleep(20000);
        Common.DownloadCsv();
        objLoginOut.logout();
    }
}
