package com.suite.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Leccion2_SeleniumIDETest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void registroTestCase() throws Exception {
        driver.get("https://www.automationexercise.com/login");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("test");
        driver.findElement(By.xpath("//section[@id='form']/div/div/div[3]/div/form/input[3]")).clear();
        driver.findElement(By.xpath("//section[@id='form']/div/div/div[3]/div/form/input[3]")).sendKeys("testuser54322@test.com");
        driver.findElement(By.xpath("//section[@id='form']/div/div/div[3]/div/form/button")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("987654");
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("1");
        driver.findElement(By.xpath("//option[@value='1']")).click();
        driver.findElement(By.id("months")).click();
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("January");
        driver.findElement(By.xpath("//select[@id='months']/option[2]")).click();
        driver.findElement(By.id("years")).click();
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("2000");
        driver.findElement(By.xpath("//option[@value='2000']")).click();
        driver.findElement(By.id("first_name")).click();
        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys("test");
        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys("user");
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys("test company");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("avda siempre viva");
        driver.findElement(By.id("country")).click();
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");
        driver.findElement(By.xpath("//option[@value='United States']")).click();
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).clear();
        driver.findElement(By.id("state")).sendKeys("ohio");
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("ohio cuty");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("ohio city");
        driver.findElement(By.id("zipcode")).click();
        driver.findElement(By.id("zipcode")).clear();
        driver.findElement(By.id("zipcode")).sendKeys("22334455");
        driver.findElement(By.id("mobile_number")).click();
        driver.findElement(By.id("mobile_number")).clear();
        driver.findElement(By.id("mobile_number")).sendKeys("+166778899");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void LoginTestCase() throws Exception {
        driver.get("https://www.automationexercise.com/login");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("testuser54321@test.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("987654");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("Logout")).click();
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
