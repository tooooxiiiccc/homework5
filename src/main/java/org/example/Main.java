package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String firstName = "Danya";
        String lastName = "Morozov";
        String middleName = "Vladislavovich";

        CreateUser user = new CreateUser(firstName, lastName, middleName);
        }
    }