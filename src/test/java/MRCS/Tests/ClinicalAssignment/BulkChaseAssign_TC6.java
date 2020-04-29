package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class BulkChaseAssign_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();


    @Test(description = "Verify export functionality.", groups = {"Clinical Assignment"})
    public void BulkChaseAssign_TC6() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(10000);
        ClickElement(LoginOutRepo.UatAdmin,"UatAdmin");
        ClickElement($x("//div[@class='menu--item'][contains(.,'My Profile')]"),"My Profile");
        sleep(2000);
        String FirstName=$(By.id("firstName")).getValue();
        sleep(2000);
        String LastName=$(By.id("lastName")).getValue();
        sleep(2000);
        String User= FirstName+" "+LastName;
        sleep(2000);
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(4000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[contains(text(),'Status')]").click();
        sleep(2000);
        $x("//span[@class='ng-star-inserted'][contains(text(),'Data Entry')]").click();
        sleep(2000);
        $x("//span[contains(text(),'Update')]").click();
        sleep(5000);
        String AID1=$x("//tr[1]//td[2]").getText();
        sleep(2000);
        String AID2=$x("//tr[2]//td[2]").getText();
        sleep(2000);
        $x("//tr[1]//td[1]").click();
        sleep(2000);
        $x("//tr[2]//td[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Assign Chase(s)')]").click();
        sleep(2000);
        $x("//input[@id='assignToUsers']").setValue(User);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(1000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message,"Assigned Successfully.");
        Selenide.sleep(5000);
        String NewAID1=$x("//tr[1]//td[2]").getText();
        sleep(2000);
        String NewAID2=$x("//tr[2]//td[2]").getText();
        sleep(2000);
        if(AID1 != NewAID1){
            logTestStepPass("AID 1 assigned successfully and removed from grid.");
        }else{
            logTestStepFail("AID 1 not assigned and removed from grid.");
        }
        if(AID2 != NewAID2){
            logTestStepPass("AID 2 assigned successfully and removed from grid.");
        }else{
            logTestStepFail("AID 2 not assigned and removed from grid.");
        }
        objLoginOut.logout();
    }
}
