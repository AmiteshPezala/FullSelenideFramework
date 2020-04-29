package MRCS.Tests.RetrievalFT;

import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.Retrieval;
import MRCS.Modules.RetrievalModule.RetrievalFT;
import MRCS.Utils.*;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RetrievalFTGrid_TC1 extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Retrieval objRetrieval = new Retrieval();

    @Test(retryAnalyzer = Retry.class,description = "Verify if FT grid loads", groups = {"Retrieval FT"})
    public void RetrievalFTTestCase1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RetrievalFT.NavigateToFT();
        sleep(15000);
        logTestStep("Checking weather grid is loading or not");
        String value= Common.getElementText(RetrievalFTRepo.Count,60);//getting count form the stat .
        int num = Integer.parseInt(value);//coverting string into int
        if( num > 0){
            String text = $x("//tr[1]//td[16]").getText();
            assertText(text,"Field Tech");
            logTestStep("FT grid loaded successfully");
            Log.info("Grid loaded successfully");
        }else {
            Log.info("No records found ");
            logTestStep("No records found");
        }
        objLoginOut.logout();
    }
}
