package util;

import java.util.regex.Pattern;

public class Validator {

    private Validator() {
        // Utility class; prevent object creation.
    }

    public static boolean isValidMobile(String mobile) {
        return mobile != null && Pattern.matches("[6-9][0-9]{9}", mobile);
    }

    public static boolean isValidEmail(String email) {
        return email != null
                && Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
    }

    public static boolean isValidPan(String pan) {
        return pan != null
                && Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]", pan);
    }

    public static boolean isValidIfsc(String ifsc) {
        return ifsc != null
                && Pattern.matches("[A-Z]{4}0[A-Z0-9]{6}", ifsc);
    }
}