package MRCS.Tests.MRR;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyDataValidation_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Review data validation for all events ", groups = {"MRR"} )
    public void VerifyDataValidation() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Common.getUserAndAssignTo();
        ClickElement(ProjectsRepo.Measure,"Clicking on Measure");
        Log.info("Clicked on Measures tab");
        ClickElement(MeasureRepo.BCS,"Selecting");
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        sleep(5000);
        Common.waitForPageLoadToComplete();
        Common.SelectChaseAndOpenChart();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        $x("(//div[contains(text(),'Mammogram')]//following::input)[1]").setValue("10/01/2028");
        ClickElement(CommonRepo.ClickToSave,"Clicking to save");
        String ToolTipMessage=getElementText(By.xpath("//div[@class='control__header__error ng-star-inserted']"),2);
        //System.out.println($x("//div[@class='ellipsis ng-star-inserted']").shouldBe(visible));
        if($(By.xpath("//div[@class='control__header__error ng-star-inserted']")).waitUntil(Condition.appear,DEFAULT_WAIT).isDisplayed()){
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
