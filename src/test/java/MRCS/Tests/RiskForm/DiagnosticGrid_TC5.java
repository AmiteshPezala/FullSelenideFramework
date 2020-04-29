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
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class DiagnosticGrid_TC5 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Projects objProject=new Projects();
    WaitTool objWait= new WaitTool();
    Risk RiskForm=new Risk();

    @Test(description = "Verify diagnostic code delete", groups = {"Diagnostic Grid"})
    public void DiagnosticGrid() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        RiskForm.getUser();
        RiskForm.ForEnableAdminToEditable();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();",$x("//h3[contains(text(),'Diagnoses')]"));
        String AddedBeforeAdd=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[6]").getText();
        sleep(2000);
        int AddedCount=Integer.parseInt(AddedBeforeAdd);
        logTestStep("Added count before click on Add button:"+" "+AddedCount);
        $x("//div[@title='Add a new diagnosis']").click();
        sleep(2000);
        String AddedAfterAdd=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[6]").getText();
        int AddedCountAfterAdd=Integer.parseInt(AddedAfterAdd);
        logTestStep("Added count after click on Add button:"+" "+AddedCountAfterAdd);
        sleep(2000);
        if(AddedCountAfterAdd>AddedCount){
            logTestStep("New row added in diagnosis grid");
        }else{
            Assert.fail("New row not added in diagnosis grid");
        }
        $x("//div[contains(text(),'×')]").click();
        sleep(2000);
        String CountAfterDelete=$x("(//span[@class='font-size-2 bold ng-star-inserted'])[6]").getText();
        sleep(2000);
        assertText(CountAfterDelete,AddedBeforeAdd);
        logTestStep("New added row deleted successfully");
        objLoginOut.logout();
    }
}
