package MRCS.Tests.IVAHST;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_NoteRequiredForServiceEndDate_TC49 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that note field of service end date is a required field.", groups = {"IVA HST"})
    public void HST_NoteRequiredForServiceEndDate_TC49() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
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
                System.out.println("result = " + result);
                for (int i = 1; i <= page ; i++) {

                    if (result == 1 && i == 1) {
                        Log.info("in if loop");
                        objRisk.NoterequiredForServiceEndDate();
                        sleep(2000);
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
            objRisk.NoterequiredForServiceEndDate();
            sleep(2000);
            for (int i = 1; i <= page - 1; i++) {
                System.out.println(i);
                $x("//tr[" + (i + 1) + "]//td[1]").click();
                objRisk.EncountervalidationNo();
            }
        }
        objRisk.ChecklistForART();
        sleep(2000);
        $x("(//span[contains(text(),'Submit')])[2]").click();
        sleep(5000);
        if(WebDriverRunner.getWebDriver().getPageSource().contains("EncounterServiceDateThru Note must be provided")){
            logTestStepPass("Validation message displayed");
        }else{
            logTestStepFail("Validation message not displayed");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
