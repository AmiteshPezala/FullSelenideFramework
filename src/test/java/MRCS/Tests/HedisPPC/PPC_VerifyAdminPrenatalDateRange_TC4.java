package MRCS.Tests.HedisPPC;
import MRCS.Locators.HedisRepo.HedisPPCRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class PPC_VerifyAdminPrenatalDateRange_TC4 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify admin prenatal date range is calculated as per admin delivery date", groups = {"Hedis PPC"} )
    public void PPC_VerifyAdminPrenatalDateRange() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep_ColorGreen("Verifying Admin DOD & Prenatal range date");
        String DOD=$(HedisPPCRepo.DateOfEnrollmentDate2).getValue();
        logTestStep_ColorGreen("Date of Delivery (Admin):" + DOD);
        String PrenatalDate=$(HedisPPCRepo.PrenatalStartDate).getText();
        logTestStep_ColorGreen("Prenatal Start Date:" + PrenatalDate);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(DOD));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, -280);
        String newDate = sdf.format(cal.getTime());
        System.out.println(newDate);
        sleep(2000);
        if(PrenatalDate.equals(newDate))
        {
            logTestStepPass("Admin prenatal date range is calculated as per admin delivery date");
        }else
        {
            logTestStepFail("Admin prenatal date range is not calculated as per admin delivery date");
            Assert.fail("Admin prenatal date range is not calculated as per admin delivery date");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
