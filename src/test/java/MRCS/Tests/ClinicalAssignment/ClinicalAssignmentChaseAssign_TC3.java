package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.TestData.GlobalTestData;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ClinicalAssignmentChaseAssign_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();

    @Test(description = "Verify if address is assigned to user or not", groups = {"Clinical Assignment"})
    public void ClinicalAssignmentChaseAssign_TC3() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        String vaule = $x("//tr[1]//td[2]//div").getText();
        int num = Integer.parseInt(vaule);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Assign Chase(s)')]").click();
        String user = (GlobalTestData.UserName_Users).getUserId();//getting user name from test data
        sleep(2000);
        //selecting logged in user from drop down
        $x("//input[@id='assignToUsers']").sendKeys(user);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        logTestStep("Select logged in user from drop down");
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(10000);
        String vaule1 = $x("//tr[1]//td[2]//div").getText();
        sleep(1000);
        int num1 = Integer.parseInt(vaule1);
        Log.info(vaule1);
        logTestStep("Checking weather user get removed from the grid or not");
        if(num == num1)
        {
            logTestStep("Assign address not removed from the grid");
        }else{
            logTestStep("Assign address removed from the grid");
        }
    }
    }
