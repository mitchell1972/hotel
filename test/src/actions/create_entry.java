package actions;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.Set;

/**
 * Created by mitchell on 14/02/17.
 */
public class create_entry {
    WebElement element;


    public void hotelName(WebDriver dr, String id, DataTable table) {
        Map<String, String> entries = table.asMap(String.class, String.class);
        element = dr.findElement(By.id(id));

        Set<String> tableValue = entries.keySet();
        for (String s : tableValue) {
            switch (s) {
                case "Name":
                    element.sendKeys(entries.get(s));
                    break;

            }

        }
    }

    public void hotelAddress(WebDriver dr, String id, DataTable table) {
        Map<String, String> entries = table.asMap(String.class, String.class);
        element = dr.findElement(By.id(id));

        Set<String> tableValue = entries.keySet();
        for (String s : tableValue) {
            switch (s) {
                case "Address":
                    element.sendKeys(entries.get(s));
                    break;
            }

        }


    }


    public void hotelOwner(WebDriver dr, String id, DataTable table) {
        Map<String, String> entries = table.asMap(String.class, String.class);
        element = dr.findElement(By.id(id));

        Set<String> tableValue = entries.keySet();
        for (String s : tableValue) {
            switch (s) {
                case "Owner":
                    element.sendKeys(entries.get(s));
                    break;
            }

        }
    }

    public void hotelPhoneNumber(WebDriver dr, String id, DataTable table) {
        Map<String, String> entries = table.asMap(String.class, String.class);
        element = dr.findElement(By.id(id));
        Set<String> tableValue = entries.keySet();
        for (String s : tableValue) {
            switch (s) {
                case "Tel":
                    element.sendKeys(entries.get(s));
                    break;
            }

        }
    }

    public void hotelEmail(WebDriver dr, String id, DataTable table) {
        Map<String, String> entries = table.asMap(String.class, String.class);
        element = dr.findElement(By.id(id));
        Set<String> tableValue = entries.keySet();
        for (String s : tableValue) {
            switch (s) {
                case "Email":
                    element.sendKeys(entries.get(s));
                    break;
            }

        }
    }

    public WebElement createButton(WebDriver dr, String id) {
        element = dr.findElement(By.id(id));
        return element;
    }


}
