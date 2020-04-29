package MRCS.Modules.ProjectsModule;

import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ChaseQueryRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.TestData.ReveleerTestData;
import MRCS.Utils.Common;
import MRCS.Utils.Log;

import java.sql.Timestamp;
import java.util.Date;

import static MRCS.Utils.TestBase.*;
import static MRCS.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Selenide.*;

public class ChaseQuery {
    public static void VerifyChaseDetailPage() {
        String ChildrenChaseLink = $x("//div[@class='chase-id__related-chases-container ng-star-inserted']//div[2]").getText();
        Log.info(ChildrenChaseLink);
        $x("//div[@class='chase-id__related-chases-container ng-star-inserted']//div[2]").click();
        sleep(3000);
        if ($x("//i[@class='pi pi-times']").isDisplayed()) {
            $x("//i[@class='pi pi-times']").click();
        } else {
            Log.info("Cross button is not displayed.");
        }
        String Chase = $x("//h3[@class='container-title']").getText();
        String[] arrSplit_3 = Chase.split("\\s");
        String ActualCount = null;
        for (int j = 2; j < 3; j++) {
            ActualCount = arrSplit_3[j];
            break;
        }
        int result = Integer.parseInt(ActualCount);
        System.out.println(ActualCount);
        if (ChildrenChaseLink.equals(ActualCount)) {
            logTestStepPass("Children chase Id is hyperlinked and page successfully redirect to chase detail page.");
        } else {
            logTestStepFail("Children chase Id is not hyperlinked");
        }
    }

    public static void NewChase_ProjectDetails() {
        Common objCommon=new Common();
        logTestStep("Filling details of the project in the project form.");
        $(ChaseQueryRepo.ProjectDropdown).click();
        sleep(2000);
        $(ChaseQueryRepo.NameOfProject).click();
        sleep(2000);
        $(ChaseQueryRepo.ProductDropdown).click();
        sleep(2000);
        $(ChaseQueryRepo.ProductName).click();
        sleep(2000);
        $(ChaseQueryRepo.ChaseKey).setValue(objCommon.GetTimeStamp());
        sleep(2000);
        $(ChaseQueryRepo.MeasureDropdown).click();
        sleep(2000);
        $(MeasureRepo.ABA).click();
        sleep(2000);
        $(ChaseQueryRepo.NextButton).click();
        logTestStep("Clicked on next button.");
        sleep(2000);
    }

    public static void NewChase_CreatingNewMember() throws Exception {
        Common objCommon=new Common();
        ReveleerTestData objReveleer = new ReveleerTestData();
        objReveleer.GetData("Retrieval");
        $(ChaseQueryRepo.OptionNo).click();
        logTestStep("Selecting option 'No' to create new member.");
        logTestStep("Filling details of the member in the member form.");
        sleep(2000);
        $(ChaseQueryRepo.ClientMemberId).setValue(objCommon.GetTimeStamp());
        sleep(2000);
        $(ChaseQueryRepo.EnrollId).setValue("121212");
        sleep(2000);
        $(ChaseQueryRepo.FirstName).setValue(objReveleer.getFirst_Name());
        sleep(2000);
        $(ChaseQueryRepo.MiddleName).setValue(objReveleer.getFirst_Name());
        sleep(2000);
        $(ChaseQueryRepo.LastName).setValue(objReveleer.getLast_Name());
        sleep(2000);
        $(ChaseQueryRepo.DOB).setValue("03/03/1990");
        sleep(2000);
        $(ChaseQueryRepo.GenderDropDown).click();
        sleep(2000);
        $(ChaseQueryRepo.OptionFemale).click();
        sleep(2000);
        $(ChaseQueryRepo.AddMember).click();
        logTestStep("Clicked on add member button.");
        sleep(2000);
    }

    public static void NewChase_CreatingNewAddress() throws Exception {
        Common objCommon=new Common();
        ReveleerTestData objReveleer = new ReveleerTestData();
        objReveleer.GetData("Retrieval");
        $(ChaseQueryRepo.OptionNoForAddress).click();
        logTestStep("Selecting option 'No' to create new address.");
        logTestStep("Filling details of the address in the address form.");
        sleep(2000);
        $(ChaseQueryRepo.GroupName).setValue("TestGroup");
        sleep(2000);
        $(ChaseQueryRepo.Address1).setValue("Alaska");
        sleep(2000);
        $(ChaseQueryRepo.Address2).setValue(objReveleer.getAddress2());
        sleep(2000);
        $(ChaseQueryRepo.City).setValue(objReveleer.getCity());
        sleep(2000);
        $(ChaseQueryRepo.StateDropDown).click();
        sleep(2000);
        $(ChaseQueryRepo.StateName).click();
        sleep(2000);
        $(ChaseQueryRepo.ZipCode).setValue(objReveleer.getZip_Code());
        sleep(2000);
        $(ChaseQueryRepo.Contact).setValue(objReveleer.getFirst_Name());
        sleep(2000);
        $(ChaseQueryRepo.PhoneNumber).setValue(objReveleer.getPhone_Number());
        sleep(2000);
        $(ChaseQueryRepo.FaxNumber).setValue("8600864098");
        sleep(2000);
        $(ChaseQueryRepo.ClientAddressId).setValue("1223");
        sleep(2000);
        $(ChaseQueryRepo.AddAddress).click();
        logTestStep("Clicked on add address button.");
        sleep(2000);
    }
    public static void NewChase_CreatingNewProvider() throws Exception {
        ReveleerTestData objReveleer = new ReveleerTestData();
        objReveleer.GetData("Retrieval");
        $(ChaseQueryRepo.OptionNoForProvider).click();
        logTestStep("Selecting option 'No' to create new provider.");
        logTestStep("Filling details of the provider in the provider form.");
        sleep(2000);
        $(ChaseQueryRepo.NPI).setValue("12345");
        sleep(2000);
        $(ChaseQueryRepo.FirstNameOfProvider).setValue(objReveleer.getFirst_Name());
        sleep(2000);
        $(ChaseQueryRepo.LastNameOfProvider).setValue(objReveleer.getLast_Name());
        sleep(2000);
        $(ChaseQueryRepo.Speciality).setValue("Testing");
        sleep(2000);
        $(ChaseQueryRepo.ClientProviderId).setValue("12345");
        sleep(2000);
        $(ChaseQueryRepo.AddProvider).click();
        logTestStep("Clicked on add provider button.");
        sleep(2000);
    }
    public static void NewChase_GettingChaseRecordOfProject() throws Exception {
        Projects objProject = new Projects();
        logTestStep("Getting chase id's of same project.");
        objProject.ProjectsLink();
        $(ProjectsRepo.ChaseQueryHEDIS).click();
        logTestStep("Click on Chase Query");
        sleep(10000);
        $x("//span[contains(text(),'2020 HEDIS 1')]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(2000);
        logTestStep("Click on update button");
        Common.waitForPageLoadToComplete();
        sleep(5000);
    }
    public static void NewChase_VerifyNewlyCreatedChase() {
        String NewChase = $x("//div[@class='chase-detail text-center']//a").getText();
        Log.info(NewChase);
        $x("//div[@class='chase-detail text-center']//a ").click();
        sleep(3000);
        if ($x("//i[@class='pi pi-times']").isDisplayed()) {
            $x("//i[@class='pi pi-times']").click();
        } else {
            Log.info("Cross button is not displayed.");
        }
        sleep(2000);
        String Chase = $x("//h3[@class='container-title']").getText();
        String[] arrSplit_3 = Chase.split("\\s");
        String ActualCount = null;
        for (int j = 2; j < 3; j++) {
            ActualCount = arrSplit_3[j];
            break;
        }
        System.out.println(ActualCount);
        if (NewChase.equals(ActualCount)) {
            logTestStepPass("Newly created chase successfully redirect to chase detail page");
        } else {
            logTestStepFail("Newly created chase not redirect to chase detail page");
        }
        sleep(2000);
    }
}
