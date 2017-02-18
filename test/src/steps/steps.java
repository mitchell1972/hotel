package steps;

import actions.create_entry;
import actions.delete_entry;
import actions.login;
import actions.logout;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by mitchell on 14/02/17.
 */
public class steps {

    WebElement element;
    int hotelCount;

    WebDriver driver;
    login lg = new login();
    create_entry create = new create_entry();
    delete_entry delete = new delete_entry();
    logout l_out = new logout();

    @Before
    public void setDriver() {

        hotelCount = 2;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Given("^a user is on the hotel booker platform$")
    public void a_user_is_on_the_hotel_booker_platform() {

        driver.get("http://localhost:3003/");
    }


    @Given("^the user is logged in$")
    public void the_user_is_logged_in() {
        lg.login(driver, "/html/body/div/nav/div[1]/ul/li[2]/a").click();
        lg.userName(driver, "username").sendKeys("admin");
        lg.passWord(driver, "password").sendKeys("password");
        lg.loginButton(driver, "doLogin").click();
        WebElement logout = driver.findElement(By.id("logout"));
        Assert.assertTrue(logout.isDisplayed());
    }

    @When("^the following hotel details are entered and created:$")
    public void the_following_hotel_details_are_entered_and_created(DataTable arg) {
        create.hotelName(driver, "hotelName", arg);
        create.hotelAddress(driver, "address", arg);
        create.hotelOwner(driver, "owner", arg);
        create.hotelPhoneNumber(driver, "phone", arg);
        create.hotelEmail(driver, "email", arg);
        create.createButton(driver, "createHotel").click();
    }


    @When("^the (.*) username and (.*) is entered$")
    public void the_admin_username_and_password_is_entered(String username, String password) {
        lg.login(driver, "/html/body/div/nav/div[1]/ul/li[2]/a").click();
        lg.userName(driver, "username").sendKeys(username);
        lg.passWord(driver, "password").sendKeys(password);
        lg.loginButton(driver, "doLogin").click();


    }

    @When("^the logout menu is clicked$")
    public void the_logout_menu_is_clicked() {
        l_out.logOut(driver, "logout").click();
    }

    @Then("^the page is updated with the following$")
    public void the_page_is_updated_with_the_following(DataTable arg) {

        try {
            for (int i = 0; i <= 100; i++) {
                WebElement hotel = driver.findElement(By.xpath("/html/body/div/div[" + hotelCount + "]/div[1]/div[1]/p"));

                if (driver.findElement(By.xpath("/html/body/div/div[" + hotelCount + "]/div[1]/div[1]/p")).isDisplayed()) {
                    hotelCount++;
                } else if (!driver.findElement(By.xpath("/html/body/div/div[" + hotelCount + "]/div[1]/div[1]/p")).isDisplayed()) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[" + (hotelCount - 1) + "]/div[1]/div[1]/p")).getText(), arg.raw().get(0).get(0));

        }
    }

    @Then("^the user is successfull logged in$")
    public void the_user_is_successfull_logged_in() {
        WebElement logout = driver.findElement(By.id("logout"));
        Assert.assertTrue(logout.isDisplayed());
    }

    @Then("^the user is logged out$")
    public void the_user_is_logged_out() {

    }

    @Then("^the logout menu is updated toa login menu$")
    public void the_logout_menu_is_updated_toa_login_menu() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/nav/div[1]/ul/li[2]/a")).isDisplayed());
    }


}
