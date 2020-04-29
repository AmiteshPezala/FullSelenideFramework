package MRCS.Tests.HedisCOL;
import MRCS.Modules.Hedis.HedisCOL;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class COL_VerifyNRC_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify NRC can be selected and validated upon submission when chase is non compliant", groups = {"Hedis COL"} )
    public void W15_VerifyNRC() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOL.NavigateToCOL();
        objRisk.membervalidation();
        HedisCOL.DeleteIcon();
        HedisCOL.ClearIcon();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(3000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(4000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        String getMsg=$x("//span[contains(text(),'Negative reason code is missing from non-compliant numerator \"Colorectal Cancer Screening\";')]").getText();
        if(getMsg.equals("Negative reason code is missing from non-compliant numerator \"Colorectal Cancer Screening\";"))
        {
            logTestStepPass("Validation message is displayed that NRC  selection is required");
        }else
        {
            logTestStepFail("Validation message is not displayed that NRC  selection is required");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
