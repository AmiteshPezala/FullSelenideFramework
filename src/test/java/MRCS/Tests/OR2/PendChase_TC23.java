package MRCS.Tests.OR2;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Measure;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class PendChase_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();
    Clinical objclinical = new Clinical();
    Measure objMeasure = new Measure();
    Common objcommon = new Common();

    @Test(description = "Pend chase functionality.", groups = {"OR2"})
    public void PendChase_TC23() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        sleep(2000);
        objclinical.ClinicalLink();
        $(ClinicalRepo.OR2).click();
        sleep(2000);
        $(CommonRepo.BackwardButton).click();
        sleep(2000);
        String Status = $x("//tr[1]//td[16]").getText();
        Log.info("Status : "+ Status);
        sleep(2000);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Pend Chase(s)')]").click();
        sleep(2000);
        if(Status.equals("Pended")){
            sleep(2000);
            $x("//label[contains(text(),'Assigned To')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//p-dropdownitem//li//span").click();
            sleep(2000);
            $x("//textarea[@id='notes']").setValue("For testing purpose");

        }else{
            sleep(2000);
            $x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
            sleep(2000);
            $x("//p-dropdownitem//li//span").click();
            sleep(2000);
            $x("//label[contains(text(),'Severity')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
            sleep(2000);
            $x("//p-dropdownitem//li").click();
            sleep(2000);
            $x("//textarea[@id='notes']").setValue("For testing purpose");
        }
        sleep(2000);
        $x("//span[contains(text(),'Save')]").click();
        sleep(2000);
        String Message =$x("//div[@class='ui-toast-detail']").getText();
        assertText(Message,"Pend saved successfully");
        Selenide.sleep(3000);
        objLoginOut.logout();
    }
}