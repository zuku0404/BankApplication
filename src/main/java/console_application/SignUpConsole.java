package console_application;

import controller.RegisterController;
import controller.RegisterDetails;

import java.util.Scanner;

public class SignUpConsole {
    private Scanner scanner = new Scanner(System.in);

    public void createNewAccount() {
        System.out.println("create new Account");
        System.out.print("password: ");
        String password = scanner.nextLine();
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("surname: ");
        String surname = scanner.nextLine();
        System.out.print("birthday date: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("pesel: ");
        String pesel = scanner.nextLine();

        RegisterDetails registerDetails = new RegisterDetails(password, pesel, dateOfBirth, name, surname);
        RegisterController registerController = new RegisterController();
        try {
            String loginOrError = registerController.createUserAndGetUserId(registerDetails);
            System.out.println("Account has been created, your login is " + loginOrError);
            LoginScreen.createWelcome();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            if (WrongDataInAccountScript.whatNextAfterWrongData()) {
                createNewAccount();
            } else {
                LoginScreen.createWelcome();
            }
        }
    }
}