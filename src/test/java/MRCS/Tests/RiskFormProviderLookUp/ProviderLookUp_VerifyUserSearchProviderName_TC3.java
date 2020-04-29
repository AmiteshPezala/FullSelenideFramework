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
import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProviderLookUp_VerifyUserSearchProviderName_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify that user can search provider names", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLookUp_VerifyUserSearchProviderName() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProviderLookUp.NavigateToMagnifyingIcon();
        sleep(2000);
        Common.ClickElement(ProviderLookUpRepo.MagnifyingIconInEncounter,"Magnifying Icon");
        $(ProviderLookUpRepo.SearchForProviderText).sendKeys("Admin");
        Common.ClickElement(ProviderLookUpRepo.SearchButton,"Search Button");
        sleep(2000);
        if($x("(//tr[2]//td[1])[2]").isDisplayed())
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
