package MRCS.Tests.HedisCCS;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Locators.HedisRepo.HedisCCSRepo;
import MRCS.Modules.Hedis.HedisCCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class CCS_VerifyContraNonCompliance_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that contra- non compliance shows only when contra date is in 2018 and page number is available", groups = {"Hedis CCS"} )
    public void CCS_VerifyContraNonCompliance() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCCS.NavigateToCCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        HedisCCS.ClearData();
//        String CurrentDate=Common.GetCurrentTimeStamp();
        Common.ClickElement(HedisCCSRepo.Contra,"");
        Common.ClickElement(HedisBCSRepo.FirstElementInDropdown,"");
        ClearAndSendKeys($(HedisCCSRepo.ContraDate),"12/12/2019","Filling exclusion date");
        ClearAndSendKeys($(HedisCCSRepo.ContraPageNumber),"1","Filling exclusion page number");
        ClickElement(CommonRepo.ClickToSave,"Clicking to save data");
        sleep(2000);
        String chaseCompliance=Common.getElementText(By.xpath("//tr[1]//td[2]"),5);
        if(chaseCompliance.contains("NC")|| chaseCompliance.contains("NC/C"))
        {
            logTestStepPass("Contra non compliance shows only when exclusion date is in 2019 and page number is available");

        }
        else
        {
            logTestStepFail("Contra non compliance shows only when exclusion date is in 2019 and page number is available");
            Assert.fail("Contra non compliance shows only when exclusion date is in 2019 and page number is available");
        }
        HedisCCS.DeleteData();
        objLoginOut.logout();
    }
}
