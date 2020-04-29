package MRCS.Tests.ClinicalPend;

import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.ClinicalPend;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

//import sun.util.locale.provider.LocaleServiceProviderPool;

public class PendUploadMRCancel_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    ClinicalPend objPend = new ClinicalPend();

    @Test(description = "Verify whether uploaded document get cancel or not", groups = {"Clinical Pend"})
    public void PendUploadMRCancel_TC10() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        objPend.PendLink();
        ClinicalPend.navigateToClinicalPend();
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $(ClinicalPendRepo.pendStatus).click();
        logTestStep("Selecting pend status option");
        sleep(2000);
        logTestStep("Selecting all status except closed ");
        $(ClinicalPendRepo.newStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.inProgressStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.resolved).click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Closed'])[1]/following::span[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Request to Resolve'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        $x("//tr[1]//td[2]").click();
        sleep(4000);
        Common.UploadDocument();
        sleep(2000);
        String filename=$x("//div[@class='ui-fileupload-row ng-star-inserted']").getText();
        if(filename.contains("TEST.PDF")){
            logTestStep("File uploaded successfully");
            sleep(2000);
            $x("//span[contains(text(),'Cancel')]").click();
            if($x("//div[@class='ui-fileupload-row ng-star-inserted']").exists()){
                Assert.fail("Uploaded file not removed");
            }else{
                logTestStep("Uploaded file get removed successfully");
            }
        }else{
            Assert.fail("File not uploaded");
        }

        objLoginOut.logout();
    }
}
