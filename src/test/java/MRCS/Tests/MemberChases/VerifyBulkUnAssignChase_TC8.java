package MRCS.Tests.MemberChases;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MRRRepo.MemberChasesRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MRR.MemberChases;
import MRCS.Modules.MemberCentric.Members;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class VerifyBulkUnAssignChase_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Verify un assign chase bulk action", groups = {"Member Chases"})
    public void VerifyBulkUnAssignChase() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MemberChases.NavigateToMemberChases();
        sleep(2000);
        MemberChases.MemberTab();
        sleep(5000);
        if ($(CommonRepo.FirstChaseId).isDisplayed() && $(CommonRepo.SecondChaseId).isDisplayed()) {
            String FirstStatus = $x("//tr[1]//td[9]").getText();
            Log.info("FirstStatus =" + FirstStatus);
            ElementsCollection CheckboxCount = $$x("//tr//td//p-tablecheckbox");
            int Count = CheckboxCount.size();
            for (int i = 1; i <= Count-1; i++) {
                String SecondStatus = $x("//tr[" + (i + 1) + "]//td[9]").getText();
                Log.info("SecondStatus =" + SecondStatus);
                sleep(2000);
                if (FirstStatus.equals(SecondStatus)) {
                    sleep(2000);
                    $x("//tr[1]//td[9]").click();
                    sleep(2000);
                    $x("//tr[" + (i+1) + "]//td[1]//p-tablecheckbox[1]").click();
                    sleep(2000);
                    Common.ClickElement(MemberChasesRepo.AssignChaseButton,"Assign Member Button");
                    sleep(2000);
                    Members.AssignChaseIdToUser();
                    sleep(2000);
                    logTestStepPass("Chase get assigned to new user");
                    $x("//tr[1]//td[9]").click();
                    sleep(2000);
                    $x("//tr[" + (i+1) + "]//td[1]//p-tablecheckbox[1]").click();
                    sleep(2000);
                    Common.ClickElement(MemberChasesRepo.UnAssignChase,"Un Assign Chases");
                    sleep(2000);
                    logTestStepPass("Unassigned successfully.");
                    break;
                } else {
                    Log.info("Status not matched ");
                }
            }
            Log.info("Status not matched ");
        }
        else {
            if ($(CommonRepo.FirstChaseId).isDisplayed()) {
                $(CommonRepo.FirstChaseId).click();
                Common.ClickElement(MemberChasesRepo.AssignChaseButton, "Assign Member Button");
                sleep(2000);
                Members.AssignChaseIdToUser();
                sleep(2000);
                logTestStepPass("Chase get assigned to new user");
                $(CommonRepo.FirstChaseId).click();
                sleep(2000);
                Common.ClickElement(MemberChasesRepo.UnAssignChase, "Un Assign Chases");
                sleep(2000);
                logTestStepPass("Unassigned successfully.");
            } else {
                logTestStep("Records not available.");
            }
        }
        logTestStep("Staus not matched.");
        objLoginOut.logout();
    }
}
