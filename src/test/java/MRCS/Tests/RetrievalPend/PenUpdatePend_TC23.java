package MRCS.Tests.RetrievalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PenUpdatePend_TC23 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();
    Common objCommon = new Common();

    @Test(description = "Verify weather user can update the pend from update pend window", groups = {"Retrieval Pend"})
    public void PenUpdatePend_TC23() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        sleep(2000);
        $(RetrievalPendRepo.TotalPend).click();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[4]/following::div[5]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::div[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        logTestStep("clicked on update button");
        sleep(5000);
        $x("//tr[1]//td[2]").click();
        sleep(2000);
        $x("//app-button[@class='header-button show-status-change-button']//span[@class='ui-button-text ui-clickable'][contains(text(),'UPDATE PEND')]").click();
        sleep(2000);
        $x("(//div[@class='owner modal-label']//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//p-dropdownitem/li//span)[2]").click();
        //$x("(.//*[normalize-space(text()) and normalize-space(.)='Select Owner'])[2]/following::span[1]").click();
        sleep(2000);
        $x("//div[@class='assigneUser modal-label']//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("(//p-dropdownitem/li//span)[2]").click();
        sleep(2000);
        $x("//div[contains(text(),'Status')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("(//p-dropdownitem/li//span)[2]").click();
        sleep(2000);
        $x("//textarea[@id='pendNotes']").sendKeys("For testing purpose");
        sleep(2000);
        $x("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[@class='ui-button-text ui-clickable'][contains(text(),'UPDATE PEND')]").click();
        sleep(2000);
        String SuccessfulMessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(SuccessfulMessage,"Pend Updated successfully");
        sleep(2000);
        objLoginOut.logout();
    }
}