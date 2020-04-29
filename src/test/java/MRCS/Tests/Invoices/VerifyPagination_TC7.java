package MRCS.Tests.Invoices;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Modules.InvoicesModule.InvoiceModule;
import MRCS.Modules.LoginOut;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.TestBase;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class VerifyPagination_TC7 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "Verify pagination functionality.", groups = {"Invoices"})
    public void VerifyPagination_TC7() throws Exception {
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        logTestStep("User login successful");
        Common.PopUp();
        InvoiceModule.navigateToInvoicesPage();
        $(InvoicesRepo.invoicesTabs).click();
        sleep(2000);
        if($x("//span[@class='ui-paginator-pages']//a[contains(text(),'2')]").isDisplayed()){
            logTestStep("Pagination present");
            String FirstId=$x("//tr[1]//td[2]").getText();
            Log.info("FirstId= "+ FirstId);
            ElementsCollection PageNo=$$x("//a[@class='ui-paginator-page ui-paginator-element ui-state-default ui-corner-all ng-star-inserted']");
            int TotalPageNo=PageNo.size();
            for(int i=1; i<=TotalPageNo-1 ;i++){
                $x("//a[@class='ui-paginator-page ui-paginator-element ui-state-default ui-corner-all ng-star-inserted'][" + (i +0) + "]").click();
                $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
                Common.waitForLoaderNew();
                String NewId=$x("//tr[1]//td[2]").getText();
                Common.waitForLoaderNew();
                if(FirstId.equals(NewId)){
                    logTestStepFail("Pagination not working.");
//                    sleep(3000);
                }else{
                    logTestStepPass("Pagination working properly for Page =" + i);
//                    sleep(3000);
                }
            }
        }else{
            logTestStep("Pagination not present.");
        }
//        sleep(2000);
        objLoginOut.logout();
    }
}
