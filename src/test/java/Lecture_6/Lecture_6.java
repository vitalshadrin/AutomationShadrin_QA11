package Lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lecture_6 {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void aboveTest() {
        WebElement password = driver.findElement((By.id("password")));
        driver.findElement(with(By.tagName("input")).above(password));
    }

    @Test(priority = 2)
    public void belowTest() {
        WebElement userName = driver.findElement((By.id("user-name")));
        driver.findElement(with(By.tagName("input")).below(userName));
    }

    @Test(priority = 3)
    public void toRightOfTest() {
        WebElement credentials = driver.findElement(By.cssSelector("#login_credentials h4"));
        System.out.println(driver.findElement(with(By.tagName("h4")).toRightOf(credentials)).getText());
    }


    @Test(priority = 4)
    public void toLeftOfTest() {
        WebElement passwords = driver.findElement(By.cssSelector(".login_password h4"));
        System.out.println(driver.findElement(with(By.tagName("h4")).toLeftOf(passwords)).getText());
    }

    @Test(priority = 5)
    public void nearTest() {
        WebElement password = driver.findElement((By.id("password")));
        driver.findElement(with(By.cssSelector("[placeholder]")).near(password)).sendKeys("near");
        driver.findElement(with(By.tagName("input")).near(password)).sendKeys("near");
    }


    @AfterTest
    public void close() {
        driver.quit();
    }
}
