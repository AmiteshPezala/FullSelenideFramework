package MRCS.Tests.RiskForm;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class DiagnosticGrid_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify new diagnostic line data entry", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        RiskForm.ForEnableAdminToEditable();
        RiskForm.AddDiagnoses();
        RiskForm.EnterDiagnosticData();
        $x("//h4[contains(text(),'ICD Information')]").click();
        sleep(2000);
        String ActualIcd=$x("//span[@title='Z6832']").getText();
        sleep(1000);
        String ActualPageNumber=$x("//span[@title='3']").getText();
        sleep(1000);
        assertText(ActualIcd,"Z6832");
        logTestStep("Selected Icd code is displayed");
        assertText(ActualPageNumber,"3");
        logTestStep("Diagnostic grid data is updated");
        $x("//span[@class='selected__delete']").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
