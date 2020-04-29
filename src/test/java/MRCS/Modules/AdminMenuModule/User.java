package MRCS.Modules.AdminMenuModule;
import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Locators.AdminRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class User {
    public static void NavigateToUsers() throws Exception {
        sleep(5000);
        logTestStep("Clicking on Navigation bar");
        ClickElement(LoginOutRepo.NavigationBar,"Navigation bar ");
        Log.info("Clicked on Navigation bar");
        logTestStep("Clicking on Admin Link");
        ClickElement(AdminRepo.Admin,"Admin");
        Log.info("Clicked on Admin");
        logTestStep("Clicking on User");
        ClickElement(AdminRepo.User,"User");
        waitForPageLoadToComplete();
        sleep(2000);
    }
    public static void AddUser() throws Exception {
        String UserName = "AutoQA." + Common.GetTimeStamp();
        System.out.println(UserName);
        sleep(1000);
        ClickElement(UsersRepo.AddUserButton, "Add user");
        $(UsersRepo.FirstNameTextField).sendKeys("Auto");
        sleep(1000);
        $(UsersRepo.LastNameTextField).sendKeys("QA");
        sleep(1000);
        $(UsersRepo.EmailTextField).sendKeys("nk@yopmail.com");
        sleep(1000);
        $(UsersRepo.LoginNameTextField).sendKeys(UserName);
        sleep(1000);
    }
    public static void UserSetup() throws Exception {
        ClickElement($x("//div[contains(text(),'Project Setup')]"), "Project Setup");
        ClickElement($x("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]"), "");
        ClickElement(UsersRepo.RoleSetup, "Role Setup");
        ClickElement(UsersRepo.AdminRoles, "Admin Roles");
        ClickElement(UsersRepo.FirstCheckboxRole, "checkmark");
        ClickElement($x("//div[contains(text(),'Specialty Setup')]"), "Specialty setup");
        waitForPageLoadToComplete();
        ClickElement($x("//span[contains(text(),'Select All')]"), "Select All");
        waitForPageLoadToComplete();
        ClickElement($x("//span[contains(text(),'CREATE USER')]"), "Create User");
        waitForPageLoadToComplete();
        sleep(15000);
    }
    public static void SaveCreatedUser() throws Exception {
        String Password = "Test"+"@"+Common.GetTimeStamp();
        sleep(1000);
        System.out.println(Password);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'SAVE USER')]"));
        sleep(2000);
        $x("//input[@id='newPassword']").sendKeys(Password);
        sleep(2000);
        $x("//input[@id='confirmNewPassword']").sendKeys(Password);
        sleep(2000);
        ClickElement(UsersRepo.SaveButton,"Save button");
        sleep(2000);
        //String getTosterMessage=$x("//div[contains(text(),'User: Auto QA has been saved')]").getText();
//        if($x("//div[@class='ui-toast-detail']").isDisplayed())
//        {
//            logTestStepPass("User Created Successfully");
//        }else
//        {
//            logTestStepFail("User not created");
//            Assert.fail("User Not Created");
//        }

    }
    public static void SearchForUser() throws Exception {
        logTestStep("Searching New Created User");
        sleep(60000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(60000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(20000);
        ClickElement(ProjectsRepo.Filter,"Filter");
        sleep(3000);
        ClickElement(UsersRepo.Name,"Name");
        sleep(3000);
        $(UsersRepo.NameTextField).sendKeys("Auto QA");
        sleep(3000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
    }
    public static void DeactivateUser() throws Exception {
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
            Assert.fail("Created user not found");
        }
    }
}
