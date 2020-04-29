package MRCS.Tests.IVAHST;

import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RiskRepo.ProviderLookUpRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.CommonRisk.ENCasYes;
import static MRCS.Modules.CommonRisk.F2FasYes;
import static MRCS.Utils.Common.ClickElement;
import static java.lang.Thread.sleep;

public class HST_VerifyResultGridData_TC68 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk = new Risk();

    @Test(description = "Verify the result grid data", groups = {"IVA HST"})
    public void HST_VerifyResultGridData_TC68() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        Common.getUserAndAssignTo();
        ClickElement(ProjectsRepo.Measure, "Clicking on Measure");
        Log.info("Clicked on Measures tab");
        sleep(2000);
        ClickElement(MeasureRepo.HST, "Selecting HST");
        sleep(2000);
        ClickElement(ProjectsRepo.Update, "Clicking on Update");
        sleep(5000);
        Common.SelectChaseAndOpenChart();
        //Common.waitForPageLoadToComplete();
        objRisk.membervalidation();
        ENCasYes();
        F2FasYes();
        Common.ClickElement(ProviderLookUpRepo.BackwardButton,"Backward button");
        Common.ClickElement(ProviderLookUpRepo.MagnifyingIconInEncounter,"Magnifying Icon");
        String NPI= Common.getElementText(ProviderLookUpRepo.NPI,2);
        String FirstName= Common.getElementText(ProviderLookUpRepo.FirstName,2);
        String LastName= Common.getElementText(ProviderLookUpRepo.LastName,2);
        String Speciality= Common.getElementText(ProviderLookUpRepo.Specialty,2);
        String AID= Common.getElementText(ProviderLookUpRepo.AID,2);
        String Address1= Common.getElementText(ProviderLookUpRepo.Address1,2);
        String Address2= Common.getElementText(ProviderLookUpRepo.Address2,2);
        String City= Common.getElementText(ProviderLookUpRepo.City,2);
        String State= Common.getElementText(ProviderLookUpRepo.State,2);
        String Zip= Common.getElementText(ProviderLookUpRepo.Zip,2);
        String Phone= Common.getElementText(ProviderLookUpRepo.Phone,2);
        String Fax= Common.getElementText(ProviderLookUpRepo.Fax,2);
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
        if(Address1.equals("ADDRESS1"))
        {
            logTestStepPass("Address1 found");
        }
        else
        {
            logTestStepFail("Address1 not found");
            Assert.fail("Address1 not found");
        }
        if(Address2.equals("ADDRESS2"))
        {
            logTestStepPass("Address2 found");
        }
        else
        {
            logTestStepFail("Address2 not found");
            Assert.fail("Address2 not found");
        }
        if(City.equals("CITY"))
        {
            logTestStepPass("City found");
        }
        else
        {
            logTestStepFail("City not found");
            Assert.fail("City not found");
        }
        if(State.equals("STATE"))
        {
            logTestStepPass("State found");
        }
        else
        {
            logTestStepFail("State not found");
            Assert.fail("State not found");
        }
        if(Zip.equals("ZIP"))
        {
            logTestStepPass("Zip found");
        }
        else
        {
            logTestStepFail("Zip not found");
            Assert.fail("Zip not found");
        }
        if(Phone.equals("PHONE"))
        {
            logTestStepPass("Phone found");
        }
        else
        {
            logTestStepFail("Phone not found");
            Assert.fail("Phone not found");
        }
        if(Fax.equals("FAX"))
        {
            logTestStepPass("Fax found");
        }
        else
        {
            logTestStepFail("Fax not found");
            Assert.fail("Fax not found");
        }
        Common.ClickElement(ProviderLookUpRepo.CrossIcon,"Cancel");
        objLoginOut.logout();
    }
}
