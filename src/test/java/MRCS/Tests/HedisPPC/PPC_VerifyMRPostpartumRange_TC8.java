package MRCS.Tests.HedisPPC;
import MRCS.Locators.HedisRepo.HedisPPCRepo;
import MRCS.Modules.Hedis.HedisPPC;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class PPC_VerifyMRPostpartumRange_TC8 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();

    @Test( description = "Verify MR postpartum date range is as per MR DOD date", groups = {"Hedis PPC"} )
    public void PPC_VerifyPrenetalDateRange() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        HedisPPC.NavigateToPPC();
        objRisk.membervalidation();
        sleep(2000);
        logTestStep_ColorGreen("Verifying MR DOD & postpartum range date");
        $$(".control__delete").filter(Condition.visible).get(1).click();
        sleep(4000);
        String CurrentDate="10/07/2019";
        $(HedisPPCRepo.DODFromMedRecordsDate).setValue(CurrentDate);
        sleep(2000);
        $(HedisPPCRepo.DODFromMedRecordsPage).setValue("1");
        sleep(2000);
        ClickElement($x("//div[@class='coding-container']"),"Click to save");
        logTestStep_ColorGreen("Date of Delivery (Admin):" + CurrentDate);
        sleep(4000);
        String DODPostpartumDate=$(HedisPPCRepo.DODPostpartumStartDate).getText();
        logTestStep_ColorGreen("Postpartum Start Date:" + DODPostpartumDate);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(CurrentDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 7);
        String newDate = sdf.format(cal.getTime());
        System.out.println(newDate);
        sleep(2000);
        if(DODPostpartumDate.equals(newDate))
        {
            logTestStepPass("MR Postpartum date range is as per MR admin date");
        }else
        {
            logTestStepFail("MR Postpartum date range is not as per MR admin date");
            Assert.fail("MR Postpartum date range is not as per MR admin date");
        }
        sleep(2000);
        objLoginOut.logout();
    }
}
