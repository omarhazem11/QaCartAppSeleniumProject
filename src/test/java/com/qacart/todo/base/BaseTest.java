package com.qacart.todo.base;

import com.qacart.todo.Utils.CookieUtils;
import com.qacart.todo.factory.DriverFactory;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    public void setup(){
        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
    }

    @AfterMethod
    public void teardown(){
        getDriver().quit();
    }

    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie: seleniumCookies){
            driver.get().manage().addCookie(cookie);
        }
    }
}