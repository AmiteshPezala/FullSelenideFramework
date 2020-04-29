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
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HST_VerifyOR1ChangeGetHighlighted_TC38 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    Clinical objclinical = new Clinical();
    @Test(retryAnalyzer = Retry.class,description = "Verify OR1 changes get highlighted", groups = {"IVA HST"} )
    public void HST_VerifyOR1ChangeGetHighlighted() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Common.getUserAndAssignTo();
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        ClickElement(MeasureRepo.HST, "Clicking on HST");
        ClickElement(ProjectsRepo.Update, "Clicking on Update button");
        sleep(10000);
        logTestStep("Clicking on First chase id");
        String ChaseId = $x("//tr[1]//td[2]").getText();
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
                for (int i = 1; i <= page; i++) {

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
                }
                k++;
                System.out.println(k);
                if ($x("(//h3[contains(text(),'Diagnoses')]//preceding::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed()) {
                    $x("(//h3[contains(text(),'Diagnoses')]//preceding::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").click();
                } else {
                    break;
                }
            }
        } else {
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
        $x("//h4[contains(text(),'HCC Information')]//following::span[contains(text(),'Submit')]").click();
        sleep(1000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        assertText(message, "Submission Succeeded!");
        sleep(2000);
        Common.StopWalkThru();
        logInfoStepColored(COLOR.BLUE, "Chase id submitted from MRR");
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
        logInfoStepColored(COLOR.BLUE, "Chase id found which submitted from MRR");
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
        logInfoStepColored(COLOR.BLUE, "Chase id assign to logged in user");
        $x("//tr[1]//td[2]").click();
        $(RetrievalRepo.Chart).click();
        Common.waitForPageLoadToComplete();
        sleep(5000);
        objRisk.membervalidation();
        sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        sleep(2000);
        $x("(//h4[contains(text(),'ICD Information')]//following::input)[1]").setValue("5");
        sleep(4000);
        ClickElement($x("//div[@class='coding-container']"),"Click to save data");
        sleep(2000);
        logInfoStepColored(COLOR.BLUE, "Verifying color code");
        String borderColor=$x("(//h4[contains(text(),'ICD Information')]//following::input)[1]").getCssValue("border-color");
        sleep(2000);
        String[] hexValue = borderColor.replace("rgb(","").replace(")","").split(",");
        hexValue[0] = hexValue[0].trim();
        int hexValue1 = Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);
        String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
        Assert.assertTrue(actualColor.equals("#ffbf2c"));
        sleep(2000);
        objLoginOut.logout();
    }
}
