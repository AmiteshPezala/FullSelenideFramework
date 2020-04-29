package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisTRCRepo {
    public static By InpatientAdmissionDate=By.xpath("(//div[contains(text(),'Notification of Inpatient Admission')]//following::input)[1]");
    public static By InpatientAdmissionPageNumber=By.xpath("(//div[contains(text(),'Notification of Inpatient Admission')]//following::input)[2]");
    public static By InformationOfDischargeInformationDate=By.xpath("(//div[contains(text(),'Notification of Discharge Information')]//following::input)[1]");
    public static By InformationOfDischargeInformationPage=By.xpath("(//div[contains(text(),'Notification of Discharge Information')]//following::input)[3]");
    public static By InformationOfDischargeInformationDropdwon=By.xpath("(//div[contains(text(),'Notification of Discharge Information')]//following::button)[1]");
    public static By YesButton=By.xpath("(//span[contains(text(),'Yes')])[2]");
    public static By PatientEngagementAfterDischargeDate=By.xpath("(//div[contains(text(),'Notification of Patient Engagement After Discharge')]//following::input)[1]");
    public static By PatientEngagementAfterDischargePage=By.xpath("(//div[contains(text(),'Notification of Patient Engagement After Discharge')]//following::input)[2]");
    public static By MedicationReconciliationAfterDischargeDate=By.xpath("(//div[contains(text(),'Medication Reconciliation After Discharge')]//following::input)[1]");
    public static By MedicationReconciliationAfterDischargePage=By.xpath("(//div[contains(text(),'Medication Reconciliation After Discharge')]//following::input)[3]");
    public static By MedicationReconciliationAfterDischargeDrop=By.xpath("(//div[contains(text(),'Medication Reconciliation After Discharge')]//following::button)[1]");
    public static By NRCDropDown=By.cssSelector(".ui-autocomplete-dropdown");


}
