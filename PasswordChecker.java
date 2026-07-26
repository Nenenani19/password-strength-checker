import java.util.Scanner;

public class PasswordChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        checkStrength(password);
    }

    public static void checkStrength(String password) {

        int score = 0;

        //Length check
        if (password.length() >= 8) {
            score++;
        }

        //Uppercase check
        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        //Lowercase check
        if (password.matches(".*[a-z].*")) {
            score++;
        }

        //Digit check
        if (password.matches(".*[0-9].*")) {
            score++;
        }

        //Special character check
        if (password.matches(".*[@#$%^&+=!].*")) {
            score++;
        }

        //Result
        if (score <= 2) {
            System.out.println("Weak Password ❌");
            suggestImprovements(password);
        } else if (score == 3 || score == 4) {
            System.out.println("Medium Password ⚠️");
            suggestImprovements(password);
        } else {
            System.out.println("Strong Password ✅");
        }
    }

    public static void suggestImprovements(String password) {

        if (password.length() < 8) {
            System.out.println("- Make it at least 8 characters long");
        }
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("- Add uppercase letters");
        }
        if (!password.matches(".*[a-z].*")) {
            System.out.println("- Add lowercase letters");
        }
        if (!password.matches(".*[0-9].*")) {
            System.out.println("- Add numbers");
        }
        if (!password.matches(".*[@#$%^&+=!].*")) {
            System.out.println("- Add special characters (@, #, !, etc.)");
        }
    }
}