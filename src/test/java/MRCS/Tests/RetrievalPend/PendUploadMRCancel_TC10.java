package MRCS.Tests.RetrievalPend;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.Pend.RetrievalPend;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;
//import sun.util.locale.provider.LocaleServiceProviderPool;

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class PendUploadMRCancel_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objProject = new Projects();
    RetrievalPend objPend = new RetrievalPend();

    @Test(description = "Verify weather uploaded document get cancel or not", groups = {"Retrieval Pend"})
    public void PendUploadMRCancel_TC10() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        sleep(2000);
        //objWait.implicitwait();
        Common.PopUp();
        objPend.PendLink();
        sleep(2000);
        $x("//a[@class='headerStatsItem ng-star-inserted']").click();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
        logTestStep("Selecting pend status option");
        sleep(2000);
        logTestStep("Selecting all status except closed ");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[4]/following::div[5]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::div[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='In Progress'])[1]/following::li[1]").click();
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
