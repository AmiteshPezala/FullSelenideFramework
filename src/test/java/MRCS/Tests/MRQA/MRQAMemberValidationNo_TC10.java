package MRCS.Tests.MRQA;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.Retry;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MRQAMemberValidationNo_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(retryAnalyzer = Retry.class,description = "Verify MRQA Member validation as no",groups = {"MRQA"})
    public void MRQADetailsUnassigned() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.AssignToUser();
        MRQA.NavigateToDocumentPage();
        MRQA.MemberValidationAsNo();
        sleep(5000);
        /*String ActualPage = "RETRIEVAL";
        String ExpectedPage = $x("//div[contains(text(),'RETRIEVAL')]").getText();
        assertText(ExpectedPage, ActualPage);
        sleep(2000);*/
        objLoginOut.logout();
    }
}
