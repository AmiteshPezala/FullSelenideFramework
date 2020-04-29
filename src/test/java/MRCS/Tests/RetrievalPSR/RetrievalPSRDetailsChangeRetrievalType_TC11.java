package MRCS.Tests.RetrievalPSR;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RetrievalPSRDetailsChangeRetrievalType_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify weather retrieval type is changed or not. ", groups = {"Retrieval PSR"})
    public void RetrievalPSRChangeRetrievalType_TC11() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        RetrievalPSR.NavigateToPSR();
        String AID = $(RetrievalRepo.AIDFirstRow).getText();
        logTestStep("Clicked on address id");
        $(RetrievalRepo.AIDFirstRow).click();
        sleep(2000);
        logTestStep("Changing retrieval method");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='CHANGE RETRIEVAL METHOD'])[1]/following::span[1]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='To Field Tech'])[1]/following::span[1]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Notes'])[1]/following::textarea[1]").sendKeys("test");
        sleep(2000);
        $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'ASSIGN')]").click();
        sleep(5000);
        logTestStep("Checking weather address id is removed from the grid or not");
        $(RetrievalRepo.PSR).click();
        sleep(10000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'AID')]").click();
        sleep(2000);
        $x("(//label[contains(text(),'AID')])[2]//following::input").setValue(AID);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        if($(RetrievalRepo.AIDFirstRow).isDisplayed()){
            Assert.fail("Address is not removed from the list");
        }
        else{
            logTestStep("Address is removed from the list");
        }
        objLoginOut.logout();
    }
}