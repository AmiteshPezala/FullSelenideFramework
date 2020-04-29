package MRCS.Tests.HedisBCS;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisBCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class BCS_MammogramDate_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify  mammogram date field is a required field for +ve compliance", groups = {"Hedis BCS"} )
    public void BCS_MammogramDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        $(HedisBCSRepo.MammogramDate).setValue("12/31/2028");
        sleep(2000);
        //String GetMsg=$x("//div[contains(text(),'Date between 10/01/2016 and 12/31/2018 expected;')]").getText();
        if($(".control__header__error").isDisplayed()){
            logTestStepPass("Validation message displayed when date is not in MY");
        }else{
            logTestStepFail("Validation message not displayed when date is not in MY");
            Assert.fail("Validation message not displayed when date is not in MY");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}