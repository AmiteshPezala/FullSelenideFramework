package MRCS.Tests.MRQA;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.MRQA;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class MRQAGrid_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval= new Retrieval();

    @Test(description = "Verify if MRQA Grid loads",groups = {"MRQA"})
    public void VerifyMRQAGridLoads() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MRQA.NavigateToDocQA();
        sleep(2000);
        logTestStep("Verifying MRQA Grid loads");
        String count=$x("//span[@class='activeStat']").getText();
        int num=Integer.parseInt(count);
        System.out.println(num);
        if(num>0){
            String field=$x("//th[@title='Measure']").getText();
            sleep(2000);
            assertText(field,"Measure ");
            logTestStep("MRQA grid loaded successfully");
        }
        else {
            Log.info("no record found");
            logTestStep("No Record found");
        }
        objLoginOut.logout();
    }
}
