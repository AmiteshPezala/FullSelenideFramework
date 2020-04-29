package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyQueuePriorities_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();


    @Test(description = "Verify queue priority functionality.", groups = {"Clinical Assignment"})
    public void VerifyQueuePriorities_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(10000);
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(15000);
        $(ProviderLookUpRepo.BackwardButton).click();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Projects')]").click();
        sleep(2000);
        $x("//*[starts-with(span,'UAT')]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        if($x("//tr[1]//td[1]").isDisplayed()){
            Log.info("Records for this project is present");
            $x("//div[@class='chip__item']").click();
            sleep(2000);
            $x("//span[contains(text(),'QUEUE PRIORITIES')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Project')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']").click();
            sleep(2000);
            $x("//*[starts-with(span,'UAT')]").click();
            sleep(2000);
            String ProjectName=$x("//label[contains(text(),'Project')]//following::label").getText();
            Log.info("Drop down ProjectName = " + ProjectName);
            sleep(2000);
            $x("//span[contains(text(),'UPDATE QUEUE')]").click();
            sleep(15000);
            String Project =$x("//tr[1]//td[6]").getText();
            Log.info("Project = " + Project);
            sleep(2000);
            if(ProjectName.equals(Project)){
                logTestStepPass("Selected project is appeared on the top of the list");
            }else{
                logTestStepFail("Selected project is not appeared on the top of the list");
            }
        }else{
            logTestStep("Records for this project is not available.");
        }

        objLoginOut.logout();
    }
}