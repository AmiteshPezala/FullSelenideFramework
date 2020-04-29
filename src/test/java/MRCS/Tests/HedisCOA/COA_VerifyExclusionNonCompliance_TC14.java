package MRCS.Tests.HedisCOA;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisCOA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class COA_VerifyExclusionNonCompliance_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that exclusion non compliance shows only when exclusion date is in 2018 and page number is available", groups = {"Hedis COA"} )
    public void COA_VerifyExclusionNonCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        String currentDate=Common.GetCurrentTimeStamp();
        HedisCOA.ClearData();
        Common.ClickElement(HedisBCSRepo.ExclusionDropdown,"");
        sleep(1000);
        Common.ClickElement(HedisBCSRepo.FirstElementInDropdown,"");
        $(HedisBCSRepo.ExclusionDate).setValue(currentDate);
        sleep(1000);
        $(HedisBCSRepo.ExclusionPageNumber).setValue("1");
        sleep(2000);
        ClickElement(CommonRepo.ClickToSave,"Clicking to save data");
        sleep(2000);
        $x("//tr[1]//td[2]").shouldHave(text("NC"));
        logTestStepPass("Exclusion non compliance shows only when exclusion date is in 2019 and page number is available");
        sleep(2000);
        ClickElement(HedisBCSRepo.DeleteForExclusion,"Clicking to clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
