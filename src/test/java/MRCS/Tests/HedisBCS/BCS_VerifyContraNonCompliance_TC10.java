package MRCS.Tests.HedisBCS;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisBCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class BCS_VerifyContraNonCompliance_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that non compliance contra shows only when Contra date is in 2018 and page number is available", groups = {"Hedis BCS"} )
    public void BCS_VerifyExclusionNonCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ClickElement($(HedisBCSRepo.DeleteForContra), "Clicking to clear data");
        sleep(2000);
        Common.ClickElement(HedisBCSRepo.Contra,"");
        sleep(1000);
        Common.ClickElement(HedisBCSRepo.FirstElementInDropdown,"");
        $(HedisBCSRepo.ContraDate).setValue("12/31/2018");
        sleep(1000);
        $(HedisBCSRepo.ContraPageNumber).setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Clicking to save data");
        sleep(2000);
        $(HedisBCSRepo.NonCompliance).shouldHave(text("NC/C"));
        logTestStepPass("Contra non compliance shows only when exclusion date is in 2018 and page number is available");
        sleep(2000);
        ClickElement($(HedisBCSRepo.DeleteForContra), "Clicking to clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
