package MRCS.Tests.AdminMenu;

import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Locators.AdminRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static MRCS.Modules.AdminMenuModule.User.*;
import static MRCS.Utils.Common.*;
import static com.codeborne.selenide.Selenide.*;


public class VerifyEditUserDetails_TC16 extends TestBase {
    LoginOut objLoginOut = new LoginOut();

    @Test(description = "Add/edit user -User information", groups = {"Admin Menu"})
    public void VerifyUserGridFilter() throws Exception {
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("Log in to application");
        Common.PopUp();
        //objWait.implicitwait();
        NavigateToUsers();
        String GetUserCount=$(UsersRepo.UserCount).getText();
        int GetUserNameCountBefore=Integer.parseInt(GetUserCount);
        logInfoStepColored(COLOR.BLUE,"User count Before new user creation:"+GetUserNameCountBefore);
        AddUser();
        UserSetup();
        ClickElement($x("//div[contains(text(),'User Information')]"),"User Information");
        sleep(1000);
        SaveCreatedUser();
        logTestStep("Clicking on Users again");
        sleep(240000);
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
        $(UsersRepo.LastNameTextField).setValue("QANew");
        ClickElement($x("//span[contains(text(),'SAVE USER')]"),"Save");
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
        DeactivateUser();
        objLoginOut.logout();
    }
}
