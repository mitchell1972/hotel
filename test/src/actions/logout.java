package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mitchell on 14/02/17.
 */
public class logout {
    WebElement e;

    public WebElement logOut(WebDriver dr, String id){
        e = dr.findElement(By.id(id));
        return e;
    }

}
