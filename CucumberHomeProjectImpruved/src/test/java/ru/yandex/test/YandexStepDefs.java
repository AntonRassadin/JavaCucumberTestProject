package ru.yandex.test;

import Locators.Locators;
import Steps.Steps;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YandexStepDefs extends Steps{
    private WebDriver chromeDriver;
    public YandexStepDefs(){
        chromeDriver = getChromeDriver();
    }

    @Then("ввести в поиск '(.*)'")
    public void ввести_в_поиск(String text) {
        WebElement input = chromeDriver.findElement(Locators.yandexSearchInput);
        input.click();
        input.sendKeys(text);
    }

    @Then("нажать поиск")
    public void нажатьПоиск() {
        chromeDriver.findElement(Locators.yandexSearchButton).click();
    }

    @Then("найти в результатах ссылку '(.*)'")
    public void найти_в_результатах_ссылку (String link) {
        List<WebElement> itemsList = chromeDriver.findElements(By.xpath(String.format("//h2/a[@href='%s']", link))); //ссылки https://ru.wikipedia.org/wiki/Шпажник в результатах поиска
        boolean check = false;
        if(itemsList.size()>0){
            check = true;
        }
        Assert.assertTrue("Ссылки на википедию нет", check);
    }

}
