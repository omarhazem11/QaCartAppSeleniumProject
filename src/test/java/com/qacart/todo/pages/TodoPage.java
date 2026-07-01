package com.qacart.todo.pages;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement add;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement delete;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodo;


    public boolean isWelcomeMessageDisplayed(){
       return welcomeMessage.isDisplayed();
    }

    public NewTodoPage clickAdd(){
        add.click();
       return new NewTodoPage(driver);
    }

    public String getTodoItem(){
        return todoItem.getText();
    }

    public TodoPage deleteItem(){
        delete.click();
        return this;
    }
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_ENDPOINT);
        return this;
    }

    public boolean isNoTodoMessageDisplayed(){
        return noTodo.isDisplayed();
    }

}
