package MRCS.Tests.HedisCCS;

import MRCS.Locators.HedisRepo.HedisCCSRepo;
import MRCS.Modules.Hedis.HedisCCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CCS_VerifyNRCValidation_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that NRC validation message is displayed if user tries to submit a non compliance chase with out NRC", groups = {"Hedis CCS"} )
    public void CCS_VerifyNRCValidation() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCCS.NavigateToCCS();
        objRisk.membervalidation();
        HedisCCS.ClearData();
        String CurrentDate=Common.GetCurrentTimeStamp();
        $(HedisCCSRepo.HPVTestDate).setValue(CurrentDate);
        sleep(2000);
        $(HedisCCSRepo.HPVTestDropDown).click();
        sleep(1000);
        $x("(//span[contains(text(),'No')])[2]").click();
        sleep(2000);
        $(HedisCCSRepo.HPVTestPageNumber).setValue("1");
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        String getMsg=$x("//span[contains(text(),'Negative reason code is missing from non-compliant numerator \"Cervical Cancer Screening Positive\";')]").getText();
        if(getMsg.equals("Negative reason code is missing from non-compliant numerator \"Cervical Cancer Screening Positive\";"))
        {
            logTestStepPass("NRC validation displayed");
        }else
        {
            logTestStepFail("NRC validation not displayed");
            Assert.fail("NRC validation not displayed");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
