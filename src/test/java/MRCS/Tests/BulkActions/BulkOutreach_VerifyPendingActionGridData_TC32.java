package MRCS.Tests.BulkActions;

import MRCS.Locators.BulkActionsRepo;
import MRCS.Modules.BulkActionsModule.BulkOutreach;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class BulkOutreach_VerifyPendingActionGridData_TC32 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    BulkOutreach objBulkOutreach = new BulkOutreach();

    @Test(description = "Verify grid data of view pending action.", groups = {"Bulk Outreach"})
    public void BulkOutreach_VerifyPendingActionGridData_TC32() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(5000);
        objBulkOutreach.SubmitFaxRequest();
        sleep(2000);
        $(BulkActionsRepo.ViewPendingAction).click();
        sleep(2000);
        String GridData1=$x("(//tr//th)[1]").getText();
        Log.info("GridData1 = "+GridData1);
        String GridData2=$x("(//tr//th)[2]").getText();
        Log.info("GridData2 = "+GridData2);
        String GridData3=$x("(//tr//th)[3]").getText();
        Log.info("GridData3 = "+GridData3);
        String GridData4=$x("(//tr//th)[4]").getText();
        Log.info("GridData4 = "+GridData4);
        String GridData5=$x("(//tr//th)[5]").getText();
        Log.info("GridData5 = "+GridData5);
        String GridData6=$x("(//tr//th)[6]").getText();
        Log.info("GridData6 = "+GridData6);
        String GridData7=$x("(//tr//th)[7]").getText();
        Log.info("GridData7 = "+GridData7);
        String GridData8=$x("(//tr//th)[8]").getText();
        Log.info("GridData8 = "+GridData8);
        String GridData9=$x("(//tr//th)[9]").getText();
        Log.info("GridData9 = "+GridData9);
        if(GridData1.equals("JOB ID")){
            logTestStepPass("'Job Id' is present on the grid");
        }else{
            logTestStepFail("'Job Id' is not present on the grid");
        }
        if(GridData2.equals("PROJECTS")){
            logTestStepPass("'Projects' is present on the grid");
        }else{
            logTestStepFail("'Projects' is not present on the grid");
        }
        if(GridData3.equals("AIDS")){
            logTestStepPass("'AIDS' is present on the grid");
        }else{
            logTestStepFail("'AIDS' is not present on the grid");
        }
        if(GridData4.equals("CHASES")){
            logTestStepPass("' CHASES ' is present on the grid.");
        }else{
            logTestStepFail("' CHASES ' is not present on the grid.");
        }
        if(GridData5.equals("TYPE")){
            logTestStepPass("' TYPE ' is present on the grid.");
        }
        else{
            logTestStepFail("' TYPE ' is not present on the grid.");
        }
        if(GridData6.equals("SENDER")){
            logTestStepPass("' SENDER ' is present on the grid.");
        }else{
            logTestStepFail("' SENDER ' is not present on the grid.");
        }
        if(GridData7.equals("FROM")){
            logTestStepPass("' FROM ' is present on the grid.");
        }else{
            logTestStepFail("' FROM ' is not present on the grid.");
        }
        if(GridData8.equals("STATUS")){
            logTestStepPass("' STATUS ' is present on the grid.");
        }else{
            logTestStepFail("' STATUS ' is not present on the grid.");
        }if(GridData9.equals("REQUESTED")){
            logTestStepPass("' REQUESTED ' is present on the grid.");
        }else{
            logTestStepFail("' REQUESTED ' is not present on the grid.");
        }
        objLoginOut.logout();
    }
}
