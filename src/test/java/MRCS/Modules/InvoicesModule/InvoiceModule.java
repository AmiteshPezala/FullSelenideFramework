package MRCS.Modules.InvoicesModule;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.InvoicesRepo.InvoicesRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.RetrievalModule.ThirdParty;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.*;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.*;


public class InvoiceModule {

    public static void navigateToInvoicesPage() throws Exception {
        //sleep(5000);
        //waitForElementToBeClickable(LoginOutRepo.NavigationBar).click();
        //ClickElement(LoginOutRepo.NavigationBar,"NavigationBar");
        //logTestStep("clicked on Navigation bar");
        //sleep(2000);
        waitForElementToBeClickable(InvoicesRepo.invoicesLink).click();
        logTestStep("clicked on invoices link");

    }
    public static void navigateTo3rdParty() throws Exception {
        ThirdParty.ThirdPartyLink();
        Common.waitForLoader();
    }

    /** get valid chase id for invoice **/
    public static String getValidChaseId() throws Exception {
        $(ProjectsRepo.Filter).click();
        $$(InvoicesRepo.filterLinks).filter(Condition.visible).get(4).click();
        waitForElementToBeClickable(By.xpath("(//*[text()='Contacted'])[1]")).click();
        $(ProjectsRepo.Update).click();
        Common.waitForLoaderNew();
        $x("//tr[1]//td[2]").click();
        Common.waitForLoader();
        String firstChaseId=Common.getElementText($x("//tr[1]//td[2]//div"),5);
        String secondChaseId=Common.getElementText($x("//tr[2]//td[2]//div"),5);
        String validChaseId=firstChaseId+","+secondChaseId;
        return validChaseId;
    }

    public static void VerifyPagination() throws InterruptedException {
        if($x("//span[@class='ui-paginator-pages']//a[contains(text(),'2')]").isDisplayed()){
            logTestStep("Pagination present");
            String FirstId=$x("//tr[1]//td[1]").getText();
            Log.info("FirstId= "+ FirstId);
            ElementsCollection PageNo=$$x("//a[@class='ui-paginator-page ui-paginator-element ui-state-default ui-corner-all ng-star-inserted']");
            int TotalPageNo=PageNo.size();
            for(int i=1; i<=TotalPageNo-1 ;i++){
                $x("//a[@class='ui-paginator-page ui-paginator-element ui-state-default ui-corner-all ng-star-inserted'][" + (i +0) + "]").click();
                $(CommonRepo.Loader).waitUntil(Condition.disappear,DEFAULT_WAIT);
                Common.waitForLoaderNew();
                String NewId=$x("//tr[1]//td[1]").getText();
                Common.waitForLoaderNew();
                if(FirstId.equals(NewId)){
                    logTestStepFail("Pagination not working.");
                    sleep(3000);
                }else{
                    logTestStepPass("Pagination working properly for Page =" + i);
                    sleep(3000);
                }
            }
        }else{
            logTestStep("Pagination not present.");
        }
    }
    public static void SortingFunctionality() throws InterruptedException {
        String ID1= $x("//tr[1]//td[1]").getText();
        Log.info("ID1 ="+ ID1);
        $x("//tr//th[1]").click();
        Common.waitForLoaderNew();
        sleep(2000);
        String ID2= $x("//tr[1]//td[1]").getText();
        Log.info("ID2 ="+ ID2);
        if(ID1.equals(ID2)){
            logTestStepFail("Sorting not working");
        }else{
            logTestStepPass("Sorting working properly.");
        }
    }
}
