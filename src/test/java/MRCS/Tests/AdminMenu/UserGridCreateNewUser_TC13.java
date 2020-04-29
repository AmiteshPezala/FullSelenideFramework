package MRCS.Tests.AdminMenu;
import MRCS.Locators.AdminMenuRepo.UsersRepo;
import MRCS.Locators.AdminRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static MRCS.Modules.AdminMenuModule.User.*;
import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static com.codeborne.selenide.Selenide.*;

public class UserGridCreateNewUser_TC13 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "New user get created", groups = {"Admin Menu"})
    public void CreateNewUser ()throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        //sleep(5000);
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
            Assert.fail("New User not Created");
        }
        SearchForUser();
        DeactivateUser();
        //sleep(2000);
        objLoginOut.logout();
    }
}
