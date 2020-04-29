package MRCS.Tests.IVAHST;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyUserCanSearchProviderName_TC66 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that user can search provider names", groups = {"IVA HST"})
    public void HST_VerifyUserCanSearchProviderName_TC66() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ENCasYes();
        F2FasYes();
        Common.ClickElement(ProviderLookUpRepo.BackwardButton,"Backward button");
        Common.ClickElement(ProviderLookUpRepo.MagnifyingIconInEncounter,"Magnifying Icon");
        $(ProviderLookUpRepo.SearchForProviderText).sendKeys("Admin");
        sleep(2000);
        Common.ClickElement(ProviderLookUpRepo.SearchButton,"Search Button");
        sleep(5000);
        if($x("//tr[2]//td[1]").isDisplayed())
        {
            logTestStepPass("User can search provider names");
        }
        else
        {
            logTestStepFail("User can not search provider names");
            Assert.fail("User can not search provider names");
        }
        Common.ClickElement(ProviderLookUpRepo.CrossIcon,"Cancel");
        objLoginOut.logout();
    }
}
