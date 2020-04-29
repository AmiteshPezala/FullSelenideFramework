package MRCS.Tests.MRR;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class ClinicalMRRStatsCount_TC1 extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();

    @Test(description = "Grid is populated and matches the stat count", groups = {"MRR"})
    public void ClinicalMRRTestCase1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicking on Clinical link");
        objClinical.ClinicalLink();
        sleep(2000);
        $(ClinicalRepo.MRR).click();
        logTestStep("Clicked on MRR Link");
        sleep(3000);
        $x("//span[@class='activeStat']").click();
        sleep(5000);
        //Getting total count of chases
        logTestStep("Verifying MRR grid load and matches count");
        String TotalChases = $x("//span[@class='activeStat']").getText();
        logTestStep("Total count of chases = " + TotalChases);
        //Checking the total count of chases
        sleep(5000);
        String url = $x("//div[@class='total-container']").getText();  // getting count of the xpath
        String[] arrSplit_3 = url.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 1; i < 2; i++) {
            count = arrSplit_3[i];
            break;
        }
        logTestStep("Top records are  = " + count );
        assertText(TotalChases,count);
        objLoginOut.logout();
        }
}