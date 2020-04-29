package MRCS.Modules.Pend;

import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.PendRepo.ClinicalPendRepo;
import MRCS.Locators.PendRepo.RetrievalPendRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import com.codeborne.selenide.Condition;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.Common.waitForPageLoadToComplete;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;

public class ClinicalPend {
    public void PendLink() throws Exception {
        //objWait.implicitwait();
        sleep(5000);
        ClickElement(LoginOutRepo.NavigationBar,"Clicking on Navigation bar");
        logTestStep("Clicked on Navigation bar");
        ClickElement(RetrievalPendRepo.Pend,"Clicking on Click Pend");
        logTestStep("Clicked on Click Pend Link");
        Common.waitForPageLoadToComplete();
        sleep(5000);

    }
    public static void navigateToClinicalPend() throws Exception {
        $(ClinicalPendRepo.clinicalLink).click();
        Common.waitForPageLoadToComplete();
        sleep(5000);
        $$(ClinicalPendRepo.startCount).filter(Condition.visible).first().click();
        sleep(5000);
//        Common.ClickElement(RetrievalPendRepo.TotalPend, "Total clinical Pend");
//        Common.ClickElement(RetrievalPendRepo.FirstPend, "First clinical Pend");
//        waitForPageLoadToComplete();
    }
    public static void navigateToFirstChase() throws Exception {
        Common.ClickElement(RetrievalPendRepo.FirstPend, "First RetrievalPend");
        waitForPageLoadToComplete();
    }
    public static void pendStatus()
    {
        $(ProjectsRepo.Filter).click();
        logTestStep("Clicked on filter option");
        sleep(2000);
        $(ClinicalPendRepo.pendStatus).click();
        logTestStep("Selecting pend status option");
        sleep(2000);
        logTestStep("Selecting all status except closed ");
        $(ClinicalPendRepo.newStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.inProgressStatus).click();
        sleep(2000);
        $(ClinicalPendRepo.resolved).click();
        sleep(2000);
        $(ClinicalPendRepo.closed).click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Request to Resolve'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
    }
}
