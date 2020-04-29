package MRCS.Locators.HedisRepo;

import org.openqa.selenium.By;

public class HedisCOLRepo {
    public static By ColonoscopyDate=By.xpath("(//div[contains(text(),'Colonoscopy ')]//following::input)[1]");
    public static By ColonoscopyPageNumber=By.xpath("(//div[contains(text(),'Colonoscopy ')]//following::input)[3]");
    public static By SigmoidoscopyDate=By.xpath("(//div[contains(text(),'Flex Sigmoidoscopy ')]//following::input)[1]");
    public static By SigmoidoscopyPageNumber=By.xpath("(//div[contains(text(),'Flex Sigmoidoscopy ')]//following::input)[3]");
    public static By YesButton=By.xpath("(//span[contains(text(),'Yes')])[2]");

}
