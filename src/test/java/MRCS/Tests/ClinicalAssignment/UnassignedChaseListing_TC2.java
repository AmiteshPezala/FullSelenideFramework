package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class UnassignedChaseListing_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();


    @Test(description = "Verify unassigned chase listing", groups = {"Clinical Assignment"})
    public void UnassignedChaseListing_TC2() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        sleep(10000);
        //objWait.implicitwait();
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        ClickElement(By.xpath("//div[@class='menu--item'][contains(.,'My Profile')]"),"My profile");
        sleep(2000);
        String FirstName = $(By.id("firstName")).getValue();
        sleep(1000);
        String LastName = $(By.id("lastName")).getValue();
        sleep(1000);
        String User = FirstName + " " + LastName;
        sleep(2000);
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        sleep(4000);
        String FirstChaseId=$x("//tr[1]//td[2]").getText();
        Log.info(FirstChaseId);
        sleep(2000);
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Assign Chase(s)')]").click();
        sleep(2000);
        $x("//input[@id='assignToUsers']").setValue(User);
        sleep(20000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(2000);
        String NewFirstChaseId=$x("//tr[1]//td[2]").getText();
        Log.info(NewFirstChaseId);
        if(FirstChaseId==NewFirstChaseId){
            logTestStepFail("Chase id not removed from the list .");
        }else{
            logTestStepPass("Chase id removed form the list");
        }
        objLoginOut.logout();

    }
}
