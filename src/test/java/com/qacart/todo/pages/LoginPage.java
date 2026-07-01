package com.qacart.todo.pages;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.Utils.PropertiesUtils;
import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;



    public TodoPage login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }

    public LoginPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

}
