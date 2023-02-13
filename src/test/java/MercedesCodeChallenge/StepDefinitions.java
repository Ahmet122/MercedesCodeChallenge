package MercedesCodeChallenge;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {

    private WebDriver driver;
    @Given("Open page {string}")
    public void openPage(String url){
        driver=Driver.getDriver();
        driver.get(url);
    }

    @And("Close page")
    public void closePage(){
        driver=Driver.closeDriver();
    }

    @And("Hover {string} element")
    public void hover(String selector) {
        moveToCenter(selector);
        Actions hc = new Actions(driver);
        WebElement area = driver.findElement(By.xpath(selector));
        hc.moveToElement(area).perform();
    }

    @Then("Click the {string}")
    public void click(String selector) throws InterruptedException {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
        moveToCenter(selector);
        button.click();
        Thread.sleep(1000);
    }

    @Then("Enter {string} to {string}")
    public void textBox(String text, String selector){
        driver.findElement(By.xpath(selector)).sendKeys(text);
    }

    @When("Enter {string} to {string} and press enter")
    public void searchBar(String text, String selector) throws InterruptedException {
        driver.findElement(By.xpath(selector)).sendKeys(text, Keys.ENTER);
        Thread.sleep(1000);
    }

    @And("Take the name of {string} item at {int} order")
    public void takeTheNameOfItem(String selector, int order) {
        List<WebElement> item = driver.findElements(By.xpath(selector));
        String text1 = item.get(order).getText();
    }

    @And("Take the names of items {string} {int} and {int}, add items {string} to basket, click {string} and compare the names {string} {int}")
    public void takeTheNamesOfItemsAndAddItemsAndToBasketClickAndCompareTheNamesAnd(String nameI, int order0, int order1, String selectorI, String selectorB, String nameB,int order2) throws InterruptedException {
        WebElement item = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath(selectorI)));
        List<WebElement> itemNameI = driver.findElements(By.xpath(nameI));
        String text1 = itemNameI.get(order0).getText();
        String text2 = itemNameI.get(order1).getText();
        System.out.println(text1);
        System.out.println(text2);
        clickItemWithOrder(selectorI,order0);
        clickItemWithOrder(selectorI,order1);
        //List<WebElement> itemI = driver.findElements(By.xpath(selectorI));
        //itemI.get(order0).click();
        //Thread.sleep(1000);
        //itemI.get(order1).click();
        driver.findElement(By.xpath(selectorB)).click();
        List<WebElement> itemNameB = driver.findElements(By.xpath(nameB));
        String text3 = itemNameB.get(order0).getText();
        String text4 = itemNameB.get(order2).getText();
        System.out.println(text3);
        System.out.println(text4);
        Assert.assertEquals(text1, text4);
        Assert.assertEquals(text2, text3);
    }

    @And("Wait for element {string}")
    public void waitForElement(String selector) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
    }

    @And("The number of element {string}")
    public void numberOfItemMustBe(String selector) {
        WebElement number = driver.findElement(By.xpath(selector));
    }

    @And("Click item {string} in order {int}")
    public void clickItemWithOrder(String selector, int order) throws InterruptedException {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
        List<WebElement> item = driver.findElements(By.xpath(selector));
        item.get(order).click();
        Thread.sleep(1000);
    }

    @And("Select date {string}")
    public void selectDate(String date) {
        int d = (int)((Math.random() * (28 - 1)) + 1);
        System.out.println(d);
        String date1 = date + d + "']";
        driver.findElement(By.xpath(date1)).click();
    }

    @And("Select month {string}")
    public void selectMonth(String month) {
        int d = (int)((Math.random() * (12 - 1)) + 1);
        System.out.println(d);
        String month1 = month + d + "']";
        System.out.println(month1);
        driver.findElement(By.xpath(month1)).click();
    }

    @Then("Select year {string}")
    public void selectYear(String year) {
        int d = (int)((Math.random() * (2005 - 1950)) + 1950);
        System.out.println(d);
        String year1 = year + d + "']";
        System.out.println(year1);
        driver.findElement(By.xpath(year1)).click();
    }
    @Then("Move to center {string}")
    public void moveToCenter(String selector) {
        WebElement element = driver.findElement(By.xpath(selector));

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }
}
