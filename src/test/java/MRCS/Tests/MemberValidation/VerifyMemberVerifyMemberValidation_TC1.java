package MRCS.Tests.MemberValidation;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyMemberVerifyMemberValidation_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Rest of the form is disable until validation submitted", groups = {"Member Validation"})
    public void VerifyMemberValidationYes_TC1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        Common.getUserAndAssignTo();
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(ProjectsRepo.SelectedMeasure).click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        logTestStep("Clicking on First chase id");
        $x("//tr[1]//td[2]").click();
        logTestStep("Clicking on Chart");
        sleep(2000);
        $(RetrievalRepo.Chart).click();
        sleep(10000);
        if($x("(//label[contains(text(),'Medical Record DOB')]//following::input)[1]").isEnabled()) {
            Assert.fail("User able to edit the form without completion member validation.");
        } else{
            logTestStep("Rest of the form is disable");
        }
    }
}
