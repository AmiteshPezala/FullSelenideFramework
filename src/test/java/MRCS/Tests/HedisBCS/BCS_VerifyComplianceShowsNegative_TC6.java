package MRCS.Tests.HedisBCS;

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

public class BCS_VerifyComplianceShowsNegative_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that BCS shows -ve compliance when date is not between 10/01/2016 TO 12/31/2018", groups = {"Hedis BCS"} )
    public void BCS_VerifyComplianceShowsNegative() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        $(HedisBCSRepo.MammogramDate).setValue("10/01/2015");
        sleep(2000);
        $(HedisBCSRepo.MammogramPageNumber).setValue("1");
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        $x("//th[contains(text(),'Numerator')]").click();
        sleep(2000);
        String GetMsg=$x("//span[contains(text(),'NC')]").getText();
        if(GetMsg.equals("NC")){
            logTestStepPass("BCS shows -ve compliance");
        }else{
            logTestStepFail("BCS not shows -ve compliance");
        }
        sleep(2000);
        ClickElement($(HedisBCSRepo.Delete), "Clicking to clear data");
        sleep(2000);
        objLoginOut.logout();
    }
}
