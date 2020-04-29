package MRCS.Tests.OR2;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class ClinicalOR2StatsCount_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();

    @Test(description = "Grid is populated and matches the stat count", groups = {"OR2"})
    public void ClinicalOR2TestCase1() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        logTestStep("Clicked on Clinical Link");
        sleep(2000);
        $(ClinicalRepo.OR2).click();
        logTestStep("Clicked on OR2 link");
        sleep(3000);
        $x("//span[@class='activeStat']").click();
        sleep(5000);
        //Getting total count of chases
        String TotalChases = $x("//span[@class='activeStat']").getText();
        logTestStep("Total count of chases = " + TotalChases);

        //Checking the total count of chases
        sleep(5000);
        String url = $x("//div[@class='total-container']").getText();  // getting count of the xpath
        String[] arrSplit_3 = url.split("\\s");    // Splitting the line "Top 0 records"
        String count = null;
        for (int i = 1; i < 2; i++) {
            count = arrSplit_3[i];
            break;
        }
        logTestStep("Top records are  = " + count);
        assertText(count,TotalChases);
        objLoginOut.logout();
    }
}