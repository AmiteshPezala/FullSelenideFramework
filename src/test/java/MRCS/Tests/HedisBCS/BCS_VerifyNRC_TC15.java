package MRCS.Tests.HedisBCS;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisBCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BCS_VerifyNRC_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify NRC can be selected and validated upon submission when chase is non compliant", groups = {"Hedis BCS"} )
    public void BCS_VerifyNRC() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ClickElement($(HedisBCSRepo.Delete), "Clicking to clear data");
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        ClickElement(CommonRepo.SubmitMeasure,"Clicking to clear data");
        sleep(4000);
        String getMsg=$x("//span[contains(text(),'Negative reason code is missing from non-compliant numerator \"Breast Cancer Screening\";')]").getText();
        if(getMsg.equals("Negative reason code is missing from non-compliant numerator \"Breast Cancer Screening\";"))
        {
            logTestStepPass("Validation message is displayed that NRC  selection is required");
        }else
        {
            logTestStepFail("Validation message not displayed that NRC  selection is required");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
