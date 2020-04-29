package MRCS.Modules.Hedis;

import MRCS.Locators.CommonRepo;
import MRCS.Locators.MeasureRepo;
import MRCS.Locators.Projects.ProjectsRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MRCS.Utils.Common.ClickElement;
import static MRCS.Utils.WaitTool.waitForElementToBeClickable;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class HedisW15 {

    public static void NavigateToW15() throws Exception {
//        Common.getUserAndAssignTo();
//        $(ProjectsRepo.Measure).click();
//        Log.info("Clicked on Measures tab");
//        sleep(2000);
//        $(MeasureRepo.W15).click();
//        sleep(2000);
//        $(ProjectsRepo.Update).click();
//        sleep(10000);
//        logTestStep("Clicking on First chase id");
//        $x("//tr[1]//td[2]").click();
//        logTestStep("Clicking on Chart");
//        sleep(2000);
//        $(RetrievalRepo.Chart).click();
//        Common.waitForPageLoadToComplete();
//        sleep(5000);
        String user = Common.GetUserName();
        System.out.println(user);
        Log.info("Clicked on Measures tab");
        Common.selectMeasure();
        ClickElement(MeasureRepo.W15, "Selecting");
        ClickElement(ProjectsRepo.Update, "Clicking on Update");
        Common.waitForLoader();
        //Common.waitForPageLoadToComplete();
        waitForElementToBeClickable(By.xpath("//tr[1]//th[1]")).click();
        waitForElementToBeClickable(CommonRepo.assignChase).click();
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(user);
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ARROW_DOWN);
        Selenide.sleep(2000);
        $(CommonRepo.assignChaseToUser).sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        waitForElementToBeClickable(CommonRepo.assignButton).click();
        Common.waitForLoader();
        Common.SelectChaseAndOpenChart();
    }

    public static void DeleteNumerator() throws InterruptedException {
        if ($x("//button[@title='Delete']").isDisplayed()) {
            int Delete1 = $$x("//button[contains(text(),'×')]").size();
            for (int i = 1; i <= Delete1 - 1; i++) {
                $x("//button[contains(text(),'×')]").click();
                sleep(2000);
            }

        }
    }

    public static void PositiveCompliance() throws InterruptedException {
        sleep(2000);
        String DOB = $x("//div[contains(text(),'DOB')]//following::div[1]").getText();
        sleep(2000);
        System.out.println(DOB);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(DOB));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.MONTH, 14);
        String newDate = sdf.format(cal.getTime());
        System.out.println("new date" + newDate);
        try {
            cal.setTime(sdf.parse(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String Date2 = newDate;
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
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
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
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
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'Health History')]"));
        $x("//div[contains(text(),'Health History')]//following::button[@title='Add a new \"Health History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Health History')]//following::input[@id='Date'])[1]").setValue(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Health History')]//following::input[@id='PageNumber'])[1]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Health History')]//following::button[@title='Add a new \"Health History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Health History')]//following::input[@id='Date'])[2]").setValue(newDate1);
        sleep(2000);
        $x("(//div[contains(text(),'Health History')]//following::input[@id='PageNumber'])[2]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Health History')]//following::button[@title='Add a new \"Health History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Health History')]//following::input[@id='Date'])[3]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'Health History')]//following::input[@id='PageNumber'])[3]").setValue("1");
        sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'Physical Exam')]"));
        $x("//div[contains(text(),'Physical Exam')]//following::button[@title='Add a new \"Physical Exam\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Physical Exam')]//following::input[@id='Date'])[1]").setValue(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Exam')]//following::input[@id='PageNumber'])[1]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Physical Exam')]//following::button[@title='Add a new \"Physical Exam\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Physical Exam')]//following::input[@id='Date'])[2]").setValue(newDate1);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Exam')]//following::input[@id='PageNumber'])[2]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Physical Exam')]//following::button[@title='Add a new \"Physical Exam\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Physical Exam')]//following::input[@id='Date'])[3]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Exam')]//following::input[@id='PageNumber'])[3]").setValue("1");
        sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'Mental Development History')]"));
        $x("//div[contains(text(),'Mental Development History')]//following::button[@title='Add a new \"Mental Development History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Mental Development History')]//following::input[@id='Date'])[1]").setValue(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Mental Development History')]//following::input[@id='PageNumber'])[1]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Mental Development History')]//following::button[@title='Add a new \"Mental Development History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Mental Development History')]//following::input[@id='Date'])[2]").setValue(newDate1);
        sleep(2000);
        $x("(//div[contains(text(),'Mental Development History')]//following::input[@id='PageNumber'])[2]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Mental Development History')]//following::button[@title='Add a new \"Mental Development History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Mental Development History')]//following::input[@id='Date'])[3]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'Mental Development History')]//following::input[@id='PageNumber'])[3]").setValue("1");
        sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'Health Education / Ant Guidance')]"));
        $x("//div[contains(text(),'Health Education / Ant Guidance')]//following::button[@title='Add a new \"Health Education / Ant Guidance\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input[@id='Date'])[1]").setValue(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input[@id='PageNumber'])[1]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Health Education / Ant Guidance')]//following::button[@title='Add a new \"Health Education / Ant Guidance\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input[@id='Date'])[2]").setValue(newDate1);
        sleep(2000);
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input[@id='PageNumber'])[2]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Health Education / Ant Guidance')]//following::button[@title='Add a new \"Health Education / Ant Guidance\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input[@id='Date'])[3]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'Health Education / Ant Guidance')]//following::input[@id='PageNumber'])[3]").setValue("1");
        sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", $x("//div[contains(text(),'Physical Development History')]"));
        $x("//div[contains(text(),'Physical Development History')]//following::button[@title='Add a new \"Physical Development History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Physical Development History')]//following::input[@id='Date'])[1]").setValue(newDate);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Development History')]//following::input[@id='PageNumber'])[1]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Physical Development History')]//following::button[@title='Add a new \"Physical Development History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Physical Development History')]//following::input[@id='Date'])[2]").setValue(newDate1);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Development History')]//following::input[@id='PageNumber'])[2]").setValue("1");
        sleep(2000);
        $x("//div[contains(text(),'Physical Development History')]//following::button[@title='Add a new \"Physical Development History\"']").click();
        sleep(2000);
        $x("(//div[contains(text(),'Physical Development History')]//following::input[@id='Date'])[3]").setValue(newDate2);
        sleep(2000);
        $x("(//div[contains(text(),'Physical Development History')]//following::input[@id='PageNumber'])[3]").setValue("1");
        sleep(2000);

    }
}
