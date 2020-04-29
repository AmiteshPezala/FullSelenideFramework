package MRCS.Tests.HedisCOA;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.HedisRepo.HedisCOARepo;
import MRCS.Modules.Hedis.HedisCOA;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.getElementText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class COA_VerifyValidationMessage_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify that any chase field shows a validation message when the date entered is outside the time-frame", groups = {"Hedis COA"} )
    public void COA_VerifyValidationMessage() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisCOA.NavigateToCOA();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        HedisCOA.ClearData();
        $(HedisCOARepo.ACPDate).setValue("10/01/2028");
        $x("//div[contains(text(),'Advanced Care Planning Found On Qualifying Undated')]").click();
        sleep(2000);
       // ClickElement(CommonRepo.ClickToSave,"Clicking to save");
        String ToolTipMessage=getElementText(By.xpath("//div[@class='control__header__error ng-star-inserted']"),2);
        System.out.println(ToolTipMessage);
        $x("//div[@class='control__header__error ng-star-inserted']").shouldHave(text("Date between 01/01/2018 and 12/31/2018 expected;"));
        logTestStepPass(" Field shows a validation message when the date entered is outside the time-frame");
        sleep(2000);
        objLoginOut.logout();
    }
}
