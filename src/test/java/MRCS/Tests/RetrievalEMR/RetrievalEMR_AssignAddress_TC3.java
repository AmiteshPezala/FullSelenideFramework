package MRCS.Tests.RetrievalEMR;

import MRCS.Locators.RetrievalRepo.RetrievalPSRRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalEMR;
import MRCS.Modules.RetrievalModule.RetrievalPSR;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class RetrievalEMR_AssignAddress_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(description = "Verify whether chase is assigned to user", groups = {"Retrieval EMR"})
    public void RetrievalEMR_AssignAddress() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        //objWait.implicitwait();
        Common.PopUp();
        String User=Common.GetUserName();
        sleep(2000);
        RetrievalEMR.NavigateToEMR();
        Common.ClickElement(By.xpath("//tr[1]/td[20]"),"First EMR");
        $x("(//span[text()='Assign Address'])[2]").click();
        $(RetrievalPSRRepo.AssignToUser).sendKeys(User);
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        $(RetrievalPSRRepo.AssignToUser).sendKeys(Keys.ENTER);
        sleep(2000);
        Common.ClickElement(RetrievalPSRRepo.AssignButton,"Assign Button");
        logTestStep("Click on assign button");
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        Log.info(message);
        assertText(message,"Assigned Successfully.");
        objLoginOut.logout();
    }
}
