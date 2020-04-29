package MRCS.Tests.RiskForm;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

public class DiagnosticGrid_TC11 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify adding diagnostic line to  a new encounter", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        logTestStep("Adding Encounter");
        RiskForm.AddEncounter();
        logTestStep("Filling encounter details");
        RiskForm.ForEnableAdminToEditable();
        logTestStep("Adding Diagnoses");
        RiskForm.AddDiagnoses();
        logTestStep("Filling diagnoses details");
        RiskForm.EnterDiagnosticData();
        logTestStep("New diagnostic data line is added for an existing encounter");
        objLoginOut.logout();
    }
}
