package ru.netology;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {

    @BeforeAll
    static void setUpAll() {
      SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
      SelenideLogger.removeListener("allure");
    }
    
    @Test
    void shouldPassWhenAccountActive() {
        RegistrationDto account = Generator.active();
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Личный кабинет")).waitUntil(Condition.visible, 2000);
    }

    @Test
    void shouldPassWhenAccountBlocked() {
        RegistrationDto account = Generator.blocked();
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Пользователь заблокирован")).waitUntil(Condition.visible, 2000);
    }

    @Test
    void shouldPassWhenAccountFalseLogin() {
        RegistrationDto account = Generator.falseLogin();
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 2000);
    }

    @Test
    void shouldPassWhenAccountFalsePassword() {
        RegistrationDto account = Generator.falsePassword();
        open("http://localhost:9999");
        $("[name='login']").setValue(account.getLogin());
        $("[name='password']").setValue(account.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 2000);
    }


}
