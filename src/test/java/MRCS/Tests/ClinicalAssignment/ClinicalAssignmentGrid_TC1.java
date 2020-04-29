package MRCS.Tests.ClinicalAssignment;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ClinicalAssignmentGrid_TC1 extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Clinical objClinical = new Clinical();


    @Test(description = "Verify if assignment grid loads", groups = {"Clinical Assignment"})
    public void ClinicalAssignmentGrid_TC1() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        objClinical.ClinicalLink();
        $(ClinicalRepo.Assignment).click();
        logTestStep("Clicked on Assignment link");
        String AID = $x("//tr[1]//td[2]//div").getText();
        int num = Integer.parseInt(AID);
        if( num > 0 )
        {
            logTestStep("Grids Loaded Sucessfully");
            sleep(2000);
        }else{
            logTestStep("No records available");
        }
    }
}
