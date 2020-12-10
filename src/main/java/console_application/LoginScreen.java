package console_application;

import model.domain.userLog.UserLogPasChecker;

import java.util.Scanner;

public class LoginScreen {
    private LoginScreen() {
    }

    public static void createWelcome() {
        System.out.print("Welcome in mbank\n" +
                "if you want log in, write 1\n" +
                "if you want register, write 2\n" +
                "if you want exit, write 3\n");
        selectActionLogin();
    }

    private static void selectActionLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWhat do you want to do: ");
        int selectionNumber = scanner.nextInt();
        scanner.nextLine();
        try {
            if (selectionNumber == 1) {
                System.out.print("login: ");
                String login = scanner.nextLine();
                System.out.print("password: ");
                String password = scanner.nextLine();
                int idUserChecker = UserLogPasChecker.checkAccount(login, password);
                AccountConsole accountConsole = new AccountConsole(idUserChecker);
                accountConsole.openAccount();
            } else if (selectionNumber == 2) {
                SignUpConsole signUpConsole = new SignUpConsole();
                signUpConsole.createNewAccount();
            } else if (selectionNumber == 3) {
                System.exit(0);
            } else {
                throw new IllegalArgumentException("incorrect number of action ");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            if (WrongDataInAccountScript.whatNextAfterWrongData()) {
                selectActionLogin();
            } else {
                System.exit(0);
            }
        }
    }
}