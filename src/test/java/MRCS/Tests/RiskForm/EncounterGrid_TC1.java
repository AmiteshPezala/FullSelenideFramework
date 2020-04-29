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

public class EncounterGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify encounter types", groups = {"Encounter Grid"})
    public void EncounterGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        String Encounters=$x("//h3[contains(text(),'Encounters')]").getText();
        sleep(2000);
        String ActTotal=$x("(//span[contains(text(),'Total')])[1]").getText();
        String ActAdmin=$x("(//span[contains(text(),'Admin')])[1]").getText();
        String ActAdded=$x("(//span[contains(text(),'Added')])[1]").getText();
        if(Encounters.equals("ENCOUNTERS")){
            assertText(ActTotal,"Total");
            logTestStep("Verified Encounter Total");
            assertText(ActAdmin,"Admin");
            logTestStep("Verified Encounter Admin");
            assertText(ActAdded,"Added");
            logTestStep("Verified Encounter Added");
        }else{
            Assert.fail("No encounter types found");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
