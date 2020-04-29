package MRCS.Modules;
import MRCS.Locators.ClinicalRepo.ClinicalRepo;
import MRCS.Locators.LoginOutRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static MRCS.Utils.Common.*;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Risk {
    Projects objProject = new Projects();
    Clinical objclinical = new Clinical();

    public void getUser() throws Exception {
        //get user from profile
        sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        $x("//div[@class='menu--item'][contains(.,'My Profile')]").click();
        sleep(5000);
        String FirstName = $(By.id("firstName")).getValue();
        sleep(2000);
        String LastName = $(By.id("lastName")).getValue();
        sleep(2000);
        String User = FirstName + " " + LastName;
        sleep(2000);
        //objProject.ProjectsLink();
        objclinical.ClinicalLink();
        $(ClinicalRepo.MRR).click();
        // objProject.GetDataFromChaseQuery();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        /*$x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
        sleep(2000);
        $x("//input[@id='ChaseIdAndClientChaseKey']").setValue("1413022");
        sleep(2000);*/
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(ProjectsRepo.SelectedMeasure).click();
        sleep(2000);
        Log.info("Selected Measure");
        logTestStep("Clicking on Assigned To link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]").click();
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        //$x("(.//*[normalize-space(text()) and normalize-space(.)='Page Size:'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        logTestStep("Clicking on First chase id");
        $x("//tr[1]//td[2]").click();
        logTestStep("Clicking on Chart");
        sleep(2000);
        $(RetrievalRepo.Chart).click();
        sleep(5000);
    }

    public void getUserfromOR1() throws Exception {
        //get user from profile
        sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        $x("//div[@class='menu--item'][contains(.,'My Profile')]").click();
        sleep(5000);
        String FirstName = $(By.id("firstName")).getValue();
        sleep(2000);
        String LastName = $(By.id("lastName")).getValue();
        sleep(2000);
        String User = FirstName + " " + LastName;
        sleep(2000);
        //objProject.ProjectsLink();
        objclinical.ClinicalLink();
        $(ClinicalRepo.OR1).click();
        // objProject.GetDataFromChaseQuery();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        /*$x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
        sleep(2000);
        $x("//input[@id='ChaseIdAndClientChaseKey']").setValue("1411985");
        sleep(2000);*/
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(ProjectsRepo.SelectedMeasure).click();
        sleep(2000);
        Log.info("Selected Measure");
        logTestStep("Clicking on Assigned To link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]").click();
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        //$x("(.//*[normalize-space(text()) and normalize-space(.)='Page Size:'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        logTestStep("Clicking on First chase id");
        $x("//tr[1]//td[2]").click();
        logTestStep("Clicking on Chart");
        sleep(2000);
        $(RetrievalRepo.Chart).click();
        sleep(5000);
    }

    public void getUserfromOR2() throws Exception {
        //get user from profile
        sleep(5000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($(LoginOutRepo.UatAdmin)).perform();
        sleep(2000);
        $x("//div[@class='menu--item'][contains(.,'My Profile')]").click();
        sleep(5000);
        String FirstName = $(By.id("firstName")).getValue();
        sleep(2000);
        String LastName = $(By.id("lastName")).getValue();
        sleep(2000);
        String User = FirstName + " " + LastName;
        sleep(2000);
        //objProject.ProjectsLink();
        objclinical.ClinicalLink();
        $(ClinicalRepo.OR2).click();
        // objProject.GetDataFromChaseQuery();
        sleep(2000);
        $(ProjectsRepo.Filter).click();
        sleep(2000);
        /*$x("//span[contains(text(),'Chase ID / Client Chase Key')]").click();
        sleep(2000);
        $x("//input[@id='ChaseIdAndClientChaseKey']").setValue("1447828");
        sleep(2000);*/
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(ProjectsRepo.SelectedMeasure).click();
        sleep(2000);
        Log.info("Selected Measure");
        logTestStep("Clicking on Assigned To link");
        $x("//span[@class='ui-tabview-title ng-star-inserted'][contains(text(),'Assigned To')]").click();
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(User);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ARROW_DOWN);
        sleep(2000);
        $x("//input[@id='AssignedToUserId']").sendKeys(Keys.ENTER);
        //$x("(.//*[normalize-space(text()) and normalize-space(.)='Page Size:'])[1]/following::span[2]").click();
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
        logTestStep("Clicking on First chase id");
        $x("//tr[1]//td[2]").click();
        logTestStep("Clicking on Chart");
        sleep(2000);
        $(RetrievalRepo.Chart).click();
        sleep(5000);
    }

    public void ForEnableAdminToEditable() throws InterruptedException {
        sleep(2000);
        $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Yes')]").click();
        sleep(2000);
        $x("//span[@class='ui-button-text ui-clickable'][contains(text(),'Submit')]").click();
        sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//label[@title='Claim ID']"));
        sleep(2000);
        CommonRisk.ENCasYes();
        sleep(2000);
        CommonRisk.F2FasYes();
        sleep(2000);
        //js.executeScript("arguments[0].scrollIntoView();", $x("//span[contains(text(),'Save Encounter Data')]"));
        //sleep(2000);
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void AddDiagnoses() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        sleep(2000);
        String AddedBeforeAdd = $x("(//span[@class='font-size-2 bold ng-star-inserted'])[4]").getText();
        sleep(2000);
        int TotalCount = Integer.parseInt(AddedBeforeAdd);
        logTestStep("Total count before click on Add button:" + " " + TotalCount);
        $x("//div[@title='Add a new diagnosis']").click();
        sleep(2000);
        String TotalAfterAdd = $x("(//span[@class='font-size-2 bold ng-star-inserted'])[4]").getText();
        int AddedCountAfterAdd = Integer.parseInt(TotalAfterAdd);
        logTestStep("Total count after click on Add button:" + " " + AddedCountAfterAdd);
        if (AddedCountAfterAdd > TotalCount) {
            logTestStep("New row added in Diagnostic grid");
        } else {
            Assert.fail("New row not added in Diagnostic grid");
        }
        sleep(2000);
    }

    public void membervalidation() throws Exception {
        logInfoStepColored(COLOR.BLUE, "Performing member validation");
        sleep(5000);
        ClickElement($x("//span[contains(text(),'Yes')]"), "Clicking on Yes");
        sleep(1000);
        logTestStep("Select option as yes");
        ClickElement($x("//span[contains(text(),'Submit')]"), "Clicking on Submit");
        logTestStep("Clicked on submit button");
        sleep(2000);
        String message = $x("//div[@class='ui-toast-detail']").getText();
        sleep(2000);
        assertText(message, "Member Validation Succeeded");
        sleep(2000);
    }

    public void EncountervalidationYes() throws InterruptedException {
        // $x("//member-risk-encounter-grid[@class='section']//tr[1]//td[1]").click();
        logTestStep("Selecting first encounter");
        //ENC as Yes
        CommonRisk.ENCasYes();

        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        //clicked on save encounter data
        /** Commenting "Save Encounter Data" because of UI change **/
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void EnterDiagnosticData() throws InterruptedException {
        sleep(2000);
        $x("//input[@id='pageNumber']").setValue("3");
        sleep(1000);
        $x("//input[@id='Icd']").sendKeys("Z6832");
        sleep(1000);
        ClickElement($x("((//label[contains(text(),'Provider')])[2]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]"), "Selecting Provider dropdown");
        sleep(1000);
        ClickElement($x("(//p-dropdownitem//li//span)[1]"), "Selecting first element");
        sleep(1000);
        ClickElement($x("((//label[contains(text(),'VRC')])[1]//following::label)[1]"), "Clicking on VRC dropdown");
        sleep(1000);
        ClickElement($x("(//p-dropdownitem//li//span)[1]"), "Selecting first element");
        sleep(1000);
        ClickElement($x("//h4[contains(text(),'ICD Information')]"), "Clicking on ICD");
        sleep(2000);
    }

    public void EnterDiagnosticDataForNewEncounter() throws InterruptedException {
        String currentDate = Common.GetCurrentTimeStamp();
        sleep(2000);
        $x("//input[@id='pageNumber']").setValue("3");
        sleep(1000);
        $x("//input[@id='Icd']").sendKeys("Z6832");
        sleep(1000);
        $x("//input[@id='startDate']").setValue(currentDate);
        sleep(2000);
        $x("//input[@id='endDate']").setValue(currentDate);
        sleep(2000);
        ClickElement($x("((//label[contains(text(),'Provider')])[2]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]"), "Selecting Provider dropdown");
        sleep(1000);
        ClickElement($x("(//p-dropdownitem//li//span)[1]"), "Selecting first element");
        sleep(1000);
        ClickElement($x("((//label[contains(text(),'VRC')])[1]//following::label)[1]"), "Clicking on VRC dropdown");
        sleep(1000);
        ClickElement($x("(//p-dropdownitem//li//span)[1]"), "Selecting first element");
        sleep(1000);
        ClickElement($x("//h4[contains(text(),'ICD Information')]"), "Clicking on ICD");
        sleep(2000);
    }

    public void AddEncounter() throws Exception {
        Risk objRisk = new Risk();
        //objRisk.membervalidation();
        sleep(2000);
        String AddedBeforeAdd = $x("(//span[@class='font-size-2 bold ng-star-inserted'])[3]").getText();
        sleep(2000);
        int AddedCount = Integer.parseInt(AddedBeforeAdd);
        logTestStep("Added count before click on Add button:" + " " + AddedCount);
        $x("//div[@title='Add a new encounter']").click();
        sleep(2000);
        String AddedAfterAdd = $x("(//span[@class='font-size-2 bold ng-star-inserted'])[3]").getText();
        int AddedCountAfterAdd = Integer.parseInt(AddedAfterAdd);
        logTestStep("Added count after click on Add button:" + " " + AddedCountAfterAdd);
        if (AddedCountAfterAdd > AddedCount) {
            logTestStepPass("New row added in encounter grid");
        } else {
            logTestStepFail("New row not added in encounter grid");
        }
    }

    public void membervalidationNo() throws InterruptedException {
        sleep(5000);
        $x("//span[contains(text(),'No')]").click();
        sleep(1000);
        logTestStep("Select option as No");
        $x("//input[@id='PageNumber']").setValue("1");
        sleep(1000);
        WebElement DropDown = $x("//app-member-validation/div/div[2]/select");
        Select sel = new Select(DropDown);
        sel.selectByValue("1");
        sleep(2000);
        $x("//span[contains(text(),'Submit')]").click();
        sleep(2000);
        logTestStep("Clicked on submit button");
    }

    public void EncountervalidationNo() throws InterruptedException {
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as no
        CommonRisk.F2FasNo();
        // ENC as no
        $x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(3000);
        ClickElement($x("//li[@aria-label='No']"), "Clicking on No");
        sleep(3000);
        $x("//div[contains(text(),'Specific service dates found in document (ENC)?')]").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[contains(text(),'Specific service dates found in document (ENC)?')]").click();
        sleep(5000);

        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void DiagnosisGriddata() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        int k = 1;
        if ($x("(//h3[contains(text(),'Diagnoses')]//following::span[@class='ui-paginator-pages'])").isDisplayed()) {
            Log.info("Pagination is displyaed");
            while ($x("(//h3[contains(text(),'Diagnoses')]//following::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed() || $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[1]//td[1]").exists()) {
                ElementsCollection col = $$x("//h3[contains(text(),'Diagnoses')]//following::td[@class='hdvi-gridcol hdvi-gridcol-dosRange ng-star-inserted']");
                int page = col.size();
                System.out.println("Page count = " + page);
                String paginationCount = $x("(//h3[contains(text(),'Diagnoses')]//following::span[@class='ui-paginator-pages'])/a[" + k + "]").getText();
                int result = Integer.parseInt(paginationCount);
                System.out.println("reult = " + result);
                for (int i = 1; i <= page; i++) {

                    if (result == 1 && i == 1) {
                        Log.info("in if loop");
                       CommonRisk.DiagnosesWithSingleVRC();


                    } else {
                        Log.info("in else loop");
                        $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[" + (i + 0) + "]//td[1]").click();
                        sleep(2000);
                        //$x("//tr[" + (i + 0) + "]//td[1]").click();
                        CommonRisk.DiagnosesWithSingleVRC();

                    }
                }
                k++;
                if ($x("(//h3[contains(text(),'Diagnoses')]//following::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed()) {
                    $x("(//h3[contains(text(),'Diagnoses')]//following::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").click();
                    sleep(2000);
                } else {
                    break;
                }
            }
        } else {
            Log.info("Pagination is not displyaed");
            ElementsCollection col = $$x("//h3[contains(text(),'Diagnoses')]//following::td[@class='hdvi-gridcol hdvi-gridcol-dosRange ng-star-inserted']");
            int page = col.size();
            System.out.println("Page count = " + page);
           CommonRisk.DiagnosesWithSingleVRC();
            for (int i = 1; i <= page - 1; i++) {
                System.out.println(i);
                $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[" + (i + 1) + "]//td[1]").click();
                CommonRisk.DiagnosesWithSingleVRC();
            }
        }
    }
    public void DiagnosisGriddataForMultipleVRC() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        int k = 1;
        if ($x("(//h3[contains(text(),'Diagnoses')]//following::span[@class='ui-paginator-pages'])").isDisplayed()) {
            Log.info("Pagination is displayed");
            while ($x("(//h3[contains(text(),'Diagnoses')]//following::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed() || $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[1]//td[1]").exists()) {
                ElementsCollection col = $$x("//h3[contains(text(),'Diagnoses')]//following::td[@class='hdvi-gridcol hdvi-gridcol-dosRange ng-star-inserted']");
                int page = col.size();
                System.out.println("Page count = " + page);
                String paginationCount = $x("(//h3[contains(text(),'Diagnoses')]//following::span[@class='ui-paginator-pages'])/a[" + k + "]").getText();
                int result = Integer.parseInt(paginationCount);
                System.out.println("reult = " + result);
                for (int i = 1; i <= page; i++) {

                    if (result == 1 && i == 1) {
                        Log.info("in if loop");
                        CommonRisk.DiagnosisWithMultipleVRC();


                    } else {
                        Log.info("in else loop");
                        $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[" + (i + 0) + "]//td[1]").click();
                        sleep(2000);
                        //$x("//tr[" + (i + 0) + "]//td[1]").click();
                        CommonRisk.DiagnosesWithSingleVRC();

                    }
                }
                k++;
                if ($x("(//h3[contains(text(),'Diagnoses')]//following::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").isDisplayed()) {
                    $x("(//h3[contains(text(),'Diagnoses')]//following::a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all'])").click();
                    sleep(2000);
                } else {
                    break;
                }
            }
        } else {
            Log.info("Pagination is not displyaed");
            ElementsCollection col = $$x("//h3[contains(text(),'Diagnoses')]//following::td[@class='hdvi-gridcol hdvi-gridcol-dosRange ng-star-inserted']");
            int page = col.size();
            System.out.println("Page count = " + page);
            CommonRisk.DiagnosisWithMultipleVRC();
            for (int i = 1; i <= page - 1; i++) {
                System.out.println(i);
                $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[" + (i + 1) + "]//td[1]").click();
                CommonRisk.DiagnosesWithSingleVRC();
            }
        }
    }

    public void EncounterValidationWithEmptyFields() throws InterruptedException {
        logTestStep("Selecting first encounter");
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();

        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        $x("//div[contains(text(),'Service Start Date')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();


    }

    public void DignosisGridWithEmptyFields() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h1[contains(text(),'Diagnoses')]"));
        //Filling data in default selected Diagnoses

        int counts = $$x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr").size();
        System.out.println(counts);
        sleep(2000);
        if ($x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/p-paginator/div/a[3]/span").isDisplayed()) {
            logTestStep("if loop");
            while (!$x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/p-paginator/div/a[3]/span").getAttribute("class").contains("disable")) {
                CommonRisk.DiagnosesWithSingleVRCAndEmptyPAgeNumber();
                for (int k = 1; k <= counts; k++) {
                    sleep(2000);
                    $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[" + (k + 0) + "]/td[1]").click();
                    CommonRisk.DiagnosesWithSingleVRCAndEmptyPAgeNumber();
                }
                $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/p-paginator/div/a[3]/span").click();
                sleep(4000);
            }
        } else {
            logTestStep("else loop");
            CommonRisk.DiagnosesWithSingleVRCAndEmptyPAgeNumber();
            for (int j = 1; j <= counts - 1; j++) {
                sleep(2000);
                $x("//member-risk-diagnoses-grid/app-basic-grid/p-table/div/div/table/tbody/tr[" + (j + 1) + "]/td[1]").click();
                CommonRisk.DiagnosesWithSingleVRCAndEmptyPAgeNumber();
            }
        }
    }

    public void EncountervalidationForServiceDateOutsideProjectDate() throws InterruptedException {
        // $x("//member-risk-encounter-grid[@class='section']//tr[1]//td[1]").click();
        logTestStep("Selecting first encounter");
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //For obtaining current date
        String Date1 = $x("//div[contains(text(),'Service Start Date')]//following::input[3]").getValue();
        Log.info(Date1);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(Date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.MONTH, -1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Service Start Date
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Confirm'])[1]/following::div[1]").click();
        sleep(2000);
        $x("//li[@aria-label='Yes']").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Page Number'])[1]/following::input[1]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::input[2]").setValue("01/01/2019");
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='-'])[8]/following::div[3]").click();
        sleep(2000);

        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);


    }

    public void EncountervalidationFormDateLessThanEndDate() throws InterruptedException {
        // $x("//member-risk-encounter-grid[@class='section']//tr[1]//td[1]").click();
        logTestStep("Selecting first encounter");
        sleep(2000);
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //For obtaining current date
        String StartDate=$x("(//div[contains(text(),'Service Start Date')]//following::input)[3]").getValue();
        Log.info("Start Date = " +StartDate);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        String Date1 = StartDate;
        Log.info(Date1);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(Date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_WEEK, -4);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Service Start Date
        sleep(2000);
        $x("(//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::input").setValue("1");
        sleep(2000);
        String AdminVaule=$x("(//div[contains(text(),'Service Start Date')]//following::input)[3]").getValue();
        Log.info(AdminVaule);
        $x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").setValue(StartDate);
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Service Start Date')]"),"Click to save");
        sleep(3000);

        //Service End Date as yes
        sleep(2000);
        $x("(//div[contains(text(),'Service End Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]").click();
        sleep(3000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(3000);
        $x("//div[contains(text(),'Service End Date')]//following::input").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Service End Date')]//following::input)[2]").setValue(newDate);
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Service End Date')]"),"Click to save");
        sleep(3000);
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        //clicked on save encounter data
        /** Commenting "Save Encounter Data" because of UI change **/
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void AddNewEncounterButNotDiagnosis() throws Exception {
        Risk objRisk = new Risk();
        objRisk.AddEncounter();
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Encounter Type
        CommonRisk.EncouterType();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void PageNoOfSignatureField() throws InterruptedException {
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        $x("//div[contains(text(),'Does the signature include a Date?')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[contains(text(),'Does the signature include a Date?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("//div[contains(text(),'Does the signature include a Date?')]//following::span[contains(text(),'Yes')]").click();
        sleep(2000);
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);

    }

    public void ValidateDateFiledOfSignatureFiledBlank() throws InterruptedException {
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Encounter Type
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //For obtaining current date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        $x("(//div[contains(text(),'Does the signature include a Date?')]//following::button[@class='control__delete ng-star-inserted'])[1]").click();
        sleep(2000);

        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void VerifySignatureCredentials() throws Exception {
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Encounter Type
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        $x("//div[contains(text(),'Is the provider signature acceptable?')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void VerifyPageNoOfSignatureCredential() throws InterruptedException {
        logTestStep("Selecting first encounter");
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        $x("(//div[contains(text(),'Does the signature have acceptable Credentials?')]//following::button[@class='control__delete ng-star-inserted'])").click();
        sleep(2000);
        $x("(//div[contains(text(),'Does the signature have acceptable Credentials?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"), "Clicking on Yes");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Does the signature have acceptable Credentials?')]"), "Click to save");
        sleep(3000);

        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);

    }

    public void PageNoOfSignatureLastName() throws InterruptedException {

        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        $x("(//div[contains(text(),'Does the signature have an acceptable Last Name?')]//following::button[@class='control__delete ng-star-inserted'])[1]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Does the signature have an acceptable Last Name?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"), "Clicking on Yes");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Does the signature have an acceptable Last Name?')]"), "Click to save");
        sleep(3000);

        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);

    }

    public void PageNoOfSignatureFirstName() throws InterruptedException {
        logTestStep("Selecting first encounter");
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        $x("(//div[contains(text(),'Does the signature have an acceptable First Name?')]//following::button[@class='control__delete ng-star-inserted'])[1]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Does the signature have an acceptable First Name?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"), "Clicking on Yes");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Does the signature have an acceptable First Name?')]"), "Click to save");
        sleep(3000);

        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);

    }

    public void NoteIsRequiredForProviderTransformation() throws InterruptedException {
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        $x("(//div[contains(text(),'Provider')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes - With Transformation']"), "Clicking on Yes");
        sleep(2000);
        $x("//div[contains(text(),'Provider')]//following::input").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Provider')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(2000);
        $x("//div[contains(text(),'Provider')]").click();
        sleep(3000);
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void PageNoOfProvider() throws InterruptedException {
        logTestStep("Selecting first encounter");
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        $x("(//button[@class='control__delete ng-star-inserted'])[8]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Provider')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//div[contains(text(),'Provider')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Provider')]"),"Click to save");
        sleep(3000);

        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);

    }

    public void NoterequiredForServiceEndDate() throws InterruptedException {
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();

        //Service End Date as yes
        $x("(//div[contains(text(),'Service End Date')]//following::button[@class='control__delete ng-star-inserted'])[1]").click();
        sleep(3000);
        sleep(2000);
        $x("(//div[contains(text(),'Service End Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]").click();
        sleep(3000);
        ClickElement($x("//span[contains(text(),'Yes - With Transformation')]"), "Clicking on Yes");
        sleep(3000);
        $x("//div[contains(text(),'Service End Date')]//following::input").setValue("1");
        sleep(2000);
        String ReviewPeriod=$x("//div[@class='container']//div[7]//div[2]").getText();
        Log.info(ReviewPeriod);
        String url = ReviewPeriod; // getting count of the xpath
        String[] arrSplit_2 = url.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 2; i < 3; i++) {
            count = arrSplit_2[i];
            break;
        }
        System.out.println("Top records are  = " + count );
        $x("(//div[contains(text(),'Service End Date')]//following::input)[2]").setValue(count);
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Service End Date')]"), "Click to save");
        sleep(3000);

        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);

    }

    public void NoteRequiredForServiceStartDate() throws InterruptedException {
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Confirm'])[1]/following::div[1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Yes - With Transformation')]").click();
        // $x("(.//*[normalize-space(text()) and normalize-space(.)='Submit'])[2]/following::span[1]").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Page Number'])[1]/following::input[1]").setValue("1");
        sleep(2000);
        String ReviewPeriod=$x("//div[@class='container']//div[7]//div[2]").getText();
        Log.info(ReviewPeriod);
        String url = ReviewPeriod; // getting count of the xpath
        String[] arrSplit_2 = url.split("\\s");    // Splitting the line "Top 699 records"
        String count = null;
        for (int i = 2; i < 3; i++) {
            count = arrSplit_2[i];
            break;
        }
        System.out.println("Top records are  = " + count );
        $x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").setValue(count);
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]").click();
        sleep(2000);

        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);

    }

    public void ServiceEndDateIsRequired() throws InterruptedException {
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Confirm'])[2]/following::label[1]").click();
        sleep(2000);
        $x("//li[@aria-label='Yes']").click();
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Page Number'])[2]/following::input[1]").setValue("1");
        sleep(2000);
        $x("//input[@id='EndDate']").setValue("  ");
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='-'])[9]/following::div[3]").click();
        sleep(2000);
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void ServiceStartDateIsRequired() throws InterruptedException {
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        $x("//div[contains(text(),'Service Start Date')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        //clicked on save encounter data
        /** Commenting "Save Encounter Data" because of UI change **/
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void PageNoIsRequiredForServiceStartDate() throws InterruptedException {
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();

        //Service Start Date
        $x("(//div[contains(text(),'Service Start Date')]//following::button[@class='control__delete ng-star-inserted'])[1]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"), "Clicking on Yes");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Service Start Date')]"), "Click to save");
        sleep(3000);

        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void PageNoIsRequiredForServiceEndDate() throws InterruptedException {
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();

        //Service End Date as yes
        $x("(//div[contains(text(),'Service End Date')]//following::button[@class='control__delete ng-star-inserted'])[1]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Service End Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]").click();
        sleep(3000);
        ClickElement($x("//li[@aria-label='Yes']"), "Clicking on Yes");
        sleep(3000);
        ClickElement($x("//div[contains(text(),'Service End Date')]"), "Click to save");
        sleep(3000);

        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void ProviderNameIsRequired() throws InterruptedException {
        sleep(2000);
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Member's date of birth found in document? as yes
        CommonRisk.MembersDateOfBirth();
        //Member's gender found in document? as yes
        CommonRisk.MemberGender();

        //For obtaining current date
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();

        //Provider as yes
        $x("//div[contains(text(),'Provider')]//following::button[@class='control__delete ng-star-inserted']").click();

        //Does the signature have an acceptable First Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void membersDateOfBirthInDocument() throws InterruptedException {
        sleep(2000);
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //DOB field
        $x("//div[contains(text(),\"Member's date of birth found in document?\")]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        //Encounter Type
        CommonRisk.MemberGender();
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }

    public void MembersGenderFoundInDocument() throws InterruptedException {
        //ENC as yes
        CommonRisk.ENCasYes();
        //F2F as yes
        CommonRisk.F2FasYes();
        //Encounter Type
        CommonRisk.MembersDateOfBirth();
        //gender found in field
        $x("(//button[@class='control__delete ng-star-inserted'])[5]").click();
        sleep(2000);
        //Service Start Date
        CommonRisk.ServiceStartDate();
        //Service End Date as yes
        CommonRisk.ServiceEndDate();
        //Provider as yes
        CommonRisk.ProviderAsYes();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.FirstName();
        //Does the signature have an acceptable Last Name? as yes
        CommonRisk.LastName();
        //Does the signature have acceptable Credentials? as yes
        CommonRisk.AcceptableCredentials();
        //Does the signature include a Date? as yes
        CommonRisk.IncludeADate();
        /** Commenting "Save Encounter Data" because of UI change **/
        //clicked on save encounter data
        //$x("//span[contains(text(),'Save Encounter Data')]").click();
        //sleep(2000);
    }



    public void DiagnosisGridDataForMultipleVRC_HST() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//h3[contains(text(),'Diagnoses')]"));
        CommonRisk.DiagnosisWithMultipleVRC();

    }

    public void DeleteEncounter() throws InterruptedException {
        sleep(2000);
        $x("//span[contains(text(),'Cancel')]").click();
        sleep(2000);
        $x("//div[contains(text(),'×')]").click();
        sleep(2000);
    }

    public static void ChecklistForART() throws InterruptedException {
        /*if ($x("//div[@class='check-list__label']").isDisplayed()) {
            logTestStep("Checklist functionality is available.");
            if ($x("//span[@class='ui-chkbox-icon ui-clickable pi pi-check']").isDisplayed()) {
                logTestStep("Checkbox is already selected");
            } else {
                ElementsCollection countOfCheckBox = $$(".ui-chkbox-box");
                System.out.println(countOfCheckBox);
                Log.info("enter into comparison");
                int record = countOfCheckBox.size(); // Will get total number of records
                System.out.println(record);
                for (int i = 0; i <= record - 1; i++) {
                    Log.info("in for loop ");
                    sleep(2000);
                    $$(".ui-chkbox-box").filter(Condition.visible).get(i).click();
                }
                $x("//div[@class='check-list__label']//following::div[@class='ui-dropdown-label-container']").click();
                sleep(2000);
                $x("(//p-dropdownitem//li//span)[1]").click();
                sleep(2000);
                $x("//div[@class='coding-container']").click();
            }
        } else {
            logTestStep("Checklist functionality is not available.");
        }*/
        Risk.ResearchCompleted();
    }

    public static void ResearchCompleted() throws InterruptedException {
        if($x("//h3[contains(text(),'Research Completed')]").isDisplayed()){
            logTestStep("Research functionality is present");
            if($x("//h3[contains(text(),'Research Completed')]//following::div[@class='ui-radiobutton-box ui-widget ui-state-default ui-state-active']").isDisplayed()){
                logTestStep("Radio button is already selected");
            }else{
                ElementsCollection CountOfRadioButton=$$x("//p-radiobutton[1]/div/div[2]");
                System.out.println(CountOfRadioButton);
                int record =CountOfRadioButton.size();
                System.out.println(record);
                for (int i=1 ;i<=record ;i++ ){
                   Log.info("In for loop");
                   sleep(2000);
                   $x("(//p-radiobutton[1]/div/div[2])[" + (i) + "]").click();
                }
                sleep(3000);
                $x("//div[@class='coding-container']").click();
            }

        }else{
            logTestStep("Research functionality is not present.");
        }
    }


}