package MRCS.Tests.OR2;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR2;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.getElementText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyDataValidation_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Verify data validation for all fields", groups = {"OR2"})
    public void VerifyDataValidation_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_NonAdmin);
        Common.PopUp();
        //objWait.implicitwait();
        OR2.BulkAssignToUser();
        objcommon.SelectChaseAndOpenChart();
        sleep(2000);
        objRisk.membervalidation();
        sleep(2000);
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2028");
        ClickElement(CommonRepo.ClickToSave,"Clicking to save");
        String ToolTipMessage=getElementText(By.xpath("//div[@class='control__header__error ng-star-inserted']"),2);
        System.out.println(ToolTipMessage);
        $x("//div[@class='control__header__error ng-star-inserted']").shouldHave(text("Date between 10/01/2017 and 12/31/2019 expected;"));
        logTestStepPass(" Field shows a validation message when the date entered is outside the time-frame");
        sleep(2000);
        objLoginOut.logout();
    }
}
