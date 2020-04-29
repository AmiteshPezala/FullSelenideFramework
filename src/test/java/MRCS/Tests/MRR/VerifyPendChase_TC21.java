package MRCS.Tests.MRR;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;

public class VerifyPendChase_TC21 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();

    @Test(description = "Verify weather pend Code is associated with chase.", groups = {"MRR"})
    public void VerifyPendChase() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicking on Clinical link");
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR");
        ClickElement(ClinicalRepo.MRR,"Clicking on MRR");
        logTestStep("Clicking on first record");
        ClickElement(CommonRepo.FirstCheckbox,"Selecting first check box");
        waitForPageLoadToComplete();
        sleep(2000);
        String status = $x("//td[@class='hdvi-gridcol hdvi-gridcol-reportingStatusName ng-star-inserted']").getText();
       System.out.println(status);
        Log.info(status);
        //Checking weather the status is pended or not
        //If pended then go to IF loop
        String currentStatus = "Pended";
        if (status.equals(currentStatus)) {
            System.out.println("In if");
            ClickElement($x("//span[contains(text(),'Pend Chase(s)')]"),"Pend Chase");
            $x("//label[contains(text(),'Status')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//label[contains(text(),'Status')]//following::span[contains(text(),'New')]").click();
            sleep(2000);
            $x("//label[contains(text(),'Assigned To')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//p-dropdownitem//li//span").click();
            sleep(2000);
            $x("//textarea[@id='notes']").sendKeys("For Testing purpose","Enter Text");
            ClickElement(CommonRepo.Save,"Save");
            sleep(2000);
            //sleep(6000);
            String Message =$x("//div[@class='ui-toast-detail']").getText();
            assertText(Message,"Pend saved successfully");
        }
        //If the status is other than pended then go to else loop
        else{
            System.out.println("In else");
            //ClickElement($x("//div[@class='grids-display']//tr[1]//td[1]//p-tablecheckbox[1]"),"");
            ClickElement($x("//span[contains(text(),'Pend Chase(s)')]"),"Pend Chase");
            sleep(2000);
            ClickElement($x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']"),"Pend code");
            sleep(2000);
            ClickElement($x("//p-dropdownitem//li//span"),"");
            sleep(2000);
            ClearAndSendKeys(By.xpath("//textarea[@id='notes']"),"For Testing notes","Notes");
            ClickElement(CommonRepo.Save,"Save");
            sleep(2000);
            String Message =$x("//div[@class='ui-toast-detail']").getText();
            assertText(Message,"Pend saved successfully");
        }
        objLoginOut.logout();
    }
}
