package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HST_EncounterGridPagination_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify that pagination is displayed if records are more than 5 records .", groups = {"IVA HST"})
    public void HST_EncounterGridPagination_TC6() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        String TotalCount=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[1]").getText();
        Log.info(TotalCount);
        int Count =Integer.parseInt(TotalCount);
        if(Count > 5){
            if($x("//span[@class='ui-paginator-pages']").isDisplayed()){
                logTestStepPass("Pagination is displayed.");
            }else{
                logTestStepFail("Pagination not displayed");
            }
        }else{
            logTestStep("Count is : " + TotalCount +" "+ ", Pagination not needed");
        }
        objLoginOut.logout();
    }
}