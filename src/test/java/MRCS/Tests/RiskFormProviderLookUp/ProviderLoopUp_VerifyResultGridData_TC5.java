package MRCS.Tests.RiskFormProviderLookUp;

import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.Clinical;
import MRCS.Modules.CommonRisk;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Modules.RiskModule.ProviderLookUp;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class ProviderLoopUp_VerifyResultGridData_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Risk objRisk = new Risk();

    @Test(description = "Verify the result grid data", groups = {"RiskForm_ProviderLookUp"})
    public void ProviderLoopUp_VerifyResultGridData() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        ProviderLookUp.NavigateToMagnifyingIcon();
        Common.ClickElement(ProviderLookUpRepo.MagnifyingIconInEncounter,"Magnifying Icon");
        String NPI=Common.getElementText(ProviderLookUpRepo.NPI,2);
        String FirstName=Common.getElementText(ProviderLookUpRepo.FirstName,2);
        Log.info(FirstName);
        String LastName=Common.getElementText(ProviderLookUpRepo.LastName,2);
        String Speciality=Common.getElementText(ProviderLookUpRepo.Specialty,2);
        Log.info(Speciality);
        String AID=Common.getElementText(ProviderLookUpRepo.AID,2);

        if(NPI.equals("NPI"))
        {
            logTestStepPass("National Provider Id found");
        }
        else
        {
            logTestStepFail("National Provider Id not found");
            Assert.fail("National Provider Id not found");
        }
        if(FirstName.equals("FIRST NAME"))
        {
            logTestStepPass("First Name found");
        }
        else
        {
            logTestStepFail("First Name  not found");
            Assert.fail("First Name  not found");
        }
        if(LastName.equals("LAST NAME"))
        {
            logTestStepPass("Last Name found");
        }
        else
        {
            logTestStepFail("Last Name  not found");
            Assert.fail("Last Name  not found");
        }
        if(Speciality.equals("SPECIALTY"))
        {
            logTestStepPass("Specialty found");
        }
        else
        {
            logTestStepFail("Specialty not found");
            Assert.fail("Specialty not found");
        }
        if(AID.equals("AID"))
        {
            logTestStepPass("AID found");
        }
        else
        {
            logTestStepFail("AID not found");
            Assert.fail("AID not found");
        }
        Common.ClickElement(ProviderLookUpRepo.CrossIcon,"Cancel");
        objLoginOut.logout();
    }
}
