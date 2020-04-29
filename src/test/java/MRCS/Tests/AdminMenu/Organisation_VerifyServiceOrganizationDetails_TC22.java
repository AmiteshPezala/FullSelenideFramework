package MRCS.Tests.AdminMenu;

import MRCS.Locators.AdminRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class Organisation_VerifyServiceOrganizationDetails_TC22 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify that the data is available for fields or not.", groups = {"Admin Menu"})
    public void Organisation_VerifyServiceOrganizationDetails_TC22 ()throws Exception {
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
        Log.info("Clicked on Organization");
        sleep(2000);
        logTestStep("Checking that data is present for 'Service Org Name' field .");
        String ServiceOrgName=$x("(//label[contains(text(),'Service Org Name')]//following::input)[1]").getValue();
        Log.info("ServiceOrgName" + ServiceOrgName);
        sleep(2000);
        if(ServiceOrgName.isEmpty()){
            logTestStepFail("Service org name is not present.");
            sleep(2000);
        }
        else{
            logTestStep("Service org name is present.");
            logTestStepPass("Service org name is : " + ServiceOrgName);
            sleep(2000);
        }

        logTestStep("Checking that data is present for 'Contact Name' field .");
        String ContactName=$x("(//label[contains(text(),'Contact Name')]//following::input)[1]").getValue();
        Log.info("ContactName  "+ ContactName);
        sleep(2000);
        if(ContactName.isEmpty()){
            logTestStepFail("Contact name is not present.");
            sleep(2000);
        }
        else{
            logTestStep("Contact name is present.");
            logTestStepPass("Contact name is : " + ContactName);
            sleep(2000);
        }

        logTestStep("Checking that data is present for 'Telephone' field .");
        String Telephone =$x("(//label[contains(text(),'Telephone')]//following::input)[1]").getValue();
        Log.info("Telephone  "+Telephone);
        sleep(2000);
        if(Telephone.isEmpty()){
            logTestStepFail("Telephone no is not present.");
            sleep(2000);
        }else{
            logTestStep("Telephone no is present.");
            logTestStepPass("Telephone no is : " + Telephone);
            sleep(2000);
        }
        logTestStep("Checking that data is present for 'Email' field .");
        String Email =$x("(//label[contains(text(),'Email')]//following::input)[1]").getValue();
        Log.info("Email  "+ Email);
        sleep(2000);
        if(Email.isEmpty()){
            logTestStepFail("Email id is not present.");
            sleep(2000);
        }else{
            logTestStep("Email id is present.");
            logTestStepPass("Email id is : " + Email);
            sleep(2000);
        }

        logTestStep("Checking that data is present for 'Max Chases per User' field .");
        String MaxChasesPerUser =$x("(//label[contains(text(),'Max Chases per User')]//following::input)[1]").getValue();
        Log.info("MaxChasesPerUser  "+ MaxChasesPerUser);
        sleep(2000);
        if(MaxChasesPerUser.isEmpty()){
            logTestStepFail("Max chases per user is not present.");
            sleep(2000);
        }else{
            logTestStep("Max chases per user is present");
            logTestStepPass("Max chases per user is : " + MaxChasesPerUser);
            sleep(2000);
        }
        objLoginOut.logout();
    }
}
