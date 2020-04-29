package MRCS.Tests.MRR;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class VerifyMemberValidationAsYes_TC5 extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();
    Risk objRisk=new Risk();

    @Test(description = "Member validation - Yes", groups = {"MRR"})
    public void VerifyMemberValidationAsYes() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        logTestStep("Clicking on Clinical link");
        String User=GetUserName();
        objClinical.ClinicalLink();
        ClickElement(ClinicalRepo.MRR,"Clicking on MRR");
        logTestStep("Clicked on MRR Link");
        waitForPageLoadToComplete();
        ClickElement(ProjectsRepo.Filter,"Filter");
        logTestStep("Clicking on Assigned To link");
        ClickElement(CommonRepo.AssignTo,"AssignedTo");
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(User);
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $(CommonRepo.AssignToUser).sendKeys(Keys.ENTER);
        sleep(2000);
        ClickElement(ProjectsRepo.Update,"Clicking on Update");
        sleep(10000);
        waitForPageLoadToComplete();
        SelectChaseAndOpenChart();
        objRisk.membervalidation();
        objLoginOut.logout();
    }
}
