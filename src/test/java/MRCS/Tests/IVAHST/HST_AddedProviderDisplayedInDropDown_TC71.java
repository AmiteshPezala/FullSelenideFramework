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
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_AddedProviderDisplayedInDropDown_TC71 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();


    @Test(description = "Verify that provider added through search is available in provider field drop down", groups = {"IVA HST"})
    public void HST_AddedProviderDisplayedInDropDown_TC71() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ENCasYes();
        F2FasYes();
        Common.ClickElement(ProviderLookUpRepo.BackwardButton, "Backward button");
        ProviderLookUp.SearchForAdminKeyword();
        String getNPI=Common.getElementText(By.xpath("(//tr[2]//td[1])[1]"),2);
        logInfoStepColored(COLOR.BLUE,"First Time Selected NPI:"+getNPI);
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton, "Select Button");
        sleep(2000);
        $x("//div[contains(text(),'Service End Date')]").click();
        sleep(5000);

        Common.ClickElement(ProviderLookUpRepo.ProviderDropdown,"Provider Dropdown");

        if(WebDriverRunner.getWebDriver().getPageSource().contains(getNPI)){
            logTestStepPass("Provider added through search is available in provider field drop down");
        }
        else
        {
            logTestStepFail("Provider not added through search is available in provider field drop down");
            Assert.fail("Provider not added through search is available in provider field drop down");
        }
        objLoginOut.logout();
    }
}
