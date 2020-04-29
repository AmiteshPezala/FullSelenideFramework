package MRCS.Modules.RetrievalModule;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalFTRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class RetrievalFT {

    public static void NavigateToFT() throws Exception {
        Retrieval objRetrieval = new Retrieval();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        logTestStep("Clicking on Field Tech");
        sleep(2000);
        $(RetrievalRepo.FT).click();
        Common.waitForLoader();
        Common.waitForLoaderNew();
    }
    public static void EditAID() throws Exception {
        ClickElement(RetrievalFTRepo.FirstFTAID,"AID");
        sleep(5000);
        $(RetrievalRepo.EditAddress).click();
        sleep(2000);
        $(RetrievalRepo.GroupName).setValue("Test");
        $(RetrievalRepo.Email).setValue("test@yopmail.com");
        $(RetrievalRepo.Phone).setValue("8967979769");
        $(RetrievalRepo.Fax).setValue("7878787450");
        $(RetrievalRepo.ContactName).setValue("TestName");
        sleep(2000);
        $(RetrievalRepo.ApplyEdits).click();
        Log.info("clicked on Apply Edit button");
        logTestStep("Comparing details successfully edited");
        String Expected="Address Details successfully edited.";
        String Actual=Common.getElementText(By.xpath("//div[contains(text(),'Address Details successfully edited.')]"),5);
        assertText(Actual,Expected);
    }
    public static void PendChaseIfPended() throws Exception {
        $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
        Selenide.sleep(2000);
        Common.ClickElement(RetrievalFTRepo.PendChase,"Pend Chases");
        sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//label[contains(text(),'Status')]//following::span[@class='ng-star-inserted'][contains(text(),'New')]").click();
        sleep(2000);
        Common.ClickElement(RetrievalFTRepo.TextArea,"Text area");
        Selenide.sleep(2000);
        $(RetrievalFTRepo.TextArea).sendKeys("For testing purpose");
        Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
        Selenide.sleep(6000);
    }
    public static void PendChaseElsePended() throws Exception {
        $x("//*[text()='CHASES AT THIS ADDRESS']//following::p-tablecheckbox[1]").click();
        Selenide.sleep(2000);
        Common.ClickElement(RetrievalFTRepo.PendChase,"Pend Chases");
        sleep(3000);
        $x("//label[contains(text(),'Pend Code')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        Selenide.sleep(2000);
        $$(RetrievalEMRRepo.DropDownValue).filter(Condition.visible).get(3).click();
        sleep(2000);
        $x("//textarea[@id='notes']").sendKeys("For testing purpose");
        Common.ClickElement(RetrievalFTRepo.SaveButton,"Save Button");
        Selenide.sleep(5000);
    }
    public static void ChangingRetrievalMethod()
    {
        $x("(.//*[normalize-space(text()) and normalize-space(.)='CHANGE RETRIEVAL METHOD'])[1]/following::span[1]").click();
        Selenide.sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='To Field Tech'])[1]/following::span[1]").click();
        Selenide.sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Notes'])[1]/following::textarea[1]").sendKeys("test");
        Selenide.sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Notes'])[1]/following::button[1]").click();
        Selenide.sleep(2000);
    }

}
