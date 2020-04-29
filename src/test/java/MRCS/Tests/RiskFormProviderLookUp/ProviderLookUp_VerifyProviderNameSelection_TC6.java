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
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ProviderLookUp_VerifyProviderNameSelection_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify provider name selection from grid", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLookUp_VerifyProviderNameSelection() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProviderLookUp.NavigateToMagnifyingIcon();
        Common.ClickElement(ProviderLookUpRepo.ProviderDropdown,"Provider");
        sleep(2000);
        int ProviderNameSizeBeforeSelect=$$(ProviderLookUpRepo.GetDropdownSize).size();
        logInfoStepColored(COLOR.BLUE,"Provider Name count before selecting new Provider:"+ProviderNameSizeBeforeSelect);
        ProviderLookUp.SearchForAdminKeyword();
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton,"Select Button");
        sleep(4000);
        $x("//div[contains(text(),'Is the provider signature acceptable?')]").click();
        sleep(5000);
        Common.ClickElement(ProviderLookUpRepo.ProviderDropdown,"Provider");
        sleep(2000);
        int ProviderNameSizeAfterSelect=$$(ProviderLookUpRepo.GetDropdownSize).size();
        logInfoStepColored(COLOR.BLUE,"Provider Name count After select new Provider:"+ProviderNameSizeAfterSelect);
        if(ProviderNameSizeAfterSelect>ProviderNameSizeBeforeSelect)
        {
        logTestStepPass("Provider name added");
        }
        else
        {
        logTestStepFail("Provider name not added");
            Assert.fail("Provider name not added");
        }
        objLoginOut.logout();
    }
}
