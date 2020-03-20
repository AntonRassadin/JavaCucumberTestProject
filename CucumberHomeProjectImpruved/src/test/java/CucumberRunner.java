import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"},
        features = "src/test/java/features",
        glue = {"ru.yandex.test","ru.open.test","Steps","ru.market.yandex.test"},
        tags = {"@otlad"}
)
public class CucumberRunner {

}