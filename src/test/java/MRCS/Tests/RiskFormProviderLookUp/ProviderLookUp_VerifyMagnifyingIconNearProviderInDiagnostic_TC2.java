package MRCS.Tests.RiskFormProviderLookUp;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProviderLookUp_VerifyMagnifyingIconNearProviderInDiagnostic_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify that a magnifying icon is available near provider field in diagnostic section", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLookUp_MagnifyingIconNearProviderInDiagnostic() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objRisk.getUser();
        objRisk.membervalidation();
        CommonRisk.ENCasYes();
        CommonRisk.F2FasYes();
        if($(ProviderLookUpRepo.MagnifyingIconInDiagnostic).isDisplayed())
        {
            logTestStepPass("A magnifying icon is available near provider field in diagnostic section");
        }
        else
        {
            logTestStepFail("A magnifying icon is not available near provider field in diagnostic section");
            Assert.fail("A magnifying icon is not available near provider field in diagnostic section");
        }
        objLoginOut.logout();
    }
}
