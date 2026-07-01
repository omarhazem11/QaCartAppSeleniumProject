package com.qacart.todo.testcases;
import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("Login with email and password.")
    @Description("It will login with filling email and password and navigate to todo page")
    @Test (description = "Should be able to login with correct email and password.")
    public void ShouldBeAbleToLoginWithEmailAndPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);

    }
}
