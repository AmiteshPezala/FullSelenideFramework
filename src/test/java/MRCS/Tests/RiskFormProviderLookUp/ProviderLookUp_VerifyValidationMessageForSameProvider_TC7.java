package MRCS.Tests.RiskFormProviderLookUp;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ProviderLookUp_VerifyValidationMessageForSameProvider_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify validation is available if user selects same provider multiple times", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLookUp_VerifyValidationMessageForSameProvider() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProviderLookUp.NavigateToMagnifyingIcon();
        ProviderLookUp.SearchForAdminKeyword();
        String getNPI=Common.getElementText(By.xpath("(//tr[2]//td[1])"),5);
        logInfoStepColored(COLOR.BLUE,"First Time Selected NPI:"+getNPI);
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton, "Select Button");
        sleep(2000);
        $x("//div[contains(text(),'Is the provider signature acceptable?')]").click();
        sleep(5000);
        Common.ClickElement(ProviderLookUpRepo.MagnifyingIconInEncounter,"Magnifying Icon");
        sleep(2000);
        $(ProviderLookUpRepo.SearchForProviderText).sendKeys(getNPI);
        Common.ClickElement(ProviderLookUpRepo.SearchButton,"Search Button");
        sleep(2000);
        String getNPI2=Common.getElementText(By.xpath("(//tr[2]//td[1])[2]"),2);
        logInfoStepColored(COLOR.BLUE,"Second Time Selected NPI:"+getNPI2);
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton, "Select Button");
        sleep(1000);
        //String getErrorMessage=$x("//span[contains(text(),'This provider already mapped to the chase;')]").getText();
        if($x("//span[contains(text(),'This provider already mapped to the chase;')]").isDisplayed())
        {
            logTestStepPass("Validation is available when a user selects a provider which is already assigned");
        }
        else
        {
            logTestStepFail("Validation is not available when a user selects a provider which is already assigned");
            Assert.fail("Validation is not available when a user selects a provider which is already assigned");
        }
        Common.ClickElement(ProviderLookUpRepo.CrossIcon,"Cross Icon");
        objLoginOut.logout();
    }
}
