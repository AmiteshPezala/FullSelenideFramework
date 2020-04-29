package MRCS.Tests.RetrievalAssignment;

import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalAssignment_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify if address is assigned to user or not", groups = {"Retrieval Assignment"})
    public void RetrievalAssignmentTC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicked on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        $(RetrievalRepo.Assignment).click();
        sleep(2000);
        logTestStep("Clicked on Assignment link");
        String vaule = $x("//tr[1]//td[2]").getText();
        Log.info(vaule);
        sleep(2000);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Assign Address')]").click();
        logTestStep("Clicked on assign address link");
       // String user = (GlobalTestData.UserName_Users).getUserId();//getting user name from test data
        sleep(2000);
        //selecting logged in user from drop down
        $x("//input[@id='assignToUsers']").sendKeys("te");
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        logTestStep("Select logged in user from drop down");
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(5000);
        String vaule1 = $x("//tr[1]//td[2]").getText();
        Log.info(vaule1);
        sleep(2000);
        logTestStep("Checking weather user get removed from the grid or not");
        if(vaule == vaule1)
        {
            Assert.fail("Assign address not removed from the grid");
        }else{
            logTestStep("Assign address removed from the grid");
        }
    }
}
