package MRCS.Tests.ApproveChaseMove;

import MRCS.Locators.ApprovalCenterRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.ApprovalCenter;
import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyGridData_TC1 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ApprovalCenter objApprovalCenter=new ApprovalCenter();

    @Test(description = "Verify grid data", groups = {"Approve Chase Move"})
    public void VerifyGridData_TC1() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        sleep(5000);
        String ChaseId=$x("//th[2]").getText();
        Log.info(ChaseId);
        sleep(2000);
        String Project=$x("//th[3]").getText();
        Log.info(Project);
        String Measure=$x("//th[4]").getText();
        Log.info(Measure);
        String OriginalAid=$x("//th[5]").getText();
        Log.info(OriginalAid);
        String DestinationAid=$x("//th[6]").getText();
        Log.info(DestinationAid);
        String Notes=$x("//th[7]").getText();
        Log.info(Notes);
        String RequestedBy=$x("//th[8]").getText();
        Log.info(RequestedBy);
        String pursuitRequestedBy=$x("//th[9]").getText();
        Log.info(pursuitRequestedBy);
        String DateRequested=$x("//th[10]").getText();
        Log.info(DateRequested);
        if(ChaseId.equals("CHASE ID")){
            logTestStepPass("Chase Id field is present on the grid.");
        }else{
            logTestStepFail("Chase Id field is not present on the grid.");
        }
        if(Project.equals("PROJECT")){
            logTestStepPass("Project field is present on the grid.");
        }else{
            logTestStepFail("Project field is not present on the grid.");
        }
        if(Measure.equals("MEASURE")){
            logTestStepPass("Measure field is present on the grid.");
        }else{
            logTestStepFail("Measure field is not present on the grid.");
        }
        if(OriginalAid.equals("ORIGINAL AID")){
            logTestStepPass("Original AID field is present on the grid.");
        }else{
            logTestStepFail("Original AID field is not present on the grid.");
        }
        if(DestinationAid.equals("DESTINATION AID")){
            logTestStepPass("Destination AID field is present on the grid.");
        }else{
            logTestStepFail("Destination AID field is not present on the grid.");
        }
        if(Notes.equals("NOTES")){
            logTestStepPass("Notes field is present on the grid.");
        }else{
            logTestStepFail("Notes field is not present on the grid.");
        }
        if(RequestedBy.equals("REQUESTED BY")){
            logTestStepPass("Requested By field is present on the grid.");
        }else{
            logTestStepFail("Requested By field is not present on the grid.");
        }
        if(pursuitRequestedBy.equals("PURSUIT REQUESTED BY")){
            logTestStepPass("Pursuit Requested by field is present on the grid.");
        }else{
            logTestStepFail("Pursuit Requested by field is not present on the grid.");
        }
        if(DateRequested.equals("DATE REQUESTED")){
            logTestStepPass("Date requested field is present on the grid.");
        }else{
            logTestStepFail("Date requested field is not present on the grid.");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}