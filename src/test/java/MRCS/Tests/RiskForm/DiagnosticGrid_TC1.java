package MRCS.Tests.RiskForm;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class DiagnosticGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify diagnostic  types", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        String Encounters=$x("//h3[contains(text(),'Diagnoses')]").getText();
        System.out.println(Encounters);
        sleep(2000);
        String ActTotal=$x("(//span[contains(text(),'Total')])[2]").getText();
        String ActAdmin=$x("(//span[contains(text(),'Admin')])[2]").getText();
        String ActAdded=$x("(//span[contains(text(),'Added')])[2]").getText();
        if(Encounters.equals("DIAGNOSES")){
            assertText(ActTotal,"Total");
            logTestStep("Verified Diagnoses Total");
            assertText(ActAdmin,"Admin");
            logTestStep("Verified Diagnoses Admin");
            assertText(ActAdded,"Added");
            logTestStep("Verified Diagnoses Added");
        }else{
            Assert.fail("No Diagnoses types found");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
