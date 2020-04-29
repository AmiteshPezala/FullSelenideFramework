package MRCS.Tests.AdminMenu;
import MRCS.Modules.LoginOut;
import MRCS.Utils.*;
import org.testng.annotations.Test;

import static MRCS.Modules.AdminMenuModule.User.NavigateToUsers;
import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.*;

public class VerifyUserCounts_TC10 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Gird is populated and matches the count", groups = {"Admin Menu"})
    public void VerifyListOfUsers()throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        //sleep(5000);
        NavigateToUsers();
        sleep(5000);
        String UserCount=$x("//div[@class='users-land-stats-container']//div[1]//a[1]").getText();
        logInfoStepColored(COLOR.BLUE,"Expected User Count: " +UserCount);
        int AllUserCount=Integer.parseInt(UserCount);
        int users = 0;
        int pgCount=1;
        while(!$("a.ui-paginator-next").getAttribute("class").contains("disable")){
            int counts = $$x("//table/tbody/tr").size();
            System.out.println("Page number " +pgCount + " contains rows " +counts);
            pgCount++;
            users=users+counts;
            $("a.ui-paginator-next").click();
            sleep(4000);
        }
        users +=$$x("//table/tbody/tr").size();
        System.out.println("---------------------------");
        System.out.println("Total users: " +users);
        logInfoStepColored(COLOR.BLUE,"Actual User Count: " +users);
        if(AllUserCount==users){
            logTestStepPass("Number of users matched");
        }else {
            logTestStepFail("Number of users not matched");
        }
        objLoginOut.logout();
    }
}
