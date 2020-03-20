package ru.market.yandex.test;

import Steps.Steps;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YandexMarketStepDefs extends Steps {
    private WebDriver chromeDriver;

    public YandexMarketStepDefs() {
        chromeDriver = getChromeDriver();
    }


    @Then("перейти в раздел '(.*)'")
    public void перейтиВРаздел(String category) {
        chromeDriver.findElement(By.xpath("//div[contains(@class,'PXL2nleaah')]")).click();       //Нажимаем кнопку категории
        chromeDriver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", category))).click(); //Переходим по ссылке Мобильные телефоны
    }

    @Then("установить фильтр по производителю '(.*)'")
    public void установитьФильтрПоПроизводителю(String filter) {
        chromeDriver.findElement(By.xpath(String.format("//div[@class='LhMupC0dLR']/span[contains(text(),'%s')]", filter))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("проверить что в полученной выборке только производитель '(.*)' на '(\\d+)' страницах")
    public void проверитьЧтоВПолученнойВыборкеТолькоПроизводительНаСтраницах(String brand, int pages) {
        WebDriverWait wait = new WebDriverWait(chromeDriver, 2);
        for (int i = 0; i < pages; i++) {
            List<WebElement> nextButtonList = chromeDriver.findElements(By.xpath("//a[contains(@class,'n-pager__button-next')]"));//Кнопка след страницы

            List<WebElement> brandsList = chromeDriver.findElements(By.xpath("//div[@class='n-snippet-cell2__brand-name']"));     //Имена брендов

            brandsList.forEach(x -> Assert.assertEquals(brand.toUpperCase(), x.getText()));

            if (nextButtonList.size() > 0) {      //Если кнопка следующей страницы
                nextButtonList.get(0).click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
                break;
        }
    }
}

