package MRCS.Modules.RetrievalModule;

import MRCS.Locators.RetrievalRepo.RetrievalEMRRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Locators.RetrievalRepo.ThirdPartyRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Condition;

import static MRCS.Utils.Common.assertText;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class RetrievalEMR {

    public static void NavigateToEMR() throws Exception {
        Retrieval objRetrieval = new Retrieval();
        logTestStep("Clicking on Retrieval link");
        objRetrieval.RetrievalLink();
        sleep(2000);
        logTestStep("Clicking on EMR link");
        $(RetrievalRepo.EMR).click();
        Log.info("Clicked on EMR Link");
        Common.waitForLoader();
        Common.waitForLoaderNew();
    }
    public static void EditAddress() throws Exception {
        logTestStep("Clicking to edit address");
//        Common.ClickElement(RetrievalEMRRepo.FirstEMRAID,"First Record");
//        sleep(2000);
        $(RetrievalRepo.EditAddress).click();
        sleep(2000);
        $(RetrievalRepo.GroupName).setValue("Test");
        $(RetrievalRepo.Email).setValue("test@yopmail.com");
        $(RetrievalRepo.Phone).setValue("8967979769");
        $(RetrievalRepo.Fax).setValue("7878787450");
        //$(RetrievalRepo.ContactName).setValue("TestName");
        $(RetrievalRepo.ApplyEdits).click();
        Log.info("clicked on Apply Edit button");
        logTestStep("Comparing details successfully edited");
        String Expected="Address Details successfully edited.";
        String Actual=$x("//div[contains(text(),'Address Details successfully edited.')]").getText();
        assertText(Actual,Expected);
    }
    public static void PendGridColumns() throws InterruptedException {
        $(ThirdPartyRepo.PendTab).click();
        sleep(2000);
        String Column1 = $$x("//th[2]").filter(Condition.visible).last().getText();
        Log.info(Column1);
        String Column2 = $$x("//th[3]").filter(Condition.visible).last().getText();
        Log.info(Column2);
        String Column3 = $$x("//th[4]").filter(Condition.visible).last().getText();
        Log.info(Column3);
        String Column4 = $$x("//th[5]").filter(Condition.visible).last().getText();
        Log.info(Column4);
        String Column5 = $$x("//th[6]").filter(Condition.visible).last().getText();
        String Column6 = $$x("//th[7]").filter(Condition.visible).last().getText();
        Log.info(Column6);
        String Column7 = $$x("//th[8]").filter(Condition.visible).last().getText();
        Log.info(Column7);
        String Column8 = $$x("//th[9]").filter(Condition.visible).last().getText();
        Log.info(Column8);
        if (Column1.equals("PEND ID")) {
            logTestStepPass("Pend Id column is present on the grid.");
        } else {
            logTestStepFail("Pend Id column is not present on the grid.");
        }
        if (Column2.equals("PEND CODE")) {
            logTestStepPass("Pend code column is present on the grid.");
        } else {
            logTestStepFail("Pend code column is not present on the grid.");
        }
        if (Column3.equals("MEASURE")) {
            logTestStepPass("Measure column is present on the grid.");
        } else {
            logTestStepFail("Measure column is not present on the grid.");
        }
        if (Column4.equals("PEND STATUS")) {
            logTestStepPass("Pend status column is present on the grid.");
        } else {
            logTestStepFail("Pend status column is not present on the grid.");
        }
        if (Column5.equals("CHASE ID")) {
            logTestStepPass("Chase id column is present on the grid.");
        } else {
            logTestStepFail("Pend code column is not present on the grid.");
        }
        if (Column6.equals("PROJECT")) {
            logTestStepPass("Project column is present on the grid.");
        } else {
            logTestStepFail("Project column is not present on the grid.");
        }
        if (Column7.equals("CREATION DATE")) {
            logTestStepPass("Creation date column is present on the grid.");
        } else {
            logTestStepFail("Creation date column is not present on the grid.");
        }
        if (Column8.equals("LAST UPDATED")) {
            logTestStepPass("Last updated column is present on the grid.");
        } else {
            logTestStepFail("Last updated column is not present on the grid.");
        }
    }
    public static void ProviderGridColumns() throws InterruptedException {

        String Column1 = $$x("//th[2]").filter(Condition.visible).last().getText();
        Log.info(Column1);
        String Column2 = $$x("//th[3]").filter(Condition.visible).last().getText();
        Log.info(Column2);
        String Column3 = $$x("//th[4]").filter(Condition.visible).last().getText();
        Log.info(Column3);
        String Column4 = $$x("//th[5]").filter(Condition.visible).last().getText();
        Log.info(Column4);
        String Column5 = $$x("//th[6]").filter(Condition.visible).last().getText();
        String Column6 = $$x("//th[7]").filter(Condition.visible).last().getText();
        Log.info(Column6);

        if (Column1.equals("PROVIDER NAME")) {
            logTestStepPass("provider name column is present on the grid.");
        } else {
            logTestStepFail("provider name column is not present on the grid.");
        }
        if (Column2.equals("NPI")) {
            logTestStepPass("NPI column is present on the grid.");
        } else {
            logTestStepFail("NPI column is not present on the grid.");
        }
        if (Column3.equals("GROUP")) {
            logTestStepPass("Group column is present on the grid.");
        } else {
            logTestStepFail("Group column is not present on the grid.");
        }
        if (Column4.equals("SPECIALITY")) {
            logTestStepPass("Speciality column is present on the grid.");
        } else {
            logTestStepFail("Speciality column is not present on the grid.");
        }
        if (Column5.equals("TAX ID")) {
            logTestStepPass("Tax id column is present on the grid.");
        } else {
            logTestStepFail("Tax code column is not present on the grid.");
        }
        if (Column6.equals("VALIDATION")) {
            logTestStepPass("Validation column is present on the grid.");
        } else {
            logTestStepFail("Validation column is not present on the grid.");
        }
    }
    public static void PursuitTabGridData(){
        String Column1=$$x("//th[2]").filter(Condition.visible).last().getText();
        Log.info(Column1);
        String Column2=$$x("//th[3]").filter(Condition.visible).last().getText();
        Log.info(Column2);
        String Column3=$$x("//th[4]").filter(Condition.visible).last().getText();
        Log.info(Column3);
        String Column4=$$x("//th[5]").filter(Condition.visible).last().getText();
        Log.info(Column4);
        String Column5=$$x("//th[6]").filter(Condition.visible).last().getText();
        Log.info(Column5);
        String Column6=$$x("//th[7]").filter(Condition.visible).last().getText();
        Log.info(Column6);
        String Column7=$$x("//th[8]").filter(Condition.visible).last().getText();
        Log.info(Column7);
        String Column8=$$x("//th[9]").filter(Condition.visible).last().getText();
        Log.info(Column8);
        String Column9=$$x("//th[10]").filter(Condition.visible).last().getText();
        Log.info(Column9);
        String Column10=$$x("//th[11]").filter(Condition.visible).last().getText();
        Log.info(Column10);
        String Column11=$$x("//th[12]").filter(Condition.visible).last().getText();
        Log.info(Column11);
        String Column12=$$x("//th[13]").filter(Condition.visible).last().getText();
        Log.info(Column12);
        String Column13=$$x("//th[14]").filter(Condition.visible).last().getText();
        Log.info(Column13);
        if(Column1.equals("CHASE ID")){
            logTestStepPass("Chase Id column is present.");
        }else{
            logTestStepFail("Chase Id column is not present.");
        }
        if(Column2.equals("FIRST")){
            logTestStepPass("First column is present.");
        }else{
            logTestStepFail("First column is not present.");
        }
        if(Column3.equals("LAST")){
            logTestStepPass("Last column is present.");
        }else{
            logTestStepFail("Last column is not present.");
        }
        if(Column4.equals("DOB")){
            logTestStepPass("DOB column is present.");
        }else{
            logTestStepFail("DOB column is not present.");
        }
        if(Column5.equals("M/F")){
            logTestStepPass("M/F column is present.");
        }else{
            logTestStepFail("Tax ID column is not present.");
        }
        if(Column6.equals("PROVIDER NAME")){
            logTestStepPass("Provider name column is present.");
        }else{
            logTestStepFail("Provider name column is not present.");
        }
        if(Column7.equals("PROJECT")){
            logTestStepPass("Project column is present.");
        }else{
            logTestStepFail("Project column is not present.");
        }
        if(Column8.equals("MEASURE")){
            logTestStepPass("Measure column is present.");
        }else{
            logTestStepFail("Measure column is not present.");
        }
        if(Column9.equals("DOC REQUEST ID")){
            logTestStepPass("Doc request ID column is present.");
        }else{
            logTestStepFail("Doc request ID column is not present.");
        }
        if(Column10.equals("STATUS")){
            logTestStepPass("Status column is present.");
        }else{
            logTestStepFail("Status column is not present.");
        }
        if(Column11.equals("COMMIT")){
            logTestStepPass("Commit column is present.");
        }else{
            logTestStepFail("Commit column is not present.");
        }
        if(Column12.equals("PEND")){
            logTestStepPass("Pend column is present.");
        }else{
            logTestStepFail("Pend column is not present.");
        }
        if(Column13.equals("PEND STATUS")){
            logTestStepPass("Pend status column is present.");
        }else{
            logTestStepFail("Pend status column is not present.");
        }
    }
}
