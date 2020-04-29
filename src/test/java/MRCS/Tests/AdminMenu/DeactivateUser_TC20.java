package MRCS.Tests.AdminMenu;
import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Locators.AdminRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.AdminMenuModule.User.NavigateToUsers;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class DeactivateUser_TC20 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Deactivate user", groups = {"Admin Menu"})
    public void DeactivateUser ()throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        //sleep(5000);
        NavigateToUsers();
        String UserName="AutoQA."+Common.GetTimeStamp();
        String Password="Test@"+Common.GetTimeStamp();
        String GetUserCount=$(UsersRepo.UserCount).getText();
        int GetUserNameCountBefore=Integer.parseInt(GetUserCount);
        sleep(1000);
        $x("//span[contains(text(),'ADD USER')]").click();
        sleep(2000);
        $(UsersRepo.FirstNameTextField).sendKeys("Auto");
        sleep(1000);
        $(UsersRepo.LastNameTextField).sendKeys("QA");
        sleep(1000);
        $(UsersRepo.EmailTextField).sendKeys("nk@yopmail.com");
        sleep(1000);
        $(UsersRepo.LoginNameTextField).sendKeys(UserName);
        sleep(1000);
        ClickElement($x("//div[contains(text(),'Project Setup')]"),"Project Setup");
        ClickElement($x("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]"),"");
        ClickElement($x("//div[contains(text(),'Role Setup')]"),"Role Setup");
        ClickElement($x("(//div[@class='iconContainer'])[1]"),"Container");
        ClickElement($x("//span[@class='checkmark']"),"checkmark");
        ClickElement($x("//div[contains(text(),'Specialty Setup')]"),"Setup");
        waitForPageLoadToComplete();
        ClickElement($x("//span[contains(text(),'Select All')]"),"Select All");
        waitForPageLoadToComplete();
        ClickElement($x("//span[contains(text(),'CREATE USER')]"),"Create User");
        waitForPageLoadToComplete();
        sleep(15000);
        ClickElement($x("//div[contains(text(),'User Information')]"),"User Information");
        sleep(2000);
        String GetUserName=$(UsersRepo.LoginNameTextField).getValue();
        sleep(2000);
        System.out.println(GetUserName);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'SAVE USER')]"));
        sleep(2000);
        $x("//input[@id='newPassword']").sendKeys(Password);
        sleep(2000);
        $x("//input[@id='confirmNewPassword']").sendKeys(Password);
        sleep(2000);
        $x("//span[contains(text(),'SAVE USER')]").click();
        sleep(240000);
//        String getTosterMessage=$x("//div[contains(text(),'User: Auto QA has been saved')]").getText();
//        if(getTosterMessage.equals("User: Auto QA has been saved"))
//        {
//            logTestStepPass("User Created Successfully");
//        }else
//        {
//            logTestStepFail("User not created");
//            Assert.fail("User Not Created");
//        }
        logTestStep("Clicking on Users again");
        $(AdminRepo.User).click();
        sleep(5000);
        String GetUserCountAfterAddUser=$(UsersRepo.UserCount).getText();
        int GetUserNameAfter=Integer.parseInt(GetUserCountAfterAddUser);
        sleep(2000);
        if(GetUserNameAfter>GetUserNameCountBefore){
            logTestStepPass("New User Created successfully");
        }else{
            logTestStepFail("New User not Created");
        }
        logTestStep("Searching New Created User");
        sleep(60000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(60000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(20000);
        $(ProjectsRepo.Filter).click();
        sleep(3000);
        $x("//span[contains(text(),'Name')]").click();
        sleep(3000);
        $x("//input[@id='Name']").sendKeys("Auto QA");
        sleep(3000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        logTestStep("Deactivating User");
        if($x("//table/tbody/tr/td[1]").isDisplayed())
        {
            logTestStepPass("Created User found successfully");
            ClickElement($x("(//span[contains(@class,'fa fa-ellipsis-v ui-clickable ui-button-icon-left ng-star-inserted')])[1]"),"");
            ClickElement($x("//span[contains(text(),'Deactivate User')]"),"Deactivate User");
            ClickElement($x("//span[contains(text(),'Yes')]"),"Yes");
            //sleep(4000);
            waitForPageLoadToComplete();
        }else{
            logTestStepFail("Created user not found");
        }
        //sleep(2000);
        objLoginOut.logout();
        sleep(2000);
        logTestStep("Try to login with Deactivated user");
        $x("//input[@id='username']").sendKeys(UserName);
        sleep(1000);
        $x("//input[@id='password']").sendKeys(Password);
        sleep(1000);
        $x("//span[contains(text(),'LOGIN')]").click();
        sleep(10000);
        String ActualMsg=$x("//span[contains(text(),'Username or password not recognized')]").getText();
        if(ActualMsg.equals("Username or password not recognized"))
        {
            logTestStepPass("User get deactivated,deactivated user cannot login");
        }else
            {
            logTestStepFail("User get deactivated,deactivated user logged In");
            Assert.fail("User get deactivated,deactivated user logged In");
        }
    }
}
