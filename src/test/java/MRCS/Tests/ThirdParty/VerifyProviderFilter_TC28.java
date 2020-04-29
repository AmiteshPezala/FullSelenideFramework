package MRCS.Tests.ThirdParty;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyProviderFilter_TC28 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    ThirdParty objThirdParty = new ThirdParty();

    @Test(description = "Verify filter option for provider.", groups = {"Third party"})
    public void VerifyProviderFilter_TC28() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        Thread.sleep(2000);
        //objWait.implicitwait();
        objThirdParty.ThirdPartyLink();
        sleep(2000);
        String GridName=$x("//th[3]").getText();
        Log.info("Grid Name "+ GridName);
        if(GridName.equals("PROVIDER NAME")){
            logTestStepPass("Provider option present on the grid .");
        }else{
            logTestStepFail("Provider option not present on the grid.");
        }
        String ProviderName=$x("//tr[1]//td[3]//span[2]").getText();
        Log.info(ProviderName);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        String FilterName=$x("//span[contains(text(),'Provider Name')]").getText();
        Log.info(FilterName);
        if(FilterName.equals("Provider Name")){
            logTestStepPass("Filter name for provider name is present.");
        }else{
            logTestStepFail("Filter name for provider name is not present.");
        }
        /*$x("//span[contains(text(),'Provider Name')]").click();
        sleep(2000);
        $x("//input[@id='ProviderName']").setValue(ProviderName);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(3000);
        String NewProvider=$x("//tr[1]//td[3]//span[2]").getText();
        Log.info(NewProvider);
        if(ProviderName.equals(NewProvider)){
            logTestStepPass("Provider name filter is working properly.");
        }else{
            logTestStepFail("Provider name filter is not working properly.");
        }*/
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        objLoginOut.logout();
    }
}
