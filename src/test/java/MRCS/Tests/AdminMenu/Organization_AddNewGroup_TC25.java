package MRCS.Tests.AdminMenu;

import MRCS.Locators.AdminRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class Organization_AddNewGroup_TC25 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that new group is created or not.", groups = {"Admin Menu"})
    public void Organization_AddNewGroup_TC25() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        Common.PopUp();
        //objWait.implicitwait();
        //sleep(5000);
        logTestStep("Clicking on Navigation bar");
        ClickElement(LoginOutRepo.NavigationBar, "Navigation bar ");
        Log.info("Clicked on Navigation bar");
        logTestStep("Clicking on Admin Link");
        ClickElement(AdminRepo.Admin, "Admin");
        Log.info("Clicked on Admin");
        ClickElement(AdminRepo.Organization, "Organization");
        logTestStep("Clicked on Organization");
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String date1= dateFormat.format(date);
        System.out.println("Current time is " +date1);

        $x("//div[contains(text(),'Group')]").click();
        sleep(2000);
        logTestStep("Clicked on group tab .");
        $x("//span[contains(text(),'Add New Group')]").click();
        logTestStep("Clicked on 'Add new group' button.");
        sleep(2000);
        $x("//label[contains(text(),'Group Name')]//following::input").setValue(date1);
        sleep(2000);
        $x("//label[contains(text(),'Group Name')]//following::span[contains(text(),'ADD')]").click();
        sleep(1000);
        String Successfulmessage = $x("//div[@class='ui-toast-detail']").getText();
        assertText(Successfulmessage, "Group name added successfully.");
        sleep(2000);
        objLoginOut.logout();
    }
}
