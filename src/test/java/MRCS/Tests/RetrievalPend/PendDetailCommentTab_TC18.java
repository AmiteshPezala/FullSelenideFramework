package MRCS.Tests.RetrievalPend;

import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class PendDetailCommentTab_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    RetrievalPend objPend = new RetrievalPend();
    Common objCommon = new Common();

    @Test(description = "Verify weather comment is added in comment tab or not", groups = {"Retrieval Pend"})
    public void PendDetailCommentTab_TC18() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        Common.PopUp();
        //objWait.implicitwait();
        objPend.PendLink();
        sleep(2000);
        $(RetrievalPendRepo.TotalPend).click();
        sleep(5000);
        $x("//tr[1]//td[2]").click();
        sleep(5000);
        logTestStep("Open first pend id ");
        $x("//div[contains(text(),'Comments')]").click();
        logTestStep("Clicked on Comments tab");
        sleep(3000);
        String Date=$x("//span[contains(@class,'timestamp')]").getText();
        Log.info(Date);
        sleep(2000);
        logTestStep("Adding new comment");
        $x("//textarea[@placeholder='Type here to reply.']").sendKeys("For testing purpose");
        sleep(2000);
        $x("//span[contains(text(),'SEND MESSAGE')]").click();
        logTestStep("Checking weather comment is added or not");
        sleep(2000);
        String updatedDate=$x("//span[contains(@class,'timestamp')]").getText();
        Log.info(updatedDate);
        if(Date.equals(updatedDate)){
            Assert.fail("Comment not added");
        }else{
            logTestStep("New comment added sucessfully");
            /*String eventdateandtimestamp=$x("//span[contains(@class,'timestamp')]").getText();
            Log.info(eventdateandtimestamp);
            sleep(2000);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(". M/d/YY, hh:mm a");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            assertText(eventdateandtimestamp,dtf.format(now));*/
        }
        objLoginOut.logout();
    }

}
