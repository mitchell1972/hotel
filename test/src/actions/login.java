package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mitchell on 14/02/17.
 */
public class login {
    WebElement e;

    public WebElement login(WebDriver dr, String xpath){
        e = dr.findElement(By.xpath(xpath));
        return e;
    }

    public WebElement userName(WebDriver dr, String id){
        e = dr.findElement(By.id(id));
        return e;
    }
    public WebElement passWord(WebDriver dr, String id){
        e = dr.findElement(By.id(id));
        return e;
    }

    public WebElement loginButton(WebDriver dr, String id){
        e = dr.findElement(By.id(id));
        return e;
    }
}
