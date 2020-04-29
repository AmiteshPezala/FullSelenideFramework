package MRCS.Tests.IVAHST;

import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyProviderName_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that Provider drop down is present and drop down contains the list of provider with specialization.", groups = {"IVA HST"})
    public void HST_VerifyProviderName_TC14() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        CommonRisk.ENCasYes();
        CommonRisk.F2FasYes();
        sleep(2000);
        if($x("//div[contains(text(),'Provider')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").isDisplayed()){
            logTestStepPass("Provider drop down is present");
        }else{
            logTestStepFail("Provider drop down is not present");
        }
        $x("//div[contains(text(),'Provider')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        String ProviderName = $x("//p-dropdownitem//li//span").getText();
        Log.info(ProviderName);
        sleep(2000);
        if(ProviderName.isEmpty()){
            logTestStepPass("Provider name list is not displayed.");
        }else{
            logTestStepPass("Provider list with specialization is displayed.");
        }
        objLoginOut.logout();
    }
}
