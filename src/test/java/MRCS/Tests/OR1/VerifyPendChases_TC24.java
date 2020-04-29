package MRCS.Tests.OR1;
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
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyPendChases_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();

    @Test(description = "Verify that pend Code is associated with chase.", groups = {"OR1"})
    public void VerifyPendChase() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicking on Clinical link");
        objClinical.ClinicalLink();
        logTestStep("Clicking on OR1");
        ClickElement(ClinicalRepo.OR1,"Clicking on OR1");
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
        ClickElement($x("//span[contains(text(),'Pend Chase(s)')]"),"Pend Chase");
        if (status.equals(currentStatus)) {
            System.out.println("In if");
            sleep(2000);
           $x("//label[contains(text(),'Assigned To')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
           sleep(2000);
           $x("//p-dropdownitem//li//span").click();
           sleep(2000);
           $x("//textarea[@id='notes']").setValue("For Testing purpose");
        }
        //If the status is other than pended then go to else loop
        else{
            Thread.sleep(2000);
            $x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            Thread.sleep(2000);
            $x("//p-dropdownitem//li//span").click();
            Thread.sleep(2000);
            $x("//label[contains(text(),'Severity')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
            Thread.sleep(2000);
            $x("//p-dropdownitem//li").click();
            Thread.sleep(2000);
            $x("//textarea[@id='notes']").setValue("For testing purpose");
        }
        ClickElement(CommonRepo.Save,"Save");
        sleep(2000);
        String Message =$x("//div[@class='ui-toast-detail']").getText();
        assertText(Message,"Pend saved successfully");
        sleep(2000);
        objLoginOut.logout();
    }
}
