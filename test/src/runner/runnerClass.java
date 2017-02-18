package runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by mitchell on 14/02/17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"specs/"}, glue={"steps"})
public class runnerClass {
}
