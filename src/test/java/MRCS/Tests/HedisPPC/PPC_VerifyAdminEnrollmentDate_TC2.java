package MRCS.Tests.HedisPPC;

import MRCS.Locators.HedisRepo.HedisPPCRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class PPC_VerifyAdminEnrollmentDate_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify admin enrollment date is available", groups = {"Hedis PPC"} )
    public void PPC_VerifyAdminEnrollmentDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(2000);
        if($(HedisPPCRepo.DateOfEnrollmentDate1).isDisplayed())
        {
           logTestStepPass("Admin enrollment date is available");
        }else
        {
            logTestStepFail("Admin enrollment date is not available");
            Assert.fail("Admin enrollment date is not available");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
