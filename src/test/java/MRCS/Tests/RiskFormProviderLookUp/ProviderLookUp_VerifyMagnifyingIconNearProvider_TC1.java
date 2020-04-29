package MRCS.Tests.RiskFormProviderLookUp;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class ProviderLookUp_VerifyMagnifyingIconNearProvider_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();

    @Test(description = "Verify that a magnifying icon is available near provider field in encounter details section", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLookUp_VerifyMagnifyingIconNearProvide() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objRisk.getUser();
        objRisk.membervalidation();
        CommonRisk.ENCasYes();
        CommonRisk.F2FasYes();
        if($(ProviderLookUpRepo.MagnifyingIconInEncounter).isDisplayed())
        {
            logTestStepPass("A magnifying icon is available near provider field in encounter details section");
        }
        else
        {
            logTestStepFail("A magnifying icon is not available near provider field in encounter details section");
            Assert.fail("A magnifying icon is not available near provider field in encounter details section");
        }
        objLoginOut.logout();
    }
}
