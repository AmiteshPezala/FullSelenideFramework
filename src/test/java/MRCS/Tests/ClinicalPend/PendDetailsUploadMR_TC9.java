package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PendDetailsUploadMR_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ClinicalPend objPend = new ClinicalPend();

    @Test(description = "Verify Pend Details Upload MR", groups = {"Clinical Pend"})
    public void PendDetailsUploadMR() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        objPend.PendLink();
        ClinicalPend.navigateToClinicalPend();
        ClinicalPend.navigateToFirstChase();
        //RetrievalPend.NavigateToPendDetails();
        Common.UploadDocument();
        Common.ClickElement(RetrievalPendRepo.SubmitButton,"Submit button");
        sleep(2000);
        if($x("//span[contains(text(),'OK')]").isDisplayed()){
            $x("//span[contains(text(),'OK')]").click();
            sleep(2000);

        }else {
            Common.waitForPageLoadToComplete();
            if ($(RetrievalPendRepo.ToasterMessage).waitUntil(visible, DEFAULT_WAIT).isDisplayed()) {
                logTestStepPass("MR get uploaded and Pend gets resolved.");
            } else {
                logTestStepFail("MR not uploaded");
                Assert.fail("MR not uploaded");
            }
        }
        objLoginOut.logout();
    }
}
