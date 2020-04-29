package MRCS.Modules;

import MRCS.Locators.*;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Modules.ProjectsModule.Projects;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import MRCS.Utils.WaitTool;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Measure {
    Clinical objclinical = new Clinical();
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();
    Projects objprojects = new Projects();

    public void ABAMeasure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.ABA).click();
        logTestStep("Selecting ABA measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }
    public void ClearData() throws InterruptedException {
        ElementsCollection ClearButton=$$x("//div[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted']");
        int count=ClearButton.size();
        System.out.println("count = " + count);
        for(int i =1; i<=count;i++){
            $x("(//div[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted'])[" + (i +0) + "]").click();
            sleep(2000);
        }
    }

    public void BMIDate_ABA() throws InterruptedException {
        $x("//div[contains(text(),'BMI')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -2);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logTestStep("Entering all values of BMI field");
        $x("(//div[contains(text(),'BMI')]//following::input)[1]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'BMI')]//following::input)[4]").sendKeys("1");
        sleep(2000);
        if($x("(//div[contains(text(),'BMI')]//following::input)[2]").isDisplayed() &&  $x("(//div[contains(text(),'BMI')]//following::input)[3]").isDisplayed()){
            logTestStep("Both fields are present");
            $x("(//div[contains(text(),'BMI')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//div[contains(text(),'BMI')]//following::input)[3]").setValue("1");
            sleep(2000);
        }else{
            if($x("(//div[contains(text(),'BMI')]//following::input)[2]").isDisplayed()){
                $x("(//div[contains(text(),'BMI')]//following::input)[2]").setValue("1");

            }else{
                $x("(//div[contains(text(),'BMI')]//following::input)[3]").setValue("1");
            }
        }

        $x("//div[@class='coding-container']").click();
        sleep(3000);



    }

    public void WeightRecorded_ABA() throws InterruptedException {
        $x("//div[contains(text(),'Body Weight Test')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -2);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        logTestStep("Entering all values of weight recorded field");
        $x("(//div[contains(text(),'Body Weight Test')]//following::input)[1]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'Body Weight Test')]//following::input)[2]").sendKeys("1");
        sleep(2000);
        $x("//div[contains(text(),'Body Weight Test')]//following::span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//span[contains(text(),'Pounds')]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Body Weight Test')]//following::input)[4]").sendKeys("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
    }

    public void HeightRecorded_ABA() throws InterruptedException {
        $x("//div[contains(text(),'Body Height Test')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        Log.info(Date1);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -2);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logTestStep("Entering all values of height recorded field");
        $x("(//div[contains(text(),'Body Height Test')]//following::input)[1]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'Body Height Test')]//following::input)[2]").sendKeys("1");
        sleep(2000);
        $x("//div[contains(text(),'Body Height Test')]//following::span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']").click();
        sleep(2000);
        $x("//span[contains(text(),'Inches')]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Body Height Test')]//following::input)[4]").sendKeys("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(3000);
    }

    public void PositiveCompliance_ABA() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
            Assert.fail("Compliance shows negative");
        }
    }

    public void NegativeCompliance_ABA() throws InterruptedException {
        sleep(2000);
        String ChaseCompliance = $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").getText();
        sleep(2000);
        Log.info(ChaseCompliance);
        if (ChaseCompliance.contains("C/MR")) {
            logTestStepFail("Compliance shows positive");
            Assert.fail("Compliance shows positive");
        } else {
            logTestStepPass("Compliance shows negative");
        }
    }

    public void CBPMeasure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.CBP).click();
        logTestStep("Selecting CBP measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void W34Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.W34).click();
        logTestStep("Selecting W34 measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void FillAllDetails_W34() throws InterruptedException {
        //current date
        String text= Common.getElementText(By.xpath("//*[contains(text(),'Well Child Visit During')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String Date = null;
        for (int i = 4; i < 5; i++) {
            Date = arrSplit_3[i];
            break;
        }
        System.out.println(Date);
        //physical exam
        logTestStep("Fill date and page no for Physical Exam field");
        $x("(//div[contains(text(),'Physical Exam')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Exam')]//following::input)[2]").setValue("1");
        sleep(2000);
        //Mental Development history
        logTestStep("Fill date and page no for Mental Development history field");
        $x("(//div[contains(text(),'Mental Development History')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//div[contains(text(),'Mental Development History')]//following::input)[2]").setValue("1");
        sleep(2000);
        //Health education /Ant guidence
        logTestStep("Fill date and page no for Health education /Ant guidence field");
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input)[2]").setValue("1");
        sleep(2000);
        //physical development history
        logTestStep("Fill date and page no for Physical Development History field");
        $x("(//div[contains(text(),'Physical Development History')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Development History')]//following::input)[2]").setValue("1");
        sleep(2000);
        //health history
        logTestStep("Fill date and page no for Health History field");
        $x("(//div[contains(text(),'Health History')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//div[contains(text(),'Health History')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void AWC_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.AWC).click();
        logTestStep("Selecting AWC measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void FillAllDetails_AWC() throws InterruptedException {
        String text= Common.getElementText(By.xpath("//*[contains(text(),'Well Child Visit during')]"),5);
        String[] arrSplit_3 = text.split("\\s");    // Splitting the line "Top 699 records"
        String Date = null;
        for (int i = 4; i < 5; i++) {
            Date = arrSplit_3[i];
            break;
        }
        System.out.println(Date);
        sleep(2000);
        //health history
        logTestStep("Fill date and page no for Health history field");
        $x("(//*[contains(text(),'Health History')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//*[contains(text(),'Health History')]//following::input)[2]").setValue("1");
        sleep(2000);
        //Mental dev history
        logTestStep("Fill date and page no for Mental dev history field");
        $x("(//*[contains(text(),'Mental Dev. History')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//*[contains(text(),'Mental Dev. History')]//following::input)[2]").setValue("1");
        sleep(2000);
        //physical dev history
        logTestStep("Fill date and page no for Physical dev history field");
        $x("(//*[contains(text(),'Physical Dev. History')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//*[contains(text(),'Physical Dev. History')]//following::input)[2]").setValue("1");
        sleep(2000);
        //physical exam
        logTestStep("Fill date and page no for Physical exam field");
        $x("(//*[contains(text(),'Physical Exam')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//*[contains(text(),'Physical Exam')]//following::input)[2]").setValue("1");
        sleep(2000);
        //health ed/ant guidence
        logTestStep("Fill date and page no for Health ed/ant guidence field");
        $x("(//*[contains(text(),'Health Ed/Ant Guidance')]//following::input)[1]").setValue(Date);
        sleep(2000);
        $x("(//*[contains(text(),'Health Ed/Ant Guidance')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void WCC_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.WCC).click();
        logTestStep("Selecting WCC measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void DataForBMIPERCENTILE_WCC() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logTestStep("Fill date for BMI PERCENTILE RECORDED IN 2019 field");
        $x("(//div[contains(text(),'BMI percentile recorded')]//following::input)[1]").setValue(Date3);
        sleep(2000);
        $x("(//div[contains(text(),'BMI percentile recorded')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'BMI percentile recorded')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void DataForHeightAndWeight_WCC() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logTestStep("Fill date for HEIGHT AND WEIGHT RECORDED BETWEEN 1/1/2020 AND 12/31/2020 field");
        $x("(//div[contains(text(),'Weight')]//following::input)[1]").setValue(Date3);
        sleep(3000);
        $x("(//div[contains(text(),'Weight')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[position()=1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Pounds')]").click();
        sleep(3000);
        $x("(//div[contains(text(),'Weight')]//following::input)[4]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Weight')]//following::input)[5]").setValue(Date3);
        sleep(3000);
        $x("(//div[contains(text(),'Weight')]//following::input)[6]").setValue("1");
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[position()=2]").click();
        sleep(2000);
        $x("//span[contains(text(),'Inches')]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Weight')]//following::input)[8]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void DataForCounselingForNutrition_WCC() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logTestStep("Fill date for COUNSELING FOR NUTRITION BETWEEN 1/1/2020 AND 12/31/2020 field");
        $x("(//div[contains(text(),'Nutrition')]//following::input)[1]").setValue(Date3);
        sleep(3000);
        $x("(//div[contains(text(),'Nutrition')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);

    }

    public void DataForCounselingForPhysical_WCC() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        String Date3 = Date1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, -1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logTestStep("Fill date for COUNSELING FOR PHYSICAL ACTIVITY BETWEEN 1/1/2020 AND 12/31/2020 field");
        $x("(//div[contains(text(),'Physical Activity')]//following::input)[1]").setValue(Date3);
        sleep(3000);
        $x("(//div[contains(text(),'Physical Activity')]//following::input)[2]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);

    }

    public void BMIPositiveCompliance_WCC() throws InterruptedException {
        String ChaseCompliace = $x("(//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted'])[position()=1]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
        }

    }

    public void NutritionPositiveCompliance_WCC() throws InterruptedException {
        String ChaseCompliace = $x("(//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted'])[position()=2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
        }

    }

    public void PhysicalActivityCompliance_WCC() throws InterruptedException {
        String ChaseCompliace = $x("(//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted'])[position()=3]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
        }

    }

    public void NRCValidation_WCC() throws InterruptedException {
        //for BMI date
        $x("//div[contains(text(),'BMI Visit')]//following::button[@class='control__delete ng-star-inserted']").click();

        //for height weight
        $x("//div[contains(text(),'Weight')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[contains(text(),'Height')]//following::button[@class='control__delete ng-star-inserted']").click();
        //for nutrition
        $x("//div[contains(text(),'Nutrition')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        //for physical activity
        /*$x("//div[contains(text(),'Physical Activity')]//following::button[@class='control__delete ng-star-inserted']").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);*/
    }

    public void NegativeCompliance_WCC() throws InterruptedException {
        String ChaseCompliace = $x("(//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted'])[position()=1]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("BMI Compliance shows negative");
        } else {
            logTestStepFail("BMI Compliance shows positive");
        }
        String ChaseCompliace1 = $x("(//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted'])[position()=2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace1);
        if (ChaseCompliace1.contains("NC")) {
            logTestStepPass("Nutrition Compliance shows negative");
        } else {
            logTestStepFail("Nutrition Compliance shows positive");
        }
        String ChaseCompliace2 = $x("(//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted'])[position()=3]").getText();
        sleep(2000);
        Log.info(ChaseCompliace2);
        if (ChaseCompliace2.contains("NC")) {
            logTestStepPass("Physical Activity Compliance shows negative");
        } else {
            logTestStepFail("Physical Activity Compliance shows positive");
        }


    }

    public void ART_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.ART).click();
        logTestStep("Selecting ART measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void DataForDMARD() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        String Date1 = dateFormat.format(date);
        logTestStep("Fill date for DMARD field");
        $x("(//div[contains(text(),'DMARD')]//following::input)[1]").setValue(Date1);
        sleep(2000);
        $x("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[position()=1]").click();
        sleep(2000);
        $x("//span[contains(text(),'Abatacept')]").click();
        sleep(2000);
        $x("(//div[contains(text(),'DMARD')]//following::input)[3]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void PositiveCompliance_ART() throws InterruptedException {
        String ChaseCompliace = $x("(//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted'])[position()=1]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
        }
    }

    public void NegativeCompliance_ART() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepFail("Compliance shows positive");
        } else {
            logTestStepPass("Compliance shows negative");
        }
    }

    public void PositiveComplianceForMeningococcal_IMA() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//tr[1]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
            Assert.fail("Compliance shows negative");
        }
    }

    public void PositiveComplianceForTdap_IMA() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//tr[2]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/ADMIN") ||ChaseCompliace.contains("C/MR") ) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
            Assert.fail("Compliance shows negative");
        }
    }

    public void PositiveComplianceForHPV_IMA() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//tr[3]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
        }
    }

    public void IMA_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.IMA).click();
        logTestStep("Selecting HedisIMA measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void DeleteRow_IMA() throws InterruptedException {
        int Delete = $$x("//button[contains(text(),'×')]").size();
        System.out.println(Delete);
        for (int i = 1; i <= Delete; i++) {
            $x("(//button[contains(text(),'×')])").click();
            sleep(2000);
        }
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'Tdap')]"));
        sleep(2000);
        int Delete1 = $$x("//button[contains(text(),'×')]").size();
        System.out.println(Delete1);
        for (int i = 1; i <= Delete1; i++) {
            $x("(//button[contains(text(),'×')])").click();
            sleep(2000);
        }
        JavascriptExecutor js1 = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js1.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'HPV')]"));
        sleep(2000);
        int Delete2 = $$x("//button[contains(text(),'×')]").size();
        System.out.println(Delete1);
        for (int i = 1; i <= Delete1; i++) {
            $x("(//button[contains(text(),'×')])").click();
            sleep(2000);
        }
    }

    public void DataForMeningococcal_IMA() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 12);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sleep(2000);
        $x("(//*[@class='control__add'])[position()=1]").click();
        sleep(2000);
        if ($x("//div[contains(text(),'Tdap')]//preceding::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled']").isDisplayed()) {
            Log.info("in if loop");
            int AdminData = $$x("//div[contains(text(),'Tdap')]//preceding::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled']").size();
            sleep(2000);
            System.out.println(AdminData);
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[ " + (AdminData + 1) + " ]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[ " + (AdminData + 2) + " ]").setValue("1");
            sleep(2000);
        } else {
            Log.info("in else loop");
            logTestStep("Fill data for MENINGOCOCCAL VACCINE ON OR BETWEEN THE MEMBER'S 11TH AND 13TH BIRTHDAY field ");
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'Meningococcal')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
    }

    public void DataForTdap_IMA() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 12);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sleep(2000);
        $x("(//button[@class='control__add'])[position()=2]").click();
        if ($x("(//div[contains(text(),'Tdap')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            logTestStep("Fill data for TDAP VACCINE ON OR BETWEEN THE MEMBER'S 10TH AND 13TH BIRTHDAY field ");
            int CountofTdap = $$x("(//div[contains(text(),'Tdap')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            System.out.println("Count of TDAP = " + CountofTdap);
            sleep(2000);
            int CountOfHPV = $$x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            System.out.println("Count of HPV = " + CountOfHPV);
            sleep(2000);
            int FinalCount = CountofTdap - CountOfHPV;
            System.out.println("Final count = " + FinalCount);
            if (CountofTdap != CountOfHPV || CountOfHPV == 0) {
                sleep(2000);
                $x("(//div[contains(text(),'Tdap')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'Tdap')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
            } else {

                $x("(//div[contains(text(),'Tdap')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'Tdap')]//following::input)[2]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//div[contains(text(),'Tdap')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'Tdap')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void DataForHPV_IMA() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 12);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String seconddate = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(seconddate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 146);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sleep(2000);
        logTestStep("Fill data for 2 HPV VACCINATIONS (146 DAYS APART) OR 3 HPV VACCINATIONS ON OR BETWEEN THE MEMBER'S 9TH AND 13TH BIRTHDAY field");
        if ($x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").isDisplayed()) {
            int AdminData = $$x("(//div[contains(text(),'HPV')]//following::input[@class='control__input control__input--textbox control__input--admin ng-untouched ng-pristine ui-inputtext ui-corner-all ui-state-default ui-widget ui-state-filled'])").size();
            sleep(2000);
            System.out.println(AdminData);
            $x("(//*[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 1) + " ]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 2) + " ]").sendKeys("1");
            sleep(2000);
            $x("(//*[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 3) + " ]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[ " + (AdminData + 4) + " ]").sendKeys("1");
            sleep(2000);
        } else {
            $x("(//*[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[2]").sendKeys("1");
            sleep(2000);
            $x("(//*[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'HPV')]//following::input)[4]").sendKeys("1");
            sleep(2000);
        }
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void OMW_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.OMW).click();
        logTestStep("Selecting HedisOMW measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void PositiveCompliance_OMW() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//tr[1]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
            Assert.fail("Compliance shows negative");
        }
    }

    public void NegativeCompliance_OMW() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//tr[1]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("Compliance shows negative");
        } else {
            logTestStepFail("Compliance shows positive");
            Assert.fail("Compliance shows positive");
        }
    }

    public void DeleteRow_OMW() throws InterruptedException {
        int Delete = $$x("//div[contains(text(),'BMD Test Date')]//following::button[@class='control__delete ng-star-inserted']").size();
        System.out.println(Delete);
        for (int i = 1; i <= Delete; i++) {
            $x("(//div[contains(text(),'BMD Test Date')]//following::button[@class='control__delete ng-star-inserted'])[" + (i +0) + "]").click();
            sleep(2000);
        }
    }

    public void MRP_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.MRP).click();
        logTestStep("Selecting HedisMRP measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void PositiveCompliance_MRP() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//tr[1]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
        }
    }

    public void NegativeCompliance_MRP() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//tr[1]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("Compliance shows negative");
        } else {
            logTestStepFail("Compliance shows positive");
        }
    }

    public void LSCMeasure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.LSC).click();
        logTestStep("Selecting HedisLSC measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(5000);
    }

    public void PositiveCompliance_LSC() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR")) {
            logTestStepPass("Compliance shows positive");
        } else {
            logTestStepFail("Compliance shows negative");
        }
    }

    public void NegativeCompliance_LSC() throws InterruptedException {
        sleep(2000);
        String ChaseCompliace = $x("//td[@class='hdvi-gridcol hdvi-gridcol-chaseCompliance.code ng-star-inserted']").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("Compliance shows negative");
        } else {
            logTestStepFail("Compliance shows positive");
        }
    }

    public void CISMeasure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.CIS).click();
        logTestStep("Selecting HedisCIS measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void DeleteRow_CIS() throws InterruptedException {
        int Delete = $$x("//button[contains(text(),'×')]").size();
        System.out.println(Delete);
        for (int i = 1; i <= Delete; i++) {
            $x("(//button[contains(text(),'×')])").click();
            sleep(2000);
        }
    }

    public void PositiveComplianceDtap_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for Dtap");
        String ChaseCompliace = $x("//tr[10]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("Dtap numerator shows positive compliance");
        } else {
            logTestStepFail("Dtap numerator shows negative compliance");
        }
    }

    public void NegativeComplianceDtap_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for Dtap");
        String ChaseCompliace = $x("//tr[10]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("Dtap numarator shows negative compliance");
        } else {
            logTestStepFail("Dtap numarator shows positive compliance");
        }
    }

    public void PositiveComplianceIPV_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for IPV");
        String ChaseCompliace = $x("//tr[11]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("IPV numarator shows positive compliance");
        } else {
            logTestStepFail("IPV numarator shows negative compliance");
        }
    }

    public void NegativeComplianceIPV_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for IPV");
        String ChaseCompliace = $x("//tr[11]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("IPV numarator shows negative compliance");
        } else {
            logTestStepFail("IPV numarator shows positive compliance");
        }
    }

    public void PositiveComplianceHepA_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for HepA");
        String ChaseCompliace = $x("//tr[12]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("HepA numarator shows positive compliance");
        } else {
            logTestStepFail("HepA numarator shows negative compliance");
        }
    }

    public void PositiveComplianceHepB_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for HepB");
        String ChaseCompliace = $x("//tr[13]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("HepB numarator shows positive compliance");
        } else {
            logTestStepFail("HepB numarator shows negative compliance");
        }
    }

    public void PositiveComplianceHIB_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for HIB");
        String ChaseCompliace = $x("//tr[14]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("HIB numarator shows positive compliance");
        } else {
            logTestStepFail("HIB numarator shows negative compliance");
        }
    }

    public void PositiveComplianceMMR_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for MMR");
        String ChaseCompliace = $x("//tr[15]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("MMR numarator shows positive compliance");
        } else {
            logTestStepFail("MMR numarator shows negative compliance");
            Assert.fail("MMR numarator shows negative compliance");
        }
    }

    public void PositiveComplianceVZV_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for VZV");
        String ChaseCompliace = $x("//tr[16]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("VZV numarator shows positive compliance");
        } else {
            logTestStepFail("VZV numarator shows negative compliance");
        }
    }

    public void PositiveCompliancePCV_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for PCV");
        String ChaseCompliace = $x("//tr[17]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("PCV numarator shows positive compliance");
        } else {
            logTestStepFail("PCV numarator shows negative compliance");
        }
    }

    public void PositiveComplianceDoseRotavirus_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for Rotavirus");
        String ChaseCompliace = $x("//tr[18]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("Rotavirus numarator shows positive compliance");
        } else {
            logTestStepFail("Rotavirus numarator shows negative compliance");
            Assert.fail("Rotavirus numarator shows negative compliance");
        }
    }

    public void PositiveComplianceInfluenza_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for Influenza");
        String ChaseCompliace = $x("//tr[19]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("C/MR") || ChaseCompliace.contains("C/ADMIN")) {
            logTestStepPass("Influenza numarator shows positive compliance");
        } else {
            logTestStepFail("Influenza numerator shows negative compliance");
        }

    }

    public void NegativeComplianceInfluenza_CIS() throws InterruptedException {
        sleep(2000);
        logTestStep("Checking compliance for IPV");
        String ChaseCompliace = $x("//tr[19]//td[2]").getText();
        sleep(2000);
        Log.info(ChaseCompliace);
        if (ChaseCompliace.contains("NC")) {
            logTestStepPass("Influenza numarator shows negative compliance");
        } else {
            logTestStepFail("Influenza numarator shows positive compliance");
        }
    }

    public void DataforDtap_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date3 = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date4 = newDate2;
        SimpleDateFormat sdf3 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal3 = Calendar.getInstance();
        try {
            cal3.setTime(sdf3.parse(Date4));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal3.add(Calendar.DAY_OF_MONTH, 1);
        String newDate3 = sdf3.format(cal3.getTime());
        System.out.println("new date" + newDate3);
        try {
            cal3.setTime(sdf3.parse(newDate3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'IPV')]//preceding::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int AdminData = $$x("(//div[contains(text(),'IPV')]//preceding::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            sleep(2000);
            System.out.println(AdminData);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 1) + " ]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 2) + " ]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 3) + " ]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 4) + " ]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 5) + " ]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 6) + " ]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 7) + " ]").setValue(newDate3);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[ " + (AdminData + 8) + " ]").setValue("1");
            sleep(2000);
            $x("//div[@class='coding-container']").click();
            sleep(2000);
        } else {
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[6]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=1]").click();
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[7]").setValue(newDate3);
            sleep(2000);
            $x("(//div[contains(text(),' DtaP ')]//following::input)[8]").setValue("1");
            sleep(2000);
            $x("//div[@class='coding-container']").click();
            sleep(2000);
        }
    }

    public void DataForIPV_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date3 = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if ($x("(//div[contains(text(),'IPV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfIPV = $$x("(//div[contains(text(),'IPV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of IPV = " + CountOfIPV);
            int CountOfHepA = $$x("(//div[contains(text(),'HepA')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of HepA = " + CountOfHepA);
            int FinalCount = CountOfIPV - CountOfHepA;
            System.out.println("Final count = " + FinalCount);
            if (CountOfIPV != CountOfHepA || CountOfHepA == 0) {
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 5) + " ]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[ " + (FinalCount + 6) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[4]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=2]").click();
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[5]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'IPV')]//following::input)[6]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=2]").click();
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=2]").click();
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=2]").click();
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'IPV')]//following::input)[6]").setValue("1");
            sleep(2000);
        }
    }

    public void DataForHEPA_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'HepA')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfHepA = $$x("(//div[contains(text(),'HepA')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of HepA = " + CountOfHepA);
            int CountOfHepB = $$x("((//div[contains(text(),'Disease/Seropositive')])[position()=1]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of HepB = " + CountOfHepB);
            int FinalCount = CountOfHepA - CountOfHepB;
            System.out.println("Final count = " + FinalCount);
            if (CountOfHepA != CountOfHepB || CountOfHepB == 0) {
                $x("(//button[@class='control__add'])[position()=3]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepA')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'HepA')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=3]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepA')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'HepA')]//following::input)[2]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=3]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HepA')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HepA')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
    }

    public void DataForHepB_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date3 = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'HepB')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            Log.info("in if loop");
            int CountOfHepB = $$x("(//div[contains(text(),'HepB')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of HepB  = " + CountOfHepB);
            int CountOfDiseaseSeropositive = $$x("((//div[contains(text(),'Disease/Seropositive')])[position()=2]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of HIB = " + CountOfDiseaseSeropositive);
            int FinalCount = CountOfHepB - CountOfDiseaseSeropositive;
            System.out.println("Final count = " + FinalCount);
            if (CountOfHepB != CountOfDiseaseSeropositive || CountOfDiseaseSeropositive == 0) {
                $x("(//button[@class='control__add'])[position()=5]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=5]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=5]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[ " + (FinalCount + 5) + " ]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[ " + (FinalCount + 6) + " ]").setValue("1");
                sleep(2000);
            } else {
                Log.info("in else loop");
                $x("(//button[@class='control__add'])[position()=5]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=5]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[4]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=5]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[5]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'HepB')]//following::input)[6]").setValue("1");
                sleep(2000);

            }
        } else {
            Log.info("In 2 else loop");
            $x("(//button[@class='control__add'])[position()=5]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HepB')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HepB')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=5]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HepB')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'HepB')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=5]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HepB')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'HepB')]//following::input)[6]").setValue("1");
            sleep(2000);
        }
    }

    public void DataForHIB_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date3 = newDate;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.YEAR, 1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'HIB')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfHIB = $$x("(//div[contains(text(),'HIB')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of HIB  = " + CountOfHIB);
            int CountOfMMR = $$x("(//div[contains(text(),'MMR')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of MMR = " + CountOfMMR);
            int FinalCount = CountOfHIB - CountOfMMR;
            System.out.println("Final count = " + FinalCount);
            if (CountOfHIB != CountOfMMR || CountOfMMR == 0) {
                $x("(//button[@class='control__add'])[position()=7]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=7]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=7]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[ " + (FinalCount + 5) + " ]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[ " + (FinalCount + 6) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=7]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=7]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[4]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=7]").click();
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[5]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'HIB')]//following::input)[6]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=7]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HIB')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'HIB')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=7]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HIB')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'HIB')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=7]").click();
            sleep(2000);
            $x("(//div[contains(text(),'HIB')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'HIB')]//following::input)[6]").setValue("1");
            sleep(2000);
        }
    }

    public void DataForMMR_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'MMR')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfMMR = $$x("(//div[contains(text(),'MMR')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of MMR  = " + CountOfMMR);
            int CountOfMeasles = $$x("(//div[contains(text(),'Measles')])[1]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled']").size();
            System.out.println("count of measles = " + CountOfMeasles);
            int FinalCount = CountOfMMR - CountOfMeasles;
            System.out.println("Final count = " + FinalCount);
            if (CountOfMMR != CountOfMeasles || CountOfMeasles == 0) {
                $x("(//button[@class='control__add'])[position()=8]").click();
                sleep(2000);
                $x("(//div[contains(text(),'MMR')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'MMR')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=8]").click();
                sleep(2000);
                $x("(//div[contains(text(),'MMR')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'MMR')]//following::input)[2]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=8]").click();
            sleep(2000);
            $x("(//div[contains(text(),'MMR')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'MMR')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
    }

    public void DataForVZV_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'VZV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfVZV = $$x("(//div[contains(text(),'VZV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of VZV = " + CountOfVZV);
            int CountOfPCV = $$x("(//div[contains(text(),'PCV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of PCV = " + CountOfPCV);
            int FinalCount = CountOfVZV - CountOfPCV;
            System.out.println("Final count = " + FinalCount);
            if (CountOfVZV != CountOfPCV || CountOfPCV == 0) {
                $x("(//button[@class='control__add'])[position()=15]").click();
                sleep(2000);
                $x("(//div[contains(text(),'VZV')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'VZV')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=15]").click();
                sleep(2000);
                $x("(//div[contains(text(),'VZV')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'VZV')]//following::input)[2]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=15]").click();
            sleep(2000);
            $x("(//div[contains(text(),'VZV')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'VZV')]//following::input)[2]").setValue("1");
            sleep(2000);
        }
    }

    public void Rotavirus2ForCombination_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 3);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfRotavirus = $$x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of rotavirus= " + CountOfRotavirus);
            int CountOfInfluenza = $$x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of Influenza = " + CountOfInfluenza);
            int FinalCount = CountOfRotavirus - CountOfInfluenza;
            System.out.println("Final count = " + FinalCount);
            if (CountOfRotavirus != CountOfInfluenza || CountOfInfluenza == 0) {
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[4]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=18]").click();
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=18]").click();
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[4]").setValue("1");
            sleep(2000);
        }
    }

    public void Rotavirus3ForCombination_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 3);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date3 = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.DAY_OF_MONTH, 3);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfRotavirus = $$x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of rotavirus= " + CountOfRotavirus);
            int CountOfInfluenza = $$x("(//div[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of Influenza = " + CountOfInfluenza);
            int FinalCount = CountOfRotavirus - CountOfInfluenza;
            System.out.println("Final count = " + FinalCount);
            if (CountOfRotavirus != CountOfInfluenza || CountOfInfluenza == 0) {
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 5) + " ]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 6) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[4]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[5]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[6]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=19]").click();
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=19]").click();
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=19]").click();
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[6]").setValue("1");
            sleep(2000);
        }
    }

    public void DataForPCV_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 2);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date3 = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date4 = newDate2;
        SimpleDateFormat sdf3 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal3 = Calendar.getInstance();
        try {
            cal3.setTime(sdf3.parse(Date4));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal3.add(Calendar.DAY_OF_MONTH, 1);
        String newDate3 = sdf3.format(cal3.getTime());
        System.out.println("new date" + newDate3);
        try {
            cal3.setTime(sdf3.parse(newDate3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'PCV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfPCV = $$x("(//div[contains(text(),'PCV')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of VZV = " + CountOfPCV);
            int CountOfDoseRotavirus = $$x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of DoseRotavirus = " + CountOfDoseRotavirus);
            int FinalCount = CountOfPCV - CountOfDoseRotavirus;
            System.out.println("Final count = " + FinalCount);
            if (CountOfPCV != CountOfDoseRotavirus || CountOfDoseRotavirus == 0) {
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 5) + " ]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 6) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 7) + " ]").setValue(newDate3);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[ " + (FinalCount + 8) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[4]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[5]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[6]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=17]").click();
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[7]").setValue(newDate3);
                sleep(2000);
                $x("(//div[contains(text(),'PCV')]//following::input)[8]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=17]").click();
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=17]").click();
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=17]").click();
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[6]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=17]").click();
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[7]").setValue(newDate3);
            sleep(2000);
            $x("(//div[contains(text(),'PCV')]//following::input)[8]").setValue("1");
            sleep(2000);
        }
    }
    public void DataFor2Rotavirus_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();

        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 3);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfRotavirus = $$x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of rotavirus= " + CountOfRotavirus);
            int CountOfInfluenza = $$x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of Influenza = " + CountOfInfluenza);
            int FinalCount = CountOfRotavirus - CountOfInfluenza;
            System.out.println("Final count = " + FinalCount);
            if (CountOfRotavirus != CountOfInfluenza || CountOfInfluenza == 0) {
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=18]").click();
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[4]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=18]").click();
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=18]").click();
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'2 Dose Rotavirus')]//following::input)[4]").setValue("1");
            sleep(2000);
        }
    }

    public void DataFor3Rotavirus_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date3 = newDate1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal2 = Calendar.getInstance();
        try {
            cal2.setTime(sdf2.parse(Date3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        String newDate2 = sdf2.format(cal2.getTime());
        System.out.println("new date" + newDate2);
        try {
            cal2.setTime(sdf2.parse(newDate2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int CountOfRotavirus = $$x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of rotavirus= " + CountOfRotavirus);
            int CountOfInfluenza = $$x("(//div[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            System.out.println("count of Influenza = " + CountOfInfluenza);
            int FinalCount = CountOfRotavirus - CountOfInfluenza;
            System.out.println("Final count = " + FinalCount);
            if (CountOfRotavirus != CountOfInfluenza || CountOfInfluenza == 0) {
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 1) + " ]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 2) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 3) + " ]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 4) + " ]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 5) + " ]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[ " + (FinalCount + 6) + " ]").setValue("1");
                sleep(2000);
            } else {
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[2]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[4]").setValue("1");
                sleep(2000);
                $x("(//button[@class='control__add'])[position()=19]").click();
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[5]").setValue(newDate2);
                sleep(2000);
                $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[6]").setValue("1");
                sleep(2000);
            }
        } else {
            $x("(//button[@class='control__add'])[position()=19]").click();
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=19]").click();
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[4]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=19]").click();
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[5]").setValue(newDate2);
            sleep(2000);
            $x("(//div[contains(text(),'3 Dose Rotavirus')]//following::input)[6]").setValue("1");
            sleep(2000);
        }
    }

    public void DataForInfluenza_CIS() throws InterruptedException {
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        System.out.println("DOB is " + DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.YEAR, 1);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf1.parse(Date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        String newDate1 = sdf1.format(cal1.getTime());
        System.out.println("new date" + newDate1);
        try {
            cal1.setTime(sdf1.parse(newDate1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if ($x("(//div[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").isDisplayed()) {
            int AdminDate = $$x("(//div[contains(text(),'Influenza')]//following::input[@class='control__input control__input--textbox control__input--admin ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ui-state-filled'])").size();
            $x("(//button[@class='control__add'])[position()=20]").click();
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminDate + 1) + " ]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminDate + 2) + " ]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=20]").click();
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminDate + 3) + " ]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[ " + (AdminDate + 4) + " ]").setValue("1");
            sleep(2000);
        } else {
            $x("(//button[@class='control__add'])[position()=20]").click();
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[1]").setValue(newDate);
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[2]").setValue("1");
            sleep(2000);
            $x("(//button[@class='control__add'])[position()=20]").click();
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[3]").setValue(newDate1);
            sleep(2000);
            $x("(//div[contains(text(),'Influenza')]//following::input)[4]").setValue("1");
            sleep(2000);
        }
    }

    public void ENR_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.ENR).click();
        logTestStep("Selecting Hedis ENR measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void MemberId_ENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Member ID')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Member ID')])[2]//following::input").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void FirstName_ENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'First Name')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("(//div[contains(text(),'First Name')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void LastNameENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Last Name')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Last Name')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void DOB_ENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'DOB')])[2]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("((//div[contains(text(),'DOB')])[2]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void Gender_ENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Gender')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Gender')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void PlanID_ENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Plan ID')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Plan ID')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void EnrollmentFromDate_ENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment From Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment From Date')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void EnrollmentThruDate_ENR() throws InterruptedException {
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment Thru Date')]//following::span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("(//div[contains(text(),'Enrollment Thru Date')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void ATT_Measure() throws InterruptedException {
        sleep(2000);
        $(ProjectsRepo.Measure).click();
        Log.info("Clicked on Measures tab");
        sleep(2000);
        $(MeasureRepo.ATT).click();
        logTestStep("Selecting Hedis ATT measure");
        sleep(2000);
        $(ProjectsRepo.Update).click();
        sleep(10000);
    }

    public void SignatureFirstName_ATT() throws InterruptedException {
        /*$x("(//div[contains(text(),'Does the signature have an acceptable First Name?')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Does the signature have an acceptable First Name?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);*/
    }

    public void SignatureLastName_ATT() throws InterruptedException {
        /*$x("(//div[contains(text(),'Does the signature have an acceptable Last Name?')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Does the signature have an acceptable Last Name?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);*/
    }

    public void SignatureAcceptableCredentials_ATT() throws InterruptedException {
        $x("(//div[contains(text(),'Is the provider signature acceptable?')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Is the provider signature acceptable?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);
    }

    public void SignatureIncludeDate_ATT() throws InterruptedException {
        /*$x("(//div[contains(text(),'Does the signature include a Date?')]//following::input)[1]").setValue("1");
        sleep(2000);
        $x("(//div[contains(text(),'Does the signature include a Date?')]//following::div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])").click();
        sleep(2000);
        $x("(//span[contains(text(),'Yes')])[2]").click();
        sleep(2000);
        $x("//div[@class='coding-container']").click();
        sleep(2000);*/
    }

}