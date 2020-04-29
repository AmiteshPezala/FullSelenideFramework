package MRCS.Tests.RiskForm;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class DiagnosticGrid_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify multiple VRC is allowed for single diagnostic line", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        RiskForm.ForEnableAdminToEditable();
        RiskForm.AddDiagnoses();
        RiskForm.EnterDiagnosticData();
        $x("//label[contains(text(),'VRC')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']").click();
        sleep(1000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(1000);
        $x("//label[contains(text(),'VRC')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']").click();
        sleep(1000);
        $x("(//p-dropdownitem//li//span)[2]").click();
        sleep(1000);
        $x("//h4[contains(text(),'ICD Information')]").click();
        sleep(2000);
        ElementsCollection MultipleVRC = $$x("//div[@class='selected ng-star-inserted']");
        int VRCCount=MultipleVRC.size();
        System.out.println(VRCCount);
        logTestStep("Diagnostic grid data is updated");
        if(VRCCount>1){
            logTestStep("Multiple VRC is allowed for single diagnostic line");
        }
        else{
            Assert.fail("Multiple VRC is not allowed for single diagnostic line");
        }
        sleep(3000);
        objLoginOut.logout();
    }
}
