package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        //Thread.sleep(7000);
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        //Thread.sleep(7000);
        driver.findElement(By.className("btn")).click();

        String expectedURL = "practicetestautomation.com/logged-in-successfully/";
        if (driver.getCurrentUrl().contains(expectedURL)) {
            System.out.println("URL verification successful.");
        } else {
            System.out.println("URL verification failed.");
        }

        String expectedText = "Congratulations";
        WebElement body = driver.findElement(By.tagName("body"));
        if (body.getText().contains(expectedText)) {
            System.out.println("Text verification successful.");
        } else {
            System.out.println("Text verification failed.");
        }

        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']"));
        if (logoutButton.isDisplayed()) {
            System.out.println("Logout button is displayed.");
        } else {
            System.out.println("Logout button is not displayed.");
        }

        Thread.sleep(5000);
        driver.quit();

    }
}