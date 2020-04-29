package MRCS.Tests.RetrievalPend;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class PendDisplayDocRequest_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();
    public Actions act;
    @Test(description = "Verify Doc request is displaying in pend info section", groups = {"Retrieval Pend"})
    public void PendDetailsAdditionalDocRequest() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        RetrievalPend.RAD();
        sleep(2000);
        Common.ClickElement(RetrievalPendRepo.PendInfo,"Pend Info");
        sleep(2000);
        if($x("//span[@class='bold']").isDisplayed())
        {
            logTestStepPass("Doc request is displaying in pend info section");
        }
        else
        {
            logTestStepFail("Doc request is not displaying in pend info section");
            Assert.fail("Doc request is not displaying in pend info section");
        }
        objLoginOut.logout();
    }
}
