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

public class PPC_VerifyAdminDOD_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify admin DOD is available", groups = {"Hedis PPC"} )
    public void PPC_VerifyAdminDOD() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep_ColorGreen("Verifying Admin DOD in PPC Hedis");
        Common.HighlightElement(HedisPPCRepo.DateOfEnrollmentDate2);
        sleep(2000);
        if($(HedisPPCRepo.DateOfEnrollmentDate2).isDisplayed())
        {
            logTestStepPass("Admin DOD is available");
        }else
        {
            logTestStepFail("Admin DOD is not available");
            Assert.fail("Admin DOD is not available");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
