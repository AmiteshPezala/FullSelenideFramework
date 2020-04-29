package MRCS.Modules.MRR;

import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.CommonRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.MRRRepo.MemberChasesRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Clinical;
import MRCS.Utils.Common;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class MemberChases {

    public static void NavigateToMemberChases() throws Exception {
        sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        ClickElement($x("//div[@class='menu--item'][contains(.,'My Profile')]"),"My Profile");
        Thread.sleep(5000);
        String FirstName=$(By.id("firstName")).getValue();
        sleep(2000);
        String LastName=$(By.id("lastName")).getValue();
        sleep(2000);
        String User= FirstName+" "+LastName;
        sleep(2000);
        Clinical objClinical = new Clinical();
        logTestStep("Clicking on Clinical link");
        objClinical.ClinicalLink();
        logTestStep("Clicking on MRR");
        ClickElement(ClinicalRepo.MRR, "Clicking on MRR");
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        $x("//span[contains(text(),'Assigned To')]").click();
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
        Common.ChaseRecord();
        $(CommonRepo.FirstChaseId).shouldBe(Condition.visible).click();
        sleep(2000);
    }
    public static void MemberTab() throws Exception {
        ClickElement(MemberChasesRepo.MemberChasesTab,"Member Chases Tab");
        sleep(5000);
    }

}
