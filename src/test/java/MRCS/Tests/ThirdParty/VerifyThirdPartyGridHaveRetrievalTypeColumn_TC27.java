package MRCS.Tests.ThirdParty;

import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyThirdPartyGridHaveRetrievalTypeColumn_TC27 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty=new ThirdParty();

    @Test(description = "Verify that third party grid contains Retrieval Type column.", groups = {"Third party"})
    public void VerifyThirdPartyGridHaveRetrievalTypeColumn_TC27() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        String ColumnName=$x("//th[17]").getText();
        Log.info(ColumnName);
        if(ColumnName.equals("RETRIEVAL TYPE")){
            logTestStepPass("Third party grid contains Retrieval Type column.");
        }else{
            logTestStepFail("Third party grid not contains Retrieval Type column.");
        }
        objLoginOut.logout();
    }
}
