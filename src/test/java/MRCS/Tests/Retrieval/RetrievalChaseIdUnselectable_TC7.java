package MRCS.Tests.Retrieval;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalChaseIdUnselectable_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Retrieval objRetrieval = new Retrieval();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();

    @Test(description = "Verify that after moving chase , that chase is unselectable or not", groups = {"Retrieval"})
    public void RetrievalChaseIdUnselectable_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        logTestStep("Clicking on PSR");
        $(RetrievalRepo.PSR).click();
        sleep(5000);
        String firstAID = $x("//tr[1]//td[2]").getText();
        Log.info(firstAID);
        String secondAID = $x("//tr[2]//td[2]").getText();
        Log.info(secondAID);
        $(RetrievalRepo.AIDFirstRow).click();
        logTestStep("Clicked on address id");
        sleep(3000);
        $(ProviderLookUpRepo.BackwardButton).click();
        sleep(2000);
        String firstchaseID = $x("//div[@class='grids-display']//app-basic-grid[@class='grids-display']//tr[1]//td[2]").getText();
        Log.info(firstchaseID);
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
        $x("//textarea[@placeholder='Enter Notes for Chase Move.']").sendKeys("Moving chase from AID =" + firstAID + "to AID = " + secondAID);
        sleep(2000);
        $x("//span[contains(text(),'USE THIS ADDRESS')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Yes')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        if($x("//div[@class='grids-display']//app-basic-grid[@class='grids-display']//tr[1]//td[2]").isDisplayed()){
            String newchaseID = $x("//div[@class='grids-display']//app-basic-grid[@class='grids-display']//tr[1]//td[2]").getText();
            Log.info(newchaseID);
            if(firstchaseID.equals(newchaseID)) {
                Assert.fail("Chase Id not moved to new AID");
            }
        }else {
            logTestStepPass("Chase ID moved to new AID");
        }
        objLoginOut.logout();
    }
}
