package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendClinicalPendGrid_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ClinicalPend objPend = new ClinicalPend();
    Common objCommon = new Common();

    @Test(description = "Verify whether Pend grid displayed with equal number of pends with  status selected", groups = {"Clinical Pend"})
    public void PendClinicalTC3() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objPend.PendLink();
        $(RetrievalPendRepo.Clinical).click();
        logTestStep("Clicked on clinical link");
        sleep(2000);
        String startCount = $$(ClinicalPendRepo.startCount).filter(Condition.visible).first().getText();
        Log.info(startCount);
        $$(ClinicalPendRepo.startCount).filter(Condition.visible).first().click();
        sleep(5000);
        String totalCount=$(".text-right").getText();
        String[] arrSplit_3 = totalCount.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 1; i < 3; i++) {
            count = arrSplit_3[i];
            break;
        }
        System.out.println(count);
        assertText(startCount,count);
        sleep(2000);
        objLoginOut.logout();

    }

}
