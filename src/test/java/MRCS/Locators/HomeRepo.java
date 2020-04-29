package MRCS.Locators;

import org.openqa.selenium.By;

public class HomeRepo {

    public static By Home=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Home')]");
    public static By MyStites=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'My Sites')]");
    public static By MyDocuments=By.xpath("//span[contains(.,'My Documents')]");
    public static By MyChases=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'My Chases')]");
    public static By Filter=By.xpath("//button[contains(.,'FILTERS')]");
}