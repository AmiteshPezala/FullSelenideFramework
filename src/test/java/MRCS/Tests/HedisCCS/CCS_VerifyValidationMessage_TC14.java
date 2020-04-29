package MRCS.Tests.HedisCCS;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisCCSRepo;
import MRCS.Modules.Hedis.HedisCCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.getElementText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CCS_VerifyValidationMessage_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that any chase field shows a validation message when the date entered is outside the time-frame", groups = {"Hedis CCS"} )
    public void CCS_VerifyValidationMessage() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCCS.NavigateToCCS();
        objRisk.membervalidation();
        $(HedisCCSRepo.PapSmearDate).setValue("10/01/2028");
        ClickElement(CommonRepo.ClickToSave,"Clicking to save");
        if($x("//div[@class='control__header__error ng-star-inserted']").isDisplayed()) {
            logTestStepPass(" Field shows a validation message when the date entered is outside the time-frame");
            sleep(2000);
        }else{
            logTestStepFail("Validation message not displayed.");
        }
        objLoginOut.logout();
    }
}
