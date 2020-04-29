package MRCS.Tests.RiskFormProviderLookUp;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProviderLoopUp_VerifyEncAsNo_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify marking Enc=No shows a validation message", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLoopUp_VerifyEncAsNo() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProviderLookUp.NavigateToMagnifyingIcon();
        ProviderLookUp.SelectEncAsNoInDropdown();
        if($(ProviderLookUpRepo.YesButton).isDisplayed())
        {
            logTestStepPass("A validation message is displayed");
            Common.ClickElement(ProviderLookUpRepo.YesButton,"Yes Button");
            Common.ClickElement(ProviderLookUpRepo.SaveContainer,"Save Container");
            sleep(5000);
        }
        else
        {
            logTestStepFail("A validation message is not displayed");
            Assert.fail("A validation message is not displayed");
        }
        String getFieldValue=$(ProviderLookUpRepo.FirstTextField).getValue();
        if(getFieldValue!="10")
        {
            logTestStepPass("Data get removed");
        }
        else
        {
            logTestStepFail("Data not removed");
            Assert.fail("Data not removed");
        }
        objLoginOut.logout();
    }
}
