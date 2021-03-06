package MRCS.Tests.ChaseQuery;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class ChaseQuery_UponHoverChildrenChaseDisplayed_TC25 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that upon hover on parent chase children chase id's are displayed. ", groups = {"Chase Query"})
    public void ChaseQuery_UponHoverChildrenChaseDisplayed_TC25() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objProject.ProjectsLink();
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $(ProjectsRepo.Measure).click();
        sleep(2000);
        Log.info("Clicked on Measures tab");
        ClickElement(ProjectsRepo.SelectedMeasure, "Selecting HCC");
        Thread.sleep(2000);
        ClickElement(ProjectsRepo.Update, "Clicking on Update");
        Thread.sleep(2000);
        Common.waitForPageLoadToComplete();
        Thread.sleep(10000);
        if ($(CommonRepo.FirstChaseId).isDisplayed()) {
            logTestStepPass("Record Found");
            if ($x("//app-chase-grid-chase-id//div[@class='chase-id__related-chases-container ng-star-inserted']").isDisplayed()) {
                SelenideElement ParentChase=$x("//app-chase-grid-chase-id//div[@class='chase-id__related-chases-container ng-star-inserted']");
                String PursuitNo = $x("//app-chase-grid-chase-id//div[@class='chase-id__related-chases-container ng-star-inserted']").getText();
                logTestStepPass("Parent chase displayed number of pursuit in bracket on page no 1.");
                logTestStepPass("Pursuit no = " + PursuitNo);
                Actions actions = new Actions(WebDriverRunner.getWebDriver());
                actions.moveToElement(ParentChase).perform();
                if($x("//div[@class='chase-id__related-chases-container ng-star-inserted']//div[2]").isDisplayed()){
                    logTestStepPass("List of children chase Id's are present.");
                }else{
                    logTestStepFail("List of children chase Id's are not present.");
                }
            } else {
                ElementsCollection PageNoCount = $$x("//a[@class='ui-paginator-page ui-paginator-element ui-state-default ui-corner-all ng-star-inserted']");
                int NoOfTotalPages = PageNoCount.size();
                for (int i = 1; i <= NoOfTotalPages - 1; i++) {
                    String PageNo = $x("//a[@class='ui-paginator-page ui-paginator-element ui-state-default ui-corner-all ng-star-inserted'][" + i + "]").getText();
                    $x("//a[@class='ui-paginator-page ui-paginator-element ui-state-default ui-corner-all ng-star-inserted'][" + i + "]").click();
                    logTestStep("Checking on page no =" + PageNo);
                    Common.waitForPageLoadToComplete();
                    Thread.sleep(10000);
                    if ($x("//app-chase-grid-chase-id//div[@class='chase-id__related-chases-container ng-star-inserted']").isDisplayed()) {
                        SelenideElement ParentChase=$x("//app-chase-grid-chase-id//div[@class='chase-id__related-chases-container ng-star-inserted']");
                        String PursuitNo = $x("//app-chase-grid-chase-id//div[@class='chase-id__related-chases-container ng-star-inserted']").getText();
                        logTestStepPass("Parent chase displayed number of pursuit in bracket on page no= " + PageNo);
                        logTestStepPass("Pursuit no = " + PursuitNo);
                        Actions actions = new Actions(WebDriverRunner.getWebDriver());
                        actions.moveToElement(ParentChase).perform();
                        if($x("//div[@class='chase-id__related-chases-container ng-star-inserted']//div[2]").isDisplayed()){
                            logTestStepPass("List of children chase Id's are present.");
                        }else{
                            logTestStepFail("List of children chase Id's are not present.");
                        }
                        break;
                    } else {
                        logTestStepFail("Parent chase not displayed number of pursuit on page no = " + PageNo);
                    }
                }
            }
        } else {
            logTestStepFail("No Record Found");
        }
        objLoginOut.logout();
    }
}
