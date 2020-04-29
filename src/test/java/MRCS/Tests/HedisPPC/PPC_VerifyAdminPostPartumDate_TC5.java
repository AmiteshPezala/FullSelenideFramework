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

public class PPC_VerifyAdminPostPartumDate_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify admin postpartum date range is calculated as per admin delivery date", groups = {"Hedis PPC"} )
    public void PPC_VerifyAdminPostPartumDate() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep_ColorGreen("Verifying Admin DOD & postpartum range date");
        String DOD=$(HedisPPCRepo.DateOfEnrollmentDate2).getValue();
        logTestStep_ColorGreen("Date of Delivery (Admin):" + DOD);
        String postpartum=$(HedisPPCRepo.PostpartumStartDate).getText();
        logTestStep_ColorGreen("postpartum Start Date:" + postpartum);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(DOD));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 7);
        String newDate = sdf.format(cal.getTime());
        System.out.println(newDate);
        sleep(2000);
        if(postpartum.equals(newDate))
        {
            logTestStepPass("Admin postpartum date range is calculated as per admin delivery date");
        }else
        {
            logTestStepFail("Admin postpartum date range is not calculated as per admin delivery date");
            Assert.fail("Admin postpartum date range is not calculated as per admin delivery date");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
