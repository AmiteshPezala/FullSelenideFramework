package MRCS.Tests.IVAENR;

import MRCS.Modules.Clinical;
import MRCS.Modules.Hedis.IVAENR;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ENR_RatingAreaNoteFieldIsRequired_TC46 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify that note field of rating area is required field.", groups = {"IVA ENR"})
    public void ENR_RatingAreaNoteFieldIsRequired_TC46() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        IVAENR.navigateToENR();
        objRisk.membervalidation();
        sleep(2000);
        String SubscriberType=$x("//input[@id='SubscriberType']").getValue();
        Log.info(SubscriberType);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//*[contains(text(),'Rating Area')]"));
        sleep(2000);
        if(SubscriberType.equals("S")){
            logTestStep("Subscriber type is S");
            $x("//div[contains(text(),'Rating Area')]//following::button[@class='control__delete ng-star-inserted']").click();
            sleep(2000);
            $x("//div[contains(text(),'Rating Area')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//div[contains(text(),'Rating Area')]//following::span[contains(text(),'Yes - With Transformation')]").click();
            sleep(2000);
            $x("(//div[contains(text(),'Rating Area')]//following::input)[1]").setValue("1");
            sleep(2000);
            $x("//div[@class='coding-container']").click();
            sleep(2000);
            objRisk.ChecklistForART();
            sleep(2000);
            $x("(//span[contains(text(),'Submit')])[2]").click();
            sleep(2000);
            if(WebDriverRunner.getWebDriver().getPageSource().contains("RatingArea, PageNumber, Confirm  must be provided")){
                logTestStepPass("Validation message displayed");
            }else{
                logTestStepFail("Validation message not displayed");
                Assert.fail("Validation message not displayed");
            }
        }else{
            logTestStep("Subscriber type is N");
            logTestStepPass("Rating Area field is non editable for subscriber type = N");
        }
        objLoginOut.logout();
    }
}
