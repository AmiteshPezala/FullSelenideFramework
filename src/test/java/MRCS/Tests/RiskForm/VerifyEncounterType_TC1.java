package MRCS.Tests.RiskForm;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyEncounterType_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify that encounter type is a required field", groups = {"RiskForm"})
    public void VerifyEncounterType() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        sleep(2000);
        objRisk.getUser();
        sleep(2000);
        objRisk.membervalidation();
        sleep(2000);
        int k = 1;
        if ($x("(//h3[contains(text(),'Diagnoses')]//preceding::span[@class='ui-paginator-pages'])").isDisplayed()) {
            while ($x("(//h3[contains(text(),'Diagnoses')]//preceding::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed() || $x("//tr[1]//td[1]").exists()) {
                Log.info("Pagination is displayed");
                ElementsCollection col = $$(ClinicalRepo.pageno);
                int page = col.size();
                System.out.println("page no " + page);
                String paginationCount = $x("//span[@class='ui-paginator-pages']/a[" + k + "]").getText();
                int result = Integer.parseInt(paginationCount);
                System.out.println("result = " + result);
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
        //Add New Encounter
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Encounters')]"));
        objRisk.AddEncounter();
        sleep(2000);
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(5000);
        objRisk.ChecklistForART();
        sleep(3000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(5000);
        if (WebDriverRunner.getWebDriver().getPageSource().contains("Encounter must have an Encounter Type")) {
            logTestStepPass("Validation message displayed as Encounter must have an Encounter Type");
        } else {
            logTestStepFail("Validation message not displayed as Encounter must have an Encounter Type");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
