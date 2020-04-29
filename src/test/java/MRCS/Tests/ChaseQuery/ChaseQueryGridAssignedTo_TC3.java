package MRCS.Tests.ChaseQuery;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class ChaseQueryGridAssignedTo_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify weather the chase is assigned or not", groups = {"Chase Query"})

    public void ChaseQueryGridAssignedTo_TC3() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        ClickElement(LoginOutRepo.UatAdmin,"Admin");
        sleep(5000);
        $x("//div[@class='menu--item'][contains(.,'My Profile')]").click();
        sleep(2000);
        String FirstName=$(By.id("firstName")).getValue();
        sleep(2000);
        String LastName=$(By.id("lastName")).getValue();
        sleep(2000);
        String User= FirstName+" "+LastName;
        sleep(2000);
        objProject.ProjectsLink();
        logTestStep("Click on project link");
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        $(ProjectsRepo.Project).click();
        logTestStep("Click on filter project");
        sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        sleep(2000);
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]").click();
        Thread.sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        Thread.sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        $(ProjectsRepo.Update).click();
        logTestStep("Click on update button");
        sleep(25000);
        String FirstChaseId= $x("//tr[1]//td[2]").getText();
        Log.info("FirstChaseId= " + FirstChaseId);
        $x("//tr[1]//td[1]").click();
        logTestStep("Selecting first chase ID");
        $x("//span[contains(text(),'Assign Chase(s)')]").click();
        logTestStep("Clicked on assign chase option");
        sleep(2000);
        $x("//input[@id='assignToUsers']").click();
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys("t");
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(3000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message,"Assigned Successfully.");
        sleep(5000);
        String NewChaseId= $x("//tr[1]//td[2]").getText();
        Log.info("NewChaseId= " + NewChaseId);

        logTestStep("Checking weather the chase id is assigned to new user or not ");
        if(FirstChaseId.equals(NewChaseId))
        {
            Assert.fail("Chase is not assigned to new user");
        }else{

            logTestStep("Chase is assigned successfully.");
        }
        objLoginOut.logout();
    }

}