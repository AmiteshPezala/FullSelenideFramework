package MRCS.Tests.IVAHST;
import MRCS.Locators.*;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.Retry;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_VerifyPursuitGeneration_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    Clinical objclinical = new Clinical();
    @Test(retryAnalyzer = Retry.class,description = "Verify pursuit generation happens only after form submission from Or1", groups = {"IVA HST"} )
    public void HST_VerifyPursuitGeneration() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Common.getUserAndAssignTo();
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        ClickElement(MeasureRepo.HST, "Clicking on HST");
        ClickElement(ProjectsRepo.Update, "Clicking on Update button");
        waitForPageLoadToComplete();
        sleep(5000);
        logTestStep("Clicking on First chase id");
        String ChaseId=$x("//tr[1]//td[2]").getText();
        System.out.println(ChaseId);
        $x("//tr[1]//td[2]").click();
        logTestStep("Clicking on Chart");
        sleep(2000);
        $(RetrievalRepo.Chart).click();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        int k = 1;
        if ($x("(//h3[contains(text(),'Diagnoses')]//preceding::span[@class='ui-paginator-pages'])").isDisplayed()) {
            while ($x("(//h3[contains(text(),'Diagnoses')]//preceding::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed() || $x("//tr[1]//td[1]").exists()) {
                Log.info("Pagination is displayed");
                ElementsCollection col = $$(ClinicalRepo.pageno);
                int page = col.size();
                System.out.println("page no " + page);
                String paginationCount = $x("//span[@class='ui-paginator-pages']/a[" + k + "]").getText();
                int result = Integer.parseInt(paginationCount);
                System.out.println("reult = " + result);
                for (int i = 1; i <= page ; i++) {

                    if (result == 1 && i == 1) {
                        Log.info("in if loop");
                        objRisk.EncountervalidationYes();
                        sleep(2000);
                        objRisk.DiagnosisGriddata();

                    } else {
                        Log.info("in else loop");
                        $x("//tr[" + (i + 0) + "]//td[1]").click();
                        objRisk.EncountervalidationNo();

                    }
                }k++;
                System.out.println(k);
                if ($x("(//h3[contains(text(),'Diagnoses')]//preceding::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed()){
                    $x("(//h3[contains(text(),'Diagnoses')]//preceding::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").click();
                }else{
                    break;
                }
            }
        }
        else {
            ElementsCollection col = $$(ClinicalRepo.pageno);
            int page = col.size();
            System.out.println("page no " + page);
            Log.info("pagination not found");
            objRisk.EncountervalidationYes();
            sleep(2000);
            objRisk.DiagnosisGriddata();
            sleep(2000);
            for (int i = 1; i <= page - 1; i++) {
                System.out.println(i);
                $x("//tr[" + (i + 1) + "]//td[1]").click();
                objRisk.EncountervalidationNo();
            }
        }
        sleep(5000);
        objRisk.ChecklistForART();
        sleep(2000);
        $x("//h4[contains(text(),'HCC Information')]//following::span[contains(text(),'Submit')]").click();
        sleep(1000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        assertText(message,"Submission Succeeded!");
        sleep(2000);
        Common.StopWalkThru();
        logInfoStepColored(COLOR.BLUE,"Chase id submitted from MRR");
        sleep(2000);
        objLoginOut.logout();
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_Manager);
        logTestStep("Log in to application as a Manager user");
        Common.PopUp();
        sleep(5000);
        $(LoginOutRepo.UatAdmin).click();
        sleep(2000);
        $x("//div[@class='menu--item'][contains(.,'My Profile')]").click();
        sleep(2000);
        String FirstName = $(By.id("firstName")).getValue();
        sleep(2000);
        String LastName = $(By.id("lastName")).getValue();
        sleep(2000);
        String User = FirstName + " " + LastName;
        sleep(2000);
        //String user=Common.GetUserName();
        objclinical.ClinicalLink();
        $(ClinicalRepo.OR1).click();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
        sleep(2000);
        $x("//input[@id='ChaseIdAndClientChaseKey']").sendKeys(ChaseId);
        sleep(2000);
        ClickElement(ProjectsRepo.Update, "Clicking on Update button");
        sleep(5000);
        $x("//tr[1]//td[1]").click();
        logInfoStepColored(COLOR.BLUE,"Chase id found which submitted from MRR");
        sleep(2000);
        $x("//span[contains(text(),'Assign Chase(s)')]").click();
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(2000);
        logInfoStepColored(COLOR.BLUE,"Chase id assign to logged in user");
        $x("//tr[1]//td[2]").click();
        $(RetrievalRepo.Chart).click();
        Common.waitForPageLoadToComplete();
        sleep(5000);
        objRisk.membervalidation();
        sleep(4000);
        $x("//h4[contains(text(),'HCC Information')]//following::span[contains(text(),'Submit')]").click();
        sleep(4000);
        logInfoStepColored(COLOR.BLUE,"Chase id submitted from OR1");
        logTestStep("Clicking on Approval Center");
        $x("//span[contains(text(),'Approval Center')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Approve Pursuits')]").click();
        sleep(300000);
        Common.RefreshPage();
        ClickElement(ProjectsRepo.Filter,"Clicking on Filter button");
        ClickElement(By.xpath("(//span[@class='ui-tabview-title ng-star-inserted'])[2]"),"Clicking on Chase");
        sleep(2000);
        $x("//input[@id='ChaseId']").sendKeys(ChaseId);
        sleep(2000);
        ClickElement(ProjectsRepo.Update, "Clicking on Update button");
        sleep(5000);
        $x("//tr[1]//td[1]").click();
        logInfoStepColored(COLOR.BLUE,"Chase id found in Approve Pursuits which submitted from OR1");
        sleep(2000);
        ClickElement($x("(//span[contains(text(),'Approve')])[3]"),"Clicking on Approve button");
        String getMsg=$x("//div[contains(text(),'1 Chase(s) Requests successfully approved.')]").getText();
        sleep(2000);
        if(getMsg.equals("1 Chase(s) Requests successfully approved."))
        {
            logTestStepPass("pursuit get generated for the specific encounter upon form submission");
        }else
        {
            logTestStepFail("pursuit not generated for the specific encounter upon form submission");
        }
    }
}
