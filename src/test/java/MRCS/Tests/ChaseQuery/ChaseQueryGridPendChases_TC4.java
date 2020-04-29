package MRCS.Tests.ChaseQuery;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class ChaseQueryGridPendChases_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject = new Projects();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that chase is pended or not ", groups = {"Chase Query"})
    public void ChaseQueryGridPendChases_TC4() throws Exception {

        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Verifying ChaseQuery filter Status ");
        objProject.ProjectsLink();
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        sleep(2000);
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        $(ProjectsRepo.Update).click();
        sleep(25000);
        logTestStep("Click on update button");
        //WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        $(".fa.fa-step-backward").click();
        sleep(5000);
        String status = $x("//tr[1]//td[16]").getText();
        Log.info(status);
        if (status.equals("Pended") || status.equals("Downloaded")) {
            System.out.println("In if loop");
           Projects.PendChaseIfPended();
        }
        //If the status is other than pended then go to else loop
        else{
            System.out.println("In Else loop");
            Projects.PendChaseElsePended();
        }
        objLoginOut.logout();
    }
}
