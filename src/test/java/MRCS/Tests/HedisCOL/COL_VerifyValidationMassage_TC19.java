package MRCS.Tests.HedisCOL;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisCOLRepo;
import MRCS.Modules.Hedis.HedisCOL;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.getElementText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class COL_VerifyValidationMassage_TC19 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that any chase field shows a validation message when the date entered is outside the time-frame", groups = {"Hedis COL"} )
    public void COL_VerifyValidationMassage() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOL.NavigateToCOL();
        objRisk.membervalidation();
        $(HedisCOLRepo.ColonoscopyDate).setValue("10/01/2028");
        ClickElement(CommonRepo.ClickToSave,"Clicking to save");
        sleep(2000);
        if($x("//div[@class='control__header__error ng-star-inserted']").isDisplayed())
        {
            logTestStepPass("Field shows a validation message when the date entered is outside the time-frame");
        }else
        {
            logTestStepFail("Field not shows a validation message when the date entered is outside the time-frame");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
