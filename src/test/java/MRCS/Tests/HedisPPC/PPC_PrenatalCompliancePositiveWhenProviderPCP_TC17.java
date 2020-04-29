package MRCS.Tests.HedisPPC;

import MRCS.Modules.LoginOut;
import MRCS.Modules.Risk;
import MRCS.Utils.TestBase;
import org.testng.annotations.Test;

import static MRCS.Utils.Common.ClickElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class PPC_PrenatalCompliancePositiveWhenProviderPCP_TC17 extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    Risk objRisk= new Risk();
    PPC_VerifyPrenatalComplianceShowsPositive_TC16 objPPC=new PPC_VerifyPrenatalComplianceShowsPositive_TC16();

    @Test( description = "Verify that when  Provider Type = PCP then Visit Type must = Pregnancy Diagnosis  for prenatal +ve compliance", groups = {"Hedis PPC"} )
    public void PPC_PrenatalCompliancePositiveWhenProviderPCP() throws Exception {
            objPPC.PPC_VerifyPrenatalComplianceShowsPositive();
    }
}
