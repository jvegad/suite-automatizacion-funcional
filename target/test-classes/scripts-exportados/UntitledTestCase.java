package com.example;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class UntitledTestCase {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.automationexercise.com/login");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("test");
        driver.findElement(By.xpath("//section[@id='form']/div/div/div[3]/div/form/input[3]")).clear();
        driver.findElement(By.xpath("//section[@id='form']/div/div/div[3]/div/form/input[3]")).sendKeys("testuser6622@test.com");
        driver.findElement(By.xpath("//section[@id='form']/div/div/div[3]/div/form/button")).click();
        driver.get("https://www.automationexercise.com/signup");
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("987654");
        driver.findElement(By.id("days")).click();
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("January");
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("2021");
        driver.findElement(By.id("years")).click();
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("1982");
        driver.findElement(By.id("first_name")).click();
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys("test");
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys("user");
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("testcompany");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("avda siempre viva");
        driver.findElement(By.id("country")).click();
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).clear();
        driver.findElement(By.id("state")).sendKeys("new york");
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("new york");
        driver.findElement(By.id("zipcode")).click();
        driver.findElement(By.id("zipcode")).clear();
        driver.findElement(By.id("zipcode")).sendKeys("88776655");
        driver.findElement(By.id("mobile_number")).clear();
        driver.findElement(By.id("mobile_number")).sendKeys("+166554433");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://www.automationexercise.com/account_created");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
