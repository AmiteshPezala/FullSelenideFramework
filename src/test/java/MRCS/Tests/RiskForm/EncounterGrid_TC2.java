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

public class EncounterGrid_TC2 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify by default first encounter row is selected", groups = {"Encounter Grid"})
    public void EncounterGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        String ExpectedId=$x("//member-risk-encounter-grid//tr[1]//td[2]").getText();
        logTestStep("Expected Id:"+" "+ExpectedId);
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();",$x("(//input[@type='text'])[3]"));
        sleep(1000);
        String ClaimId=$x("(//input[@type='text'])[3]").getValue();
        logTestStep("Claim Id:"+" "+ClaimId);
        assertText(ExpectedId,ClaimId);
        sleep(2000);
        objLoginOut.logout();
    }
}
