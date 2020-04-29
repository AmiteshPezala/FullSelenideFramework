package MRCS.Tests.ClinicalPend;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PendOwnershipChange_TC24 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ClinicalPend objPend = new ClinicalPend();

    @Test(description = "Verify Clinical Pend ownership change > message", groups = {"Clinical Pend"})
    public void PendOwnershipChange() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        //objWait.implicitwait();
        objPend.PendLink();
        ClinicalPend.navigateToClinicalPend();
        Common.ClickElement(ProjectsRepo.Filter,"Filter Button");
        Common.ClickElement(RetrievalPendRepo.PendStatus,"Pend Status");
        Common.ClickElement(ClinicalPendRepo.pendStatus,"New Pend Status");
        Common.ClickElement(RetrievalPendRepo.InProgressPendStatus,"In Progress Pend Status");
        Common.ClickElement(ProjectsRepo.Update,"Update Button");
        Common.waitForPageLoadToComplete();
        sleep(10000);
        Common.ClickElement(RetrievalPendRepo.FirstPend, "First Pend");
        $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
        Common.ClickElement(RetrievalPendRepo.UpdatePend, "Update Pend");
        sleep(4000);
        Common.ClickElement(RetrievalPendRepo.StatusDropdown,"Status dropdown");
        sleep(2000);
        Common.ClickElement(RetrievalPendRepo.ResolvedStatus,"Status dropdown");
        sleep(1000);
        String getMsg=Common.getElementText(By.xpath("//span[contains(text(),'Are you sure you')]"),5);
        System.out.println(getMsg);
        if (getMsg.equals("ARE YOU SURE YOU DON'T WANT TO CHANGE OWNERSHIP OF THIS PEND?"))
        {
            logTestStepPass("Are you sure you don't want to change ownership of this Pend? message is displaying");
        }
        else
        {
            logTestStepFail("Are you sure you don't want to change ownership of this Pend? message is not displaying");
            Assert.fail("Are you sure you don't want to change ownership of this Pend? message is not displaying");
        }
        Common.ClickElement(RetrievalPendRepo.SecondCancelIcon,"Cancel Icon");
        Common.ClickElement(RetrievalPendRepo.FirstCancelIcon,"Cancel Icon");
        objLoginOut.logout();
    }
}
