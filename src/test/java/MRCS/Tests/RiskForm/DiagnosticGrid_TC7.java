package MRCS.Tests.RiskForm;

import MRCS.Modules.LoginOut;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Modules.Risk;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class DiagnosticGrid_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify HCC information", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        sleep(5000);
        if($x("//div[@class='hcc--item hcc--item__name']").exists()){
            logTestStep("HCC information is available");

        }else{
            Assert.fail("HCC information is not available");
        }
        objLoginOut.logout();
    }
}
