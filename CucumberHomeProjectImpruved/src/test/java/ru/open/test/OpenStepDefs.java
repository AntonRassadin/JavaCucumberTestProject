package ru.open.test;
import Locators.Locators;
import Steps.Steps;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class OpenStepDefs extends Steps {
    WebDriver chromeDriver;
    public OpenStepDefs() {
        chromeDriver = getChromeDriver();
    }

    @Then("написать в строке поиска '(.*)'")
    public void написатьВСтрокеПоиска(String text) {
        WebElement input = chromeDriver.findElement(Locators.googleSearchInput);
        input.click();
        input.sendKeys(text);
    }

    @Then("нажать Поиск")
    public void нажатьПоиск() {
        chromeDriver.findElement(Locators.googleSubmitSearchButton).click();
    }

    @Then("проверить, что результатах поиска есть '(.*)'")
    public void проверитьЧтоРезультатахПоискаЕсть(String link) {

        WebElement linkToSite = chromeDriver.findElement(By.xpath(String.format("//a[@href='%s']", link))); //https://www.open.ru from google search
        Assert.assertTrue(linkToSite != null);
    }

    @Then("проверить в блоке «Курс обмена в интернет-банке», что курс продажи больше курса покупки, для USD и для EUR.")
    public void проверитьВБлокеКурсОбменаВИнтернетБанкеЧтоКурсПродажиБольшеКурсаПокупкиДляUSDИДляEUR() {
        List<Double> exchangeRates = chromeDriver.findElements(Locators.openRuExchangeTableRates).stream()
                .map(x->Double.parseDouble(x.getText().replace(",",".")))
                .collect(Collectors.toList());
        Assert.assertTrue(exchangeRates.get(1) > exchangeRates.get(0));
        Assert.assertTrue(exchangeRates.get(3) > exchangeRates.get(2));
    }

}
