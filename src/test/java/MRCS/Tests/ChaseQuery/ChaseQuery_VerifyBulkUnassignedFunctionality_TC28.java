package MRCS.Tests.ChaseQuery;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.ChaseQuery;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class ChaseQuery_VerifyBulkUnassignedFunctionality_TC28 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();
    ChaseQuery objChaseQuery=new ChaseQuery();

    @Test(description = "Verify bulk functionality of unassigned button.", groups = {"Chase Query"})
    public void ChaseQuery_VerifyBulkUnassignedFunctionality_TC28() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Selenide.sleep(2000);
        //objWait.implicitwait();
        ClickElement(LoginOutRepo.UatAdmin, "Admin");
        Selenide.sleep(5000);
        $x("//div[@class='menu--item'][contains(.,'My Profile')]").click();
        Selenide.sleep(2000);
        String FirstName = $(By.id("firstName")).getValue();
        Selenide.sleep(2000);
        String LastName = $(By.id("lastName")).getValue();
        Selenide.sleep(2000);
        String User = FirstName + " " + LastName;
        Selenide.sleep(2000);
        objProject.ProjectsLink();
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]").click();
        Thread.sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        Thread.sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        $(ProjectsRepo.Update).click();
        logTestStep("Click on update button");
        Selenide.sleep(25000);
        $x("//tr[1]//td[1]").click();
        $x("//tr[2]//td[1]").click();
        logTestStep("Selecting bulk chase ID's");
        $x("//span[contains(text(),'Unassign Chase(s)')]").click();
        logTestStep("Clicked on unassign chase button.");
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message, "Unassigned Successfully.");
        Selenide.sleep(5000);
        objLoginOut.logout();
    }
}
