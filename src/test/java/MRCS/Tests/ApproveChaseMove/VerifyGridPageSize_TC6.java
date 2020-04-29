package MRCS.Tests.ApproveChaseMove;

import MRCS.Locators.ApprovalCenterRepo;
import MRCS.Modules.ApprovalCenter;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyGridPageSize_TC6 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    ApprovalCenter objApprovalCenter = new ApprovalCenter();

    @Test(description = "Verify grid page size.", groups = {"Approve Chase Move"})
    public void VerifyGridPageSize_TC6() throws Exception {

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        //objWait.implicitwait();
        objApprovalCenter.ApprovalChaseMoveLink();
        sleep(2000);
        $(ApprovalCenterRepo.ApproveChaseMove).click();
        sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[@class='page-size-text ng-star-inserted']"));
        sleep(2000);
        $x("(//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]").click();
        sleep(2000);
        String PageSize1= $x("//p-dropdownitem[1]//li[1]").getText();
        Log.info(PageSize1);
        assertText(PageSize1, "10");
        String PageSize2= $x("//p-dropdownitem[2]//li[1]").getText();
        Log.info(PageSize2);
        assertText(PageSize2, "25");
        String PageSize3 =$x("//p-dropdownitem[3]//li[1]").getText();
        Log.info(PageSize3);
        assertText(PageSize3, "50");
        String PageSize4= $x("//p-dropdownitem[4]//li[1]").getText();
        Log.info(PageSize4);
        assertText(PageSize4, "100");
        logTestStep("Page size change option available as 10,25,50,100.");
        objLoginOut.logout();
    }
}
