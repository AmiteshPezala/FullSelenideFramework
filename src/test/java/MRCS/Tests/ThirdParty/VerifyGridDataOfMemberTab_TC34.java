package MRCS.Tests.ThirdParty;

import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyGridDataOfMemberTab_TC34 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify gird data of member tab.", groups = {"Third party"})
    public void VerifyGridDataOfMemberTab_TC34() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        $(ThirdPartyRepo.FirstAID).click();
        logTestStep("Clicked on first AID");
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'CHASES AT THIS ADDRESS')]"));
        sleep(2000);
        $x("//div[contains(text(),'Members')]").click();
        logTestStep("Clicked on member tab to verify grid data.");
        sleep(2000);
        String Grid1=$x("//th[2]").getText();
        Log.info(Grid1);
        String Grid2=$x("//th[3]").getText();
        Log.info(Grid2);
        String Grid3=$x("//th[4]").getText();
        Log.info(Grid3);
        String Grid4=$x("//th[5]").getText();
        Log.info(Grid4);
        String Grid5=$x("//th[6]").getText();
        Log.info(Grid5);
        String Grid6=$x("//th[7]").getText();
        Log.info(Grid6);
        sleep(2000);

        if(Grid1.equals("MEMBER ID")){
            logTestStepPass("Member id is present on the grid .");
        }else{
            logTestStepFail("Member id is not present on the grid.");
        }
        if(Grid2.equals("NAME")){
            logTestStepPass("Name is present on the grid.");
        }else{
            logTestStepFail("Name is not present on the grid.");
        }
        if(Grid3.equals("DOB")){
            logTestStepPass("DOB is present on the grid");
        }else{
            logTestStepFail("DOB is not present on the grid.");
        }
        if(Grid4.equals("GENDER")){
            logTestStepPass("Gender is present on the grid.");
        }else{
            logTestStepFail("Gender is not present on the grid.");
        }
        if(Grid5.equals("CHASES")){
            logTestStepPass("Chases is present on the grid.");
        }else{
            logTestStepFail("Chases is not present on the grid.");
        }
        if(Grid6.equals("PROJECTS")){
            logTestStepPass("Projects is present on the grid.");
        }else{
            logTestStepFail("Projects is not present on the grid.");
        }
        objLoginOut.logout();
    }
}
