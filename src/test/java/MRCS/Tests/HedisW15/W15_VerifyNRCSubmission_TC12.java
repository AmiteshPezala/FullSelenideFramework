package MRCS.Tests.HedisW15;

import MRCS.Modules.Hedis.HedisW15;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class W15_VerifyNRCSubmission_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    Measure objMeasure = new Measure();

    @Test( description = "Verify NRC can be selected and validated upon submission when chase is non compliant", groups = {"Hedis W15"} )
    public void W15_VerifyNRC() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisW15.NavigateToW15();
        objRisk.membervalidation();
        objMeasure.DeleteRow_CIS();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//th[contains(text(),'Chase Compliance')]"));
        sleep(2000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(4000);
        if($x("//span[@class='ui-messages-detail ng-tns-c5-1 ng-star-inserted']").isDisplayed()){
            logTestStepPass("Validation message displayed ");
        }else{
            logTestStepFail("Validation messsage not displayed ");
        }
        sleep(2000);
        $x("//i[@class='pi pi-times']").click();
        objLoginOut.logout();
    }
}
