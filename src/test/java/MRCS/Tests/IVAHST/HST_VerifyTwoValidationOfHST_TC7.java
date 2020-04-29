package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyTwoValidationOfHST_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that drop down for specific service date and F2F service date is present or not.", groups = {"IVA HST"})
    public void HST_VerifyTwoValidationOfHST_TC7() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        logTestStep("Checking for the drop down of 'Specific service date'.");
        if($x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").isDisplayed()){
            $x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
            sleep(2000);
            if($x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::span[contains(text(),'Yes')])").isDisplayed() && $x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::span[contains(text(),'No')])").isDisplayed()){
                logTestStepPass("Drop down is present for 'Specific service date'.");
            }else{
                logTestStepFail("Drop down is not present for 'Specific service date'.");
                Assert.fail("Drop down is not present for 'Specific service date'.");
            }
        }else{
            logTestStepFail("Drop down is not present for 'Specific service date'.");
            Assert.fail("Drop down is not present for 'Specific service date'.");
        }
        $x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::span[contains(text(),'Yes')])").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(5000);
        logTestStep("Checking for the drop down of 'F2F service date'.");
        if($x("(//div[contains(text(),'Face to Face for specific service dates (F2F)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").isDisplayed()){
            $x("(//div[contains(text(),'Face to Face for specific service dates (F2F)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
            sleep(2000);
            if($x("(//div[contains(text(),'Face to Face for specific service dates (F2F)?')]//following::span[contains(text(),'Yes')])").isDisplayed() && $x("(//div[contains(text(),'Face to Face for specific service dates (F2F)?')]//following::span[contains(text(),'No')])").isDisplayed()){
                logTestStepPass("Drop down is present for 'F2F service date'.");
            }else{
                logTestStepFail("Drop down is not present for 'F2F service date'.");
                Assert.fail("Drop down is not present for 'F2F service date'.");
            }
        }else{
            logTestStepFail("Drop down is not present for 'F2F service date'.");
            Assert.fail("Drop down is not present for 'F2F service date'.");
        }
        objLoginOut.logout();
    }
}
