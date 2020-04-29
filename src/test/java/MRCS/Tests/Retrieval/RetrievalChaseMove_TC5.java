package MRCS.Tests.Retrieval;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;


import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalChaseMove_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Retrieval objRetrieval = new Retrieval();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();

    @Test(description = "Verify that chase is move to new AID or not ", groups = {"Retrieval"})
    public void RetrievalChaseMove_TC5() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        logTestStep("Clicking on PSR");
        $(RetrievalRepo.PSR).click();
        sleep(2000);
        String firstAID=$x("//tr[1]//td[2]").getText();
        Log.info(firstAID);
        String secondAID=$x("//tr[2]//td[2]").getText();
        Log.info(secondAID);
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on address id");
        sleep(3000);
        String firstchaseID=$x("//tr[1]//td[2]//div").getText();
        Log.info(firstchaseID);
        sleep(2000);
        $(".fa.fa-step-backward").click();
        sleep(2000);
        $x("//div[@class='grids-display']//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $(RetrievalRepo.MoveChase).click();
        logTestStep("Clicked on move chase option");
        sleep(2000);
        //searching for the address
        $x("//input[@id='retrievalLocationId']").setValue(secondAID);
        sleep(2000);
        $(RetrievalRepo.FindButton).click();
        sleep(2000);
        $x("//span[@class='ui-radiobutton-icon ui-clickable']").click();
        sleep(2000);
        $x("//textarea[@placeholder='Enter Notes for Chase Move.']").sendKeys("Moving chase from AID =" + firstAID + "to AID = " + secondAID );
        sleep(2000);
        $x("//span[contains(text(),'USE THIS ADDRESS')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Yes')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        // checking weather the AID of the chase id got changed or not
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        $(ProjectsRepo.ProjectsLink).click();
        logTestStep("Clicked on project link");
        sleep(2000);
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Clicked on Chase query option");
        sleep(2000);
        $(ProjectsRepo.ChaseId).click();
        logTestStep("Filter by chase id");
        sleep(2000);
        $(ProjectsRepo.EnterChaseId).sendKeys(firstchaseID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(3000);
        String NewAID = $x("//tr[1]//td[12]").getText();
        sleep(2000);
        Log.info(NewAID);
        assertText(firstAID,NewAID);
        objLoginOut.logout();
    }
}

