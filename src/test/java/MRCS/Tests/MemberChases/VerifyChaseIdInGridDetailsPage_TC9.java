package MRCS.Tests.MemberChases;

import MRCS.Locators.CommonRepo;
import MRCS.Modules.LoginOut;
import MRCS.Modules.MRR.MemberChases;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;

public class VerifyChaseIdInGridDetailsPage_TC9 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Chase detail page is displayed", groups = {"Member Chases"})
    public void VerifyChaseIdInGridDetailsPage() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        MemberChases.NavigateToMemberChases();
        //$(CommonRepo.FirstChaseId).shouldBe(Condition.visible).click();
        MemberChases.MemberTab();
        sleep(3000);
        if($(CommonRepo.FirstChaseId).isDisplayed()){
        ClickElement(CommonRepo.FirstChaseId, "First Chase Record");
        sleep(1000);

        if($x("//div[contains(text(),'Chase Info')]").isDisplayed())
        {
            logTestStepPass("Chase detail page is displayed");
        }
        else
        {
            logTestStepFail("Chase detail page is not displayed");
            Assert.fail("Chase detail page is not displayed");
        }
        }else{
            logTestStep("Records are not available.");
        }
        objLoginOut.logout();
    }
}
