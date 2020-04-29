package MRCS.Tests.RetrievalAssignment;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class VerifyUnassignedAddressListing_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify unassigned address listing", groups = {"Retrieval Assignment"})
    public void VerifyUnassignedAddressListing_TC2() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicked on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(RetrievalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        $x("(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]").click();
        sleep(2000);
        $x("(//p-dropdownitem//li)[4]").click();
        $x("(//p-dropdownitem//li)[4]").click();
        sleep(5000);
        $(ProviderLookUpRepo.BackwardButton).click();
        sleep(2000);
        String AssignedTo=$x("//tr[1]//td[19]").getText();
        Log.info(AssignedTo);
        sleep(2000);
        ElementsCollection col = $$(ProjectsRepo.CheckBox);
        Log.info("enter into comparison");
        int record = col.size(); // Will get total number of records
        Log.info("No of cols are : " + record);
        for (int i = 0; i < record - 1; i++) {
            String ChaseKey = $x("//tr[" + (i + 1) + "]//td[19]").getText();
            Log.info(ChaseKey);
            assertText(ChaseKey,AssignedTo);
        }
        objLoginOut.logout();
    }
}
