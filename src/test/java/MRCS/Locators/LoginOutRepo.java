package MRCS.Locators;

import org.openqa.selenium.By;

public class LoginOutRepo {

    public static By TxtUsername=By.xpath("//input[contains(@type,'text')]");
    public static By TxtPassword=By.xpath("//input[contains(@type,'password')]");
    public static By BtnSIGNIN=By.xpath("//button[contains(.,'SIGN IN')]");
    public static By NavigationBar=By.cssSelector(".fa.fa-bars");
    public static By UatAdmin=By.xpath("//div[@class='account-menu']");
    public static By Logout=By.xpath("//div[@class='menu--item'][contains(.,'Logout')]");


}