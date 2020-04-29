package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.GetUserName;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class RetrievalPSRAssignToUnassignedUser_TC15 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();


    @Test(description = "Verify weather chase is assigned to unassigned user", groups = {"Retrieval PSR"})
    public void RetrievalPSRAssignToUnassignedUser_TC15() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        //objWait.implicitwait();
        Common.PopUp();
        String User=GetUserName();
        sleep(2000);
        //objWait.implicitwait();
        RetrievalPSR.NavigateToPSR();
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]").click();
        sleep(2000);
        $(RetrievalPSRRepo.AssignedToUser).click();
        sleep(2000);
        $(RetrievalPSRRepo.AssignedToUser).sendKeys(User);
        sleep(2000);
        $(RetrievalPSRRepo.AssignedToUser).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(RetrievalPSRRepo.AssignedToUser).sendKeys(Keys.ENTER);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(3000);
        String AID=$x("//tr[1]//td[1]").getText();
       Log.info(AID);
        sleep(2000);
        $x("//tr[1]//td[1]").click();
        sleep(2000);
        $(RetrievalPSRRepo.AssignAddress).click();
        sleep(3000);
        $(RetrievalPSRRepo.AssignToUser).click();
        sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys("unassigned");
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ENTER);
        sleep(2000);
        $(RetrievalPSRRepo.AssignButton).click();
        logTestStep("Click on assign button");
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message,"Assigned Successfully.");
        sleep(4000);
        String CurrentAID=$x("//tr[1]//td[1]").getText();
        Log.info(CurrentAID);
        sleep(2000);
        if(AID != CurrentAID){
            logTestStep("Address id get sucessfully assigned form " + " " + User + " " + "to Unassigned user");
        }else{
            Assert.fail("Address id not assigned form " + " " + User + " " + "to Unassigned user");
        }
        objLoginOut.logout();

    }
}
