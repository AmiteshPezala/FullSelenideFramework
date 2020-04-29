package MRCS.Tests.IVAHST;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Modules.Hedis.IVAHST.FilterByUserAndMeasure;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HST_VerifyAddedEncounterCanDelete_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify added encounter can delete", groups = {"IVA HST"} )
    public void HST_VerifyAddedEncounterCanDelete() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        FilterByUserAndMeasure();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        sleep(4000);
        String AddedBeforeAdd=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[3]").getText();
        sleep(2000);
        objRisk.AddEncounter();
        sleep(2000);
        $x("(//span[contains(text(),'00/00/0000 - 00/00/0000')]//following::div)[1]").click();
        sleep(2000);
        String CountAfterDelete=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[3]").getText();
        sleep(2000);
        assertText(CountAfterDelete,AddedBeforeAdd);
        logTestStepPass("New added row deleted successfully");
        sleep(2000);
        objLoginOut.logout();
    }
}
