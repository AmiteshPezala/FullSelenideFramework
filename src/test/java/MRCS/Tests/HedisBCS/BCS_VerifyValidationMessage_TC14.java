package MRCS.Tests.HedisBCS;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisBCSRepo;
import MRCS.Modules.Hedis.HedisBCS;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.getElementText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BCS_VerifyValidationMessage_TC14 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that any chase field shows a validation message when the date entered is outside the time-frame", groups = {"Hedis BCS"} )
    public void BCS_VerifyValidationMessage() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisBCS.NavigateToBCS();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        $(HedisBCSRepo.MammogramDate).setValue("10/01/2028");
        ClickElement(CommonRepo.ClickToSave,"Clicking to save");
        String ToolTipMessage=getElementText(By.xpath("//div[@class='control__header__error ng-star-inserted']"),2);
        System.out.println(ToolTipMessage);
        if($x("//div[@class='control__header__error ng-star-inserted']").isDisplayed())
        {
            logTestStepPass("Field shows a validation message when the date entered is outside the time-frame");
        }else
        {
            logTestStepFail("Field not shows a validation message when the date entered is outside the time-frame");
            Assert.fail("Field not shows a validation message when the date entered is outside the time-frame");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
