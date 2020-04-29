package MRCS.Modules;

import MRCS.Utils.Log;
import com.codeborne.selenide.Condition;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class CommonRisk {
    /**
     * Add data in Diagnoses grid in HCC form with Multiple VRC
     **/

    public static void DiagnosisWithMultipleVRC() throws InterruptedException {
        sleep(2000);
        $x("//input[@id='pageNumber']").setValue("1");
        sleep(2000);
        $x("((//label[contains(text(),'Provider')])[2]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(3000);
        if($x("((//label[contains(text(),'VRC')])[1]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").isEnabled()) {
            $x("((//label[contains(text(),'VRC')])[1]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
            sleep(1000);
            $x("(//p-dropdownitem//li//span)[1]").click();
            sleep(2000);
            $x("((//label[contains(text(),'VRC')])[1]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
            sleep(2000);
            $x("(//p-dropdownitem//li//span)[3]").click();
            sleep(2000);
            $x("((//label[contains(text(),'VRC')])[1]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
            sleep(2000);
            $x("(//p-dropdownitem//li//span)[5]").click();
            sleep(2000);
        }else{
            Log.info("VRC code drop down is empty");
        }
        $x("//h4[contains(text(),'ICD Information')]").click();
        sleep(2000);
    }

    /**
     * Add data in Diagnoses grid in HCC form with single VRC and Page number should be blank
     **/

    public static void DiagnosesWithSingleVRCAndEmptyPAgeNumber() throws InterruptedException {
        sleep(2000);
        $x("//input[@id='pageNumber']").setValue(" ");
        sleep(2000);
        $x("((//label[contains(text(),'Provider')])[2]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(3000);
        $x("((//label[contains(text(),'VRC')])[1]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(1000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(1000);
        $x("//h4[contains(text(),'ICD Information')]").click();
        sleep(2000);
    }

    /**
     * Add data in Diagnoses grid in HCC form with single VRC
     **/

    public static void DiagnosesWithSingleVRC() throws InterruptedException {
        sleep(2000);
        $x("(//h4[contains(text(),'ICD Information')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("((//label[contains(text(),'Provider')])[2]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(3000);
        if($x("(//div[@class='control control--input control--dropdown control--vrc-dropdown']//div[@class='control__header ng-star-inserted']//following::input)[1]").is(Condition.disabled)) {
            Log.info("in else else loop");
            Log.info("VRC code drop down is empty");

        }else{
            Log.info("in if if loop");
            $x("((//label[contains(text(),'VRC')])[1]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
            sleep(1000);
            $x("(//p-dropdownitem//li//span)[1]").click();
            sleep(1000);
        }
        $x("//h4[contains(text(),'ICD Information')]").click();
        sleep(2000);
    }

    public static void ENCasYes() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Specific service dates found in document (ENC)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(3000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(3000);
        $x("//div[contains(text(),'Specific service dates found in document (ENC)?')]").click();
        sleep(5000);
    }

    public static void F2FasYes() throws InterruptedException {
        sleep(2000);
        ClickElement($x("(//div[contains(text(),'Face to Face for specific service dates (F2F)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]"),"Clicking on F2F");
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Face to Face for specific service dates (F2F)?')]"),"Click to save");
        sleep(3000);
    }
    public static void F2FasNo() throws InterruptedException {
        sleep(2000);
        ClickElement($x("(//div[contains(text(),'Face to Face for specific service dates (F2F)?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]"),"Clicking on F2F");
        sleep(2000);
        ClickElement($x("//li[@aria-label='No']"),"Clicking on No");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Face to Face for specific service dates (F2F)?')]"),"Click to save");
        sleep(3000);
    }

    public static void MembersDateOfBirth() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Encounter Type')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[2]").click();
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Member's date of birth found in document?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']"),"Clicking on member");
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Encounter Type')]"),"Click to save");
        sleep(3000);
    }

    public static void MemberGender() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Encounter Type')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[3]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("(.//*[normalize-space(text()) and normalize-space(.)='-'])[7]/following::div[3]").click();
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Encounter Type')]"),"Click to save");
        sleep(3000);
    }

    public static void ServiceStartDate() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Service Start Date')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//div[contains(text(),'Service Start Date')]//following::input").setValue("1");
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
        /*String AdminVaule=$x("(//div[contains(text(),'Service Start Date')]//following::input)[3]").getValue();
        Log.info(AdminVaule);*/
        $x("(//div[contains(text(),'Service Start Date')]//following::input)[2]").setValue(count);
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Service Start Date')]"),"Click to save");
        sleep(3000);
    }

    public static void ServiceEndDate() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Service End Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[1]").click();
        sleep(3000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
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
       /* String AdminVaule=$x("(//div[contains(text(),'Service End Date')]//following::input)[3]").getValue();
        Log.info(AdminVaule);*/
        sleep(2000);
        $x("(//div[contains(text(),'Service End Date')]//following::input)[2]").setValue(count);
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Service End Date')]"),"Click to save");
        sleep(3000);
    }

    public static void ProviderAsYes() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Provider')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])[2]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//div[contains(text(),'Provider')]//following::input").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Provider')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Provider')]"),"Click to save");
        sleep(3000);
    }

    public static void FirstName() throws InterruptedException {
        /*sleep(2000);
        $x("(//div[contains(text(),'Does the signature have an acceptable First Name?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//input[@id='SigFirstNamePageNumber']").setValue("1");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Does the signature have an acceptable First Name?')]"),"Click to save");
        sleep(3000);*/
    }

    public static void LastName() throws InterruptedException {
        /*sleep(2000);
        $x("(//div[contains(text(),'Does the signature have an acceptable Last Name?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//input[@id='SigLastNamePageNumber']").setValue("1");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Does the signature have an acceptable Last Name?')]"),"Click to save");
        sleep(3000);*/
    }

    public static void AcceptableCredentials() throws InterruptedException {
        $x("(//div[contains(text(),'Is the provider signature acceptable?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("(//div[contains(text(),'Is the provider signature acceptable?')]//following::input)[1]").setValue("1");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Is the provider signature acceptable?')]"),"Click to save");
        sleep(3000);
        /*sleep(2000);
        $x("(//div[contains(text(),'Does the signature have acceptable Credentials?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//input[@id='SigPageNumberCredential']").setValue("1");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Does the signature have acceptable Credentials?')]"),"Click to save");
        sleep(3000);*/
    }

    public static void IncludeADate() throws InterruptedException {
        /*sleep(2000);
        $x("(//div[contains(text(),'Does the signature include a Date?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        ClickElement($x("//li[@aria-label='Yes']"),"Clicking on Yes");
        sleep(2000);
        $x("//input[@id='SigDatePageNumber']").setValue("1");
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Does the signature include a Date?')]"),"Click to save");
        sleep(3000);*/
    }

    public static void EncouterType() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Encounter Type')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(2000);
        ClickElement($x("//div[contains(text(),'Encounter Type')]"),"Click to save");
        sleep(3000);
    }

    public static void DiagnosesVRCCode96() throws InterruptedException {
        sleep(2000);
        $x("(//h4[contains(text(),'ICD Information')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("((//label[contains(text(),'Provider')])[2]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[1]").click();
        sleep(2000);
        $x("(//p-dropdownitem//li//span)[1]").click();
        sleep(3000);
        $x("//h4[contains(text(),'ICD Information')]").click();
        sleep(2000);
    }

}
