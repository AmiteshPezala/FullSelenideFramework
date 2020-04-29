package MRCS.Tests.IVAHST;
import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyValidationMessageForSameProvider_TC70 extends TestBase{
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify validation is available if user selects same provider multiple times", groups = {"IVA HST"})
    public void HST_VerifyValidationMessageForSameProvider_TC70() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ENCasYes();
        F2FasYes();
        $(ProviderLookUpRepo.BackwardButton).click();
        sleep(2000);
        ProviderLookUp.SearchForAdminKeyword();
        sleep(2000);
        String getNPI=Common.getElementText(By.xpath("//member-risk-encounter//tr[2]//td[1]"),2);
        sleep(2000);
        logInfoStepColored(TestBase.COLOR.BLUE,"First Time Selected NPI:"+getNPI);
        Log.info(getNPI);
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton, "Select Button");
        sleep(2000);
        Common.ClickElement(ProviderLookUpRepo.MagnifyingIconInEncounter,"Magnifying Icon");
        sleep(2000);
        $(ProviderLookUpRepo.SearchForProviderText).sendKeys(getNPI);
        Common.ClickElement(ProviderLookUpRepo.SearchButton,"Search Button");
        sleep(2000);
        String getNPI2=Common.getElementText(By.xpath("//member-risk-encounter//tr[2]//td[1]"),2);
        sleep(2000);
        logInfoStepColored(TestBase.COLOR.BLUE,"Second Time Selected NPI:"+getNPI2);
        sleep(2000);
        Common.ClickElement(ProviderLookUpRepo.SecondSelectButton, "Select Button");
        sleep(2000);
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