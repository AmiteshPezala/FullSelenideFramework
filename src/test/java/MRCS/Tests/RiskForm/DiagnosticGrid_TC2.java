package MRCS.Tests.RiskForm;

import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class DiagnosticGrid_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify by default first diagnostic row is selected", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        sleep(2000);
        String ExpectedIDC=$x("//member-risk-diagnoses-grid//tr[1]//td[4]").getText();
        logTestStep("Expected IDC:"+" "+ExpectedIDC);
        js.executeScript("arguments[0].scrollIntoView();",$x(".//*[@id='Icd']"));
        sleep(1000);
        String ICD=$x(".//*[@id='Icd']").getValue();
        logTestStep("IDC:"+" "+ICD);
        assertText(ExpectedIDC,ICD);
        sleep(2000);
        objLoginOut.logout();
    }
}
