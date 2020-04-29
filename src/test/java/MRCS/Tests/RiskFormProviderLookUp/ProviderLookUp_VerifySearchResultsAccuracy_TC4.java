package MRCS.Tests.RiskFormProviderLookUp;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProviderLookUp_VerifySearchResultsAccuracy_TC4 extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify the search results return  is accurate", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLookUp_VerifySearchResultsAccuracy() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProviderLookUp.NavigateToMagnifyingIcon();
        ProviderLookUp.SearchForAdminKeyword();
        //ProviderLookUp.SearchForThirdRecord();
        String SecondRecord=Common.getElementText(By.xpath("(//th[@title='NPI']//following::tr[2]//td[1]//span)[2]"),2);
        logInfoStepColored(COLOR.BLUE,"Second record:"+SecondRecord);
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
