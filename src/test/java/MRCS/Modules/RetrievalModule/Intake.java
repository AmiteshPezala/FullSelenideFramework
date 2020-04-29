package MRCS.Modules.RetrievalModule;
import MRCS.Locators.RetrievalRepo.IntakeRepo;
import MRCS.Locators.RetrievalRepo.RetrievalRepo;
import MRCS.Utils.Common;
import MRCS.Utils.Log;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static MRCS.Utils.Common.DEFAULT_WAIT;
import static MRCS.Utils.TestBase.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Intake {
     public static void NavigateToDocIntakePage() throws Exception {
         logTestStep("Clicking on Retrieval link");
         Common.ClickElement(RetrievalRepo.RetrievalLink,"Retrival Link");
         logTestStep("Clicking on Doc Intake link");
         Common.ClickElement(RetrievalRepo.DocIntake,"Doc Intake");
         Log.info("Clicked on Doc Intake");
         sleep(5000);
     }
     public static void VerifySuccessfulAssign() throws Exception {
         Common.ClickElement(IntakeRepo.AcceptButton,"Accept Button");
         sleep(2000);
         //WebElement ActualMessage=$x("//span[contains(text(),'Chase assign successful')]");
         //String ExpectedMessage="Chase assign successful";
         if($(IntakeRepo.ToasterMsg).waitUntil(visible, DEFAULT_WAIT).isDisplayed())
         {
             logTestStepPass("Chase Assign Successful");
         }
         else
         {
             logTestStepFail("Chase Not Assign Successful");
             Assert.fail("Chase Not Assign Successful");
         }
     }
     public static void LowestPageNumber()
     {
         ElementsCollection rows=$$(".ui-table table tbody tr");
         if(rows.isEmpty())
         {
             //No row found
             logTestStep("No row found");
         }
         SelenideElement rowToClick =null;
         int lowestPageNumberValue =5000;

         for (SelenideElement row : rows) {
             int pageNumber=Integer.parseInt(row.$("td",5).text());
             if(pageNumber <lowestPageNumberValue){
                 rowToClick =row;
                 lowestPageNumberValue=pageNumber;
             }
         }
         //At the end we have a Row with lowest page number

         //Now click on chase Id
         rowToClick.$(".ui-column-value.ng-star-inserted",0).click();
         sleep(5000);
     }
     public static void ViewPage()
     {
         String value=$x("//app-document-page-viewer/div/div[7]/div[2]/span").getText();
         System.out.println("value = " + value);
         String[] arrSplit_3 = value.split("\\s");    // Splitting the line "Top 699 records"
         String count1 = null;
         for (int i = 2; i < 3; i++) {
             count1 = arrSplit_3[i];
             break;

         }
         sleep(2000);
         System.out.println("count1  = " + count1);
         int count=Integer.parseInt(count1);
         System.out.println(count);
         for(int i=1;i<=count;i++){
             $$(".fa.fa-play").filter(Condition.visible).last().click();
//             sleep(5000);
             Common.waitForLoader();
             //break;
         }
     }
}
