package com.qacart.todo.testcases;
import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.api.AddTaskApi;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {
    @Story("Add todo.")
    @Test (description = "Should be able to add new todo item.")
    public void ShouldBeAbleToAddNewTodo() {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualTodo =
                newTodoPage
                        .load()
                        .addTodoItem("Test todo")
                        .getTodoItem();

        Assert.assertEquals(actualTodo,"Test todo");
    }
    @Story("Delete todo.")

    @Test (description = "Should be able to delete todo item.")
    public void ShouldBeAbleToDeleteTodo() {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        AddTaskApi addTaskApi = new AddTaskApi();
        addTaskApi.addTask(registerApi.getToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());

       boolean isWelcomeDisplayed = todoPage
                .load()
                .deleteItem()
                .isNoTodoMessageDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);

    }
}
