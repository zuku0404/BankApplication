package console_application;

import java.util.Scanner;

class WrongDataInAccountScript {
    private WrongDataInAccountScript() {
    }

    public static boolean whatNextAfterWrongData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want try again y/n: ");
        String decisionYesOrNo = scanner.nextLine();
        if (decisionYesOrNo.equalsIgnoreCase("y")) return true;
        else if (decisionYesOrNo.equalsIgnoreCase("n")) return false;
        else {
            System.out.println("this option not exist");
            WrongDataInAccountScript.whatNextAfterWrongData();
            return false;
        }
    }
}
