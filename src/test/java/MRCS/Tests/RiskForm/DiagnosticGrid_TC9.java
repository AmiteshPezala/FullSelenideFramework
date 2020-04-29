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

public class DiagnosticGrid_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify required fields on diagnostic grid", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        RiskForm.ForEnableAdminToEditable();
        RiskForm.AddDiagnoses();
        $x("//input[@id='pageNumber']").click();
        sleep(1000);
        $x("//input[@id='Icd']").click();
        sleep(1000);
        $x("((//label[contains(text(),'Provider')])[2]//following::label)[1]").click();
        sleep(3000);
        $x("//h4[contains(text(),'ICD Information')]").click();
        sleep(2000);
        logTestStep("Verifying Required field in diagnostic section");
        String ActualPageToolTip=$x("//div[contains(text(),'Enter a page number greater than 1')]").getText();
        sleep(1000);
        String ActualIcdToolTip=$x("//div[contains(text(),'ICD Code is required')]").getText();
        sleep(1000);
        String ActualProvideToolTip=$x("//div[contains(text(),'Provider is required')]").getText();
        sleep(1000);
        assertText(ActualPageToolTip,"Enter a page number greater than 1");
        assertText(ActualIcdToolTip,"ICD Code is required");
        assertText(ActualProvideToolTip,"Provider is required");
        sleep(5000);
        objLoginOut.logout();
    }
}
