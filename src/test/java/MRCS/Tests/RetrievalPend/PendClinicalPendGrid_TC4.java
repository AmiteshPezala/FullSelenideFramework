package MRCS.Tests.RetrievalPend;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendClinicalPendGrid_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Matches the stat count which is selected", groups = {"Retrieval Pend"})
    public void PendClinicalTC4() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        $(RetrievalPendRepo.Clinical).click();
        logTestStep("Clicked on Clinical Link");
        sleep(2000);
        String TotalStats = $x("//span[contains(@class,'bold')]").getText();
        logTestStep("Total Stats Count" + " " + "="+TotalStats);
        sleep(2000);
        $x("//span[contains(@class,'bold')]").click();
        sleep(4000);
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        String actualCount = $x("//*[@class='text-right']").getText();
        System.out.println(actualCount);
        String[] arrSplit_3 = actualCount.split("\\s");    // Splitting the line "Top -- records"
        String ActualCount = null;
        for (int i = 1; i < 2; i++) {
            ActualCount = arrSplit_3[i]; // getting the middle word
            logTestStep("Actual Stats Count" + " " + "="+ActualCount);
            break;
        }
        assertText(ActualCount,TotalStats);
        objLoginOut.logout();
    }
}
