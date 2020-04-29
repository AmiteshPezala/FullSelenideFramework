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

import static MRCS.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class DiagnosticGrid_TC3 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify diagnostic grid data", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();",$x("//h3[contains(text(),'Diagnoses')]"));
        sleep(2000);
        String Data=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[4]").getText();
        int num=Integer.parseInt(Data);
        sleep(2000);
        System.out.println(num);
        if(num>0){
            String ExpectedId=$x("//member-risk-diagnoses-grid//tr[1]//td[4]").getText();
            logTestStep("Expected Id:"+" "+ExpectedId);
            js.executeScript("arguments[0].scrollIntoView();",$x(".//*[@id='Icd']"));
            sleep(1000);
            String IDC=$x(".//*[@id='Icd']").getValue();
            logTestStep("IDC:"+" "+IDC);
            assertText(ExpectedId,IDC);
        }
        else{
            Assert.fail("Diagnostic grid data not found");
        }
        objLoginOut.logout();
    }
}
