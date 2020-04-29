package MRCS.Tests.IVAHST;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static java.lang.Thread.sleep;

public class HST_VerifySearchResultAccuracy_TC67 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that result of search results are accurate.", groups = {"IVA HST"})
    public void HST_VerifySearchResultAccuracy_TC67() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ENCasYes();
        F2FasYes();
        Common.ClickElement(ProviderLookUpRepo.BackwardButton,"Backward button");
        ProviderLookUp.SearchForAdminKeyword();
        //ProviderLookUp.SearchForThirdRecord();
        String SecondRecord= Common.getElementText(By.xpath("(//th[@title='NPI']//following::tr[2]//td[1]//span)[2]"),2);
        logInfoStepColored(TestBase.COLOR.BLUE,"Second record:"+SecondRecord);
        if(WebDriverRunner.getWebDriver().getPageSource().contains(SecondRecord)){
            logTestStepPass("Search Results  Contains Accurate Data");
        }
        else
        {
            logTestStepFail("Search Results Does Not Contains Accurate Data");
            Assert.fail("Search Results Does Not Contains Accurate Data");
        }
        Common.ClickElement(ProviderLookUpRepo.CrossIcon,"Cross Icon");
        objLoginOut.logout();
    }
}
