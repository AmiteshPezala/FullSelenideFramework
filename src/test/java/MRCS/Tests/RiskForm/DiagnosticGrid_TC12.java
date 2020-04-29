package MRCS.Tests.RiskForm;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class DiagnosticGrid_TC12 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify adding diagnostic line to existing encounter", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        logTestStep("Filling encounter details");
        RiskForm.ForEnableAdminToEditable();
        logTestStep("Adding Diagnoses to existing encounter");
        RiskForm.AddDiagnoses();
        logTestStep("Filling diagnoses details");
        RiskForm.EnterDiagnosticData();
        $x("//div[contains(text(),'×')]").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
