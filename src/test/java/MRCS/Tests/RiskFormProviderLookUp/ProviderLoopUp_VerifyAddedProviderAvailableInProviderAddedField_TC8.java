package MRCS.Tests.RiskFormProviderLookUp;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ProviderLoopUp_VerifyAddedProviderAvailableInProviderAddedField_TC8 extends TestBase{
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify that provider added through search is available in provider field drop down", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLoopUp_VerifyAddedProviderAvailableInProviderAddedField() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProviderLookUp.NavigateToMagnifyingIcon();
        ProviderLookUp.SearchForAdminKeyword();
        String getNPI=Common.getElementText(By.xpath("(//tr[2]//td[1])[2]"),2);
        logInfoStepColored(COLOR.BLUE,"First Time Selected NPI:"+getNPI);
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton, "Select Button");
        sleep(2000);
        $x("//div[contains(text(),'Is the provider signature acceptable?')]").click();
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
