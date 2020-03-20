package Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    private static WebDriver chromeDriver;

    @Step
    public void открытьХром() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step
    public void закрытьХром() {
        chromeDriver.quit();
        chromeDriver = null;
    }

    protected WebDriver getChromeDriver(){
        if(chromeDriver != null)
            return chromeDriver;
        else
            открытьХром();
            return chromeDriver;
    }
}


