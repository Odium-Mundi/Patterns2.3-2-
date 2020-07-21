package ru.netology;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;


public class Generator {
    public static String getLogin() {
        List<String> givenList = Arrays.asList("vasya", "honor", "samsa");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }

    public static String getPassword() {
        List<String> givenList = Arrays.asList("12345", "54321", "777666");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }


    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @BeforeAll
    static void setUpAll(RegistrationDto registrationDto) {
        // сам запрос
        RestAssured.given() // "дано"
                .spec(requestSpec) // указываем, какую спецификацию используем
                .body(registrationDto) // передаём в теле объект, который будет преобразован в JSON
                .when() // "когда"
                .post("/api/system/users") // на какой путь, относительно BaseUri отправляем запрос
                .then() // "тогда ожидаем"
                .statusCode(200); // код 200 OK
    }


    public static RegistrationDto active() {

        RegistrationDto active = new RegistrationDto(
                getLogin(),
                getPassword(),
                "active");
        setUpAll(active);
        return active;
    }

    @NotNull
    public static RegistrationDto blocked() {
        RegistrationDto blocked = new RegistrationDto(
                getLogin(),
                getPassword(),
                "blocked");
        setUpAll(blocked);
        return blocked;
    }

    @NotNull
    public static RegistrationDto falseLogin() {
        String login = getLogin();
        String password = getPassword();
        String status = "active";
        RegistrationDto registrationDto1 = new RegistrationDto(login, password, status);
        RegistrationDto registrationDto2 = new RegistrationDto("abradabra", password, status);
        setUpAll(registrationDto1);
        return registrationDto2;
    }

    @NotNull
    public static RegistrationDto falsePassword() {
        String login = getLogin();
        String password = getPassword();
        String status = "active";
        RegistrationDto registrationDto1 = new RegistrationDto(login, password, status);
        RegistrationDto registrationDto2 = new RegistrationDto(login, "abrakadabra", status);
        setUpAll(registrationDto1);
        return registrationDto2;
    }
}
