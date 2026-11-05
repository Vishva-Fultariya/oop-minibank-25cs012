
public class Driver {

    public static void main(String[] args) {

        String[] passwords = {
            "abc",
            "abcdefgh",
            "Abcdefgh",
            "Abcd1234",
            "Abcd1234!"
        };

        for (String pw : passwords) {

            System.out.println("\nPassword: " + pw);

            System.out.println("Length >= 8: "
                    + PasswordChecker.checkLength(pw));

            System.out.println("Contains uppercase: "
                    + PasswordChecker.checkUppercase(pw));

            System.out.println("Contains digit: "
                    + PasswordChecker.checkDigit(pw));

            System.out.println("Contains special character: "
                    + PasswordChecker.checkSpecialCharacter(pw));

            System.out.println("Strength: "
                    + PasswordChecker.strength(pw));
        }
    }
}
