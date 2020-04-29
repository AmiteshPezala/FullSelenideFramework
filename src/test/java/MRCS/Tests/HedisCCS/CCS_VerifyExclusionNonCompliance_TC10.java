package MRCS.Tests.HedisCCS;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Locators.HedisRepo.HedisCCSRepo;
import MRCS.Modules.Hedis.HedisCCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CCS_VerifyExclusionNonCompliance_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that exclusion non compliance shows only when exclusion date is in 2018 and page number is available", groups = {"Hedis CCS"} )
    public void CCS_VerifyExclusionNonCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCCS.NavigateToCCS();
        objRisk.membervalidation();
        HedisCCS.ClearData();
        String CurrentDate=Common.GetCurrentTimeStamp();
        Common.ClickElement(HedisCCSRepo.ExclusionDropdown,"");
        Common.ClickElement(HedisBCSRepo.FirstElementInDropdown,"");
        ClearAndSendKeys($(HedisCCSRepo.ExclusionDate),CurrentDate,"Filling exclusion date");
        ClearAndSendKeys($(HedisCCSRepo.ExclusionPageNumber),"1","Filling exclusion page number");
        ClickElement(CommonRepo.ClickToSave,"Clicking to save data");
        sleep(2000);
        $x("//span[contains(text(),'NC/E')]").shouldHave(text("NC/E"));
        logTestStepPass("Exclusion non compliance shows only when exclusion date is in 2019 and page number is available");
        sleep(2000);
        HedisCCS.DeleteData();
        sleep(2000);
        objLoginOut.logout();
    }
}
