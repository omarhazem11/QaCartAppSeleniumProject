package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver initializeDriver() {

        String browser = System.getProperty("browser", "CHROME");
        WebDriver driver = switch (browser) {
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
            case "EDGE" -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
            default -> throw new RuntimeException("Browser not supported!");
        };


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        return driver;
    }
}
