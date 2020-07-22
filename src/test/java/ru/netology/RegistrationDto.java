package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class RegistrationDto {
    public String login;
    public String password;
    public String status;


}