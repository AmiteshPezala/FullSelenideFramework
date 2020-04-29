package MRCS.Tests.OR1;

import MRCS.Modules.Clinical;
import MRCS.Modules.ClinicalModule.OR1;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyDataValidation_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();
    Risk objRisk=new Risk();

    @Test(description = "Review data validation for all events", groups = {"OR1"})
    public void VerifyDataValidation() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        OR1.BulkAssignToUser();
        SelectChaseAndOpenChart();
        objRisk.membervalidation();
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2028");
        ClickElement($x("//div[contains(text(),'Mammogram')]"),"Clicking to save");
        sleep(2000);
        String ToolTipMessage=getElementText(By.xpath("//div[@class='control__header__error ng-star-inserted']"),2);
        if(ToolTipMessage.contains("Date between 10/01/2016 and 12/31/2018 expected;")){
            logTestStepPass("Field shows a validation message");
        }else
        {
            logTestStepFail("Validation Message not displayed");
            Assert.fail("Validation Message not displayed");
        }

        sleep(2000);
        objLoginOut.logout();
    }
}
