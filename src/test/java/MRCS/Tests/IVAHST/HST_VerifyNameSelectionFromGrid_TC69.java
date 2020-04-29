package MRCS.Tests.IVAHST;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HST_VerifyNameSelectionFromGrid_TC69 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify provider name selection from grid", groups = {"IVA HST"})
    public void HST_VerifyNameSelectionFromGrid_TC69() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ENCasYes();
        F2FasYes();
        $(ProviderLookUpRepo.BackwardButton).click();
        sleep(2000);
        Common.ClickElement(ProviderLookUpRepo.ProviderDropdown,"Provider");
        sleep(2000);
        int ProviderNameSizeBeforeSelect=$$(ProviderLookUpRepo.GetDropdownSize).size();
        logInfoStepColored(COLOR.BLUE,"Provider Name count before selecting new Provider:"+ProviderNameSizeBeforeSelect);
        ProviderLookUp.SearchForAdminKeyword();
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton,"Select Button");
        sleep(2000);
        $x("//div[contains(text(),'Service End Date')]").click();
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
