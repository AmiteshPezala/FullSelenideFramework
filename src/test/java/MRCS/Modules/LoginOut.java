package MRCS.Modules;

import MRCS.Locators.LoginOutRepo;
import MRCS.TestData.GlobalTestData;
import MRCS.Utils.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import MRCS.Utils.Log;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static MRCS.TestData.GlobalTestData.UserNameUrl;
import static MRCS.Utils.Common.*;
import static MRCS.Utils.TestBase.logInfoStepColored;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * @author smartData
 * <h1>Login and Logout </h1>
 * <p>Purpose: This class is used for ProcessForm_SafetyDataSheet and logout form applications</p>
 * It is used to handle ProcessForm_SafetyDataSheet and logout form applications
 **/
public class LoginOut {
    /**
     * <h1>Login to Application<h1/>
     * <p>Purpose: This method is used to login to application  </p>
     *
     * @param actor
     * @throws Exception
     */

    public void loginAs(Actor actor) throws Exception {
        switch (actor) {
            case USERNAME_USERS:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.UserName_Users.getUserURL());
                LoginUser(GlobalTestData.UserName_Users.getUserId(), GlobalTestData.UserName_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                logInfoStepColored(TestBase.COLOR.PURPLE,"Current URL:" + GlobalTestData.UserName_Users.getUserURL());
                break;
            case USERNAME_Manager:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.Manager_Users.getUserURL());
                LoginUser(GlobalTestData.Manager_Users.getUserId(), GlobalTestData.Manager_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                logInfoStepColored(TestBase.COLOR.PURPLE,"Current URL:" + GlobalTestData.Manager_Users.getUserURL());
                break;
            case USERNAME_NonAdmin:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.NonAdmin_Users.getUserURL());
                LoginUser(GlobalTestData.NonAdmin_Users.getUserId(), GlobalTestData.NonAdmin_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                logInfoStepColored(TestBase.COLOR.PURPLE,"Current URL:" + GlobalTestData.NonAdmin_Users.getUserURL());
                break;
            case USERNAME_ThirdPartyEmployee:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.ThirdPartyEmployee_Users.getUserURL());
                LoginUser(GlobalTestData.ThirdPartyEmployee_Users.getUserId(), GlobalTestData.ThirdPartyEmployee_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                logInfoStepColored(TestBase.COLOR.PURPLE,"Current URL:" + GlobalTestData.ThirdPartyEmployee_Users.getUserURL());
                break;
            case USERNAME_NonManager:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.NonManager_Users.getUserURL());
                LoginUser(GlobalTestData.NonManager_Users.getUserId(), GlobalTestData.NonManager_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                logInfoStepColored(TestBase.COLOR.PURPLE,"Current URL:" + GlobalTestData.NonManager_Users.getUserURL());
                break;


            default:
                Assert.assertTrue(false, "Not a valid user type.");
        }
    }

    /**
     * <h1>Logout from Application<h1/>
     * <p>Purpose: This method is used to logout from</p>
     *
     * @throws Exception
     */
   public void logout() throws Exception {

        Log.info("Logging out the user");
        sleep(3000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        ClickElement(LoginOutRepo.Logout,"Logout");
        Log.info("Logout successful");

    }

    /**
     * <h1>Change URL<h1/>
     * <p>Purpose: This method is used to change url</p>
     *
     * @throws Exception
     */
    public void changeUrl() {
        url();
    }

    public static enum Actor {USERNAME_USERS,USERNAME_Manager,USERNAME_NonAdmin,USERNAME_ThirdPartyEmployee,USERNAME_NonManager
    }

}
