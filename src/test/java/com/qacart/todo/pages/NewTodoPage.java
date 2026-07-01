package com.qacart.todo.pages;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodo;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submit;

    public TodoPage addTodoItem(String item){
        newTodo.sendKeys(item);
        submit.click();
        return new TodoPage(driver);
    }
    public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEWTODO_ENDPOINT);
        return this;
    }


}
