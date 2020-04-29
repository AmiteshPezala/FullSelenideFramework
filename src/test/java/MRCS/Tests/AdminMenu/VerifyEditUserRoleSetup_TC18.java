package MRCS.Tests.AdminMenu;
import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Locators.AdminRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.AdminMenuModule.User.*;
import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;

public class VerifyEditUserRoleSetup_TC18 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Add/edit user -role setup", groups = {"Admin Menu"})
    public void VerifyEditUserRoleSetup() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        NavigateToUsers();
        String GetUserCount=$(UsersRepo.UserCount).getText();
        int GetUserNameCountBefore=Integer.parseInt(GetUserCount);
        logInfoStepColored(COLOR.BLUE,"User count Before new user creation:"+GetUserNameCountBefore);
        AddUser();
        UserSetup();
        ClickElement($x("//div[contains(text(),'User Information')]"),"User Information");
        sleep(2000);
        SaveCreatedUser();
        sleep(240000);
        logTestStep("Clicking on Users again");
        ClickElement(AdminRepo.User,"User");
        waitForPageLoadToComplete();
        sleep(5000);
        String GetUserCountAfterAddUser=$(UsersRepo.UserCount).getText();
        int GetUserNameAfter=Integer.parseInt(GetUserCountAfterAddUser);
        logInfoStepColored(COLOR.BLUE,"User count After new user creation:"+GetUserNameAfter);
        sleep(2000);
        if(GetUserNameAfter>GetUserNameCountBefore){
            logTestStepPass("New User Created successfully");
        }else{
            logTestStepFail("New User not Created");
        }
        SearchForUser();
        ClickElement(UsersRepo.FirstRecord,"First Record");
        waitForPageLoadToComplete();
        sleep(2000);
        $(UsersRepo.LastNameTextField).setValue("QANew");
        sleep(3000);
        ClickElement(UsersRepo.RoleSetup, "Role Setup");
        sleep(2000);
        //$(UsersRepo.AdminRoles).click();
        $(UsersRepo.AdminRoles).doubleClick();
        sleep(2000);
        $(UsersRepo.LeadRoles).click();
        ClickElement(UsersRepo.FirstCheckboxRole, "checkmark");
        ClickElement(UsersRepo.SaveButton,"Save button");
        waitForPageLoadToComplete();
        sleep(3000);
        NavigateToUsers();
        logTestStep("Searching New Edited User");
        sleep(5000);
        ClickElement(CommonRepo.ResetButton,"Rest User");
        sleep(2000);
        ClickElement(ProjectsRepo.Filter,"Filter");
        ClickElement($x("//span[contains(text(),'Name')]"),"Name");
        sleep(2000);
        $x("//input[@id='Name']").sendKeys("Auto QANew");
        sleep(2000);
        $$(".ui-tabview-title").filter(Condition.visible).get(1).click();
        $$(".ui-dropdown-trigger").filter(Condition.visible).get(0).click();
        $$(".ui-dropdown-item").filter(Condition.visible).get(4).click();
        sleep(2000);
        ClickElement(ProjectsRepo.Update,"Update");
        sleep(5000);
        if($x("//table/tbody/tr/td[1]").isDisplayed())
        {
            logTestStepPass("Edited User found successfully");
            String GetFirstRecord=$x("//tr[1]//td[1]").getText();
            assertText(GetFirstRecord,"Auto QANew");
        }else{
            logTestStepFail("Edited user not found");
            Assert.fail("Edited user not found");
        }
        String GetRoleText=$(UsersRepo.SecondRecord).getText();
        System.out.println(GetRoleText);
        sleep(2000);
        assertText(GetRoleText,"Lead");
        DeactivateUser();
        objLoginOut.logout();
    }
}
