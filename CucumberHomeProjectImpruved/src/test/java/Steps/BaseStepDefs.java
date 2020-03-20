package Steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class BaseStepDefs extends Steps{

    private WebDriver chromeDriver;
    @Given("запустить Chrome")
    public void запуститьChrome() {
        chromeDriver = getChromeDriver();
    }

    @Then("перейти на сайт '(.*)'")
    public void перейти_на_сайт(String site) {
        chromeDriver.get(site);
    }

    @After
    @Then("завершить работу")
    public void завершитьРаботу(){
        закрытьХром();
    }


}
