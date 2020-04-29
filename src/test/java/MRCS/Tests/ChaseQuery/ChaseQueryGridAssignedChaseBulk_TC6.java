package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class ChaseQueryGridAssignedChaseBulk_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify weather chase is Assigned or not ", groups = {"Chase Query"})

    public void ChaseQueryGridAssignedChase_TC6() throws Exception {

        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Verifying ChaseQuery filter Status ");
        objProject.ProjectsLink();
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $(ProjectsRepo.Project).click();
        logTestStep("Click on filter project");
        sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        sleep(2000);
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        $(ProjectsRepo.Update).click();
        //WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        logTestStep("Click on update button");
        sleep(25000);
        logTestStep("Selecting multiple chases ");
        $x("//tr[1]//td[1]//p-tablecheckbox[1]").click();
        logTestStep("clicked on assign chase button");
        $x("//span[contains(text(),'Assign Chase(s)')]").click();
        $x("//input[@id='assignToUsers']").click();
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys("t");
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='assignToUsers']").sendKeys(Keys.ENTER);
        sleep(2000);
        $x("//span[contains(text(),'ASSIGN')]").click();
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message,"Assigned Successfully.");
    }

}