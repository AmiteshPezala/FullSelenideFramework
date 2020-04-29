package MRCS.Tests.RetrievalAssignment;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class VerifyFilter_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify filter.", groups = {"Retrieval Assignment"})
    public void VerifyFilter_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicked on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(RetrievalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        String AID=$x("//tr[1]//td[2]//a").getText();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'AID')]").click();
        sleep(2000);
        $x("//input[@id='Id']").setValue(AID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        String NewAID=$x("//tr[1]//td[2]//a").getText();
        sleep(2000);
        assertText(AID,NewAID);
        sleep(2000);
        objLoginOut.logout();
    }
}