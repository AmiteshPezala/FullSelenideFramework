package MRCS.Locators;

import org.openqa.selenium.By;

public class AdminRepo {
    public static By Admin=By.xpath("//span[@class='ui-menuitem-text'][contains(text(),'Admin')]");
    public static By ProjectsAdmin=By.xpath("(//span[contains(text(),'Projects')])[2]");
    public static By User=By.xpath("//span[contains(text(),'User')]");
    public static By Organization=By.xpath("//span[contains(text(),'Organization')]");
}
