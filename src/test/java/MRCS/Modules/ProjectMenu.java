package MRCS.Modules;

import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.Pend.RetrievalPend;

import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ProjectMenu {

    public static void NavigateToPend() throws Exception {
        RetrievalPend objPend = new RetrievalPend();
        objPend.PendLink();
        sleep(2000);
        $x("//a[@class='headerStatsItem ng-star-inserted']").click();
        sleep(2000);
    }
    public static void FilterPend()
    {
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Pend Status')]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Select All'])[4]/following::div[5]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='New'])[1]/following::div[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='In Progress'])[1]/following::li[1]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Closed'])[1]/following::span[2]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Request to Resolve'])[1]/following::span[2]").click();
        sleep(2000);
        $x("//span[contains(text(),'Pend Codes')]").click();
        sleep(2000);
        $x("//span[contains(text(),'PC104')]").click();
        sleep(2000);
        $x("//span[contains(text(),'PC117')]").click();
        sleep(2000);
        $x("//span[contains(text(),'PC120')]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
    }
}
