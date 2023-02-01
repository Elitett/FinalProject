import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String EMAIL_PATTERN =  "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String NAME_PATTERN =  "^[A-Za-z ']+$";
    private static final String TEAM_PATTERN =  "^[\\w. -]+$";

    private static boolean validate(String value, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(value);
        return m.matches();
    }

    public static boolean isValidEmail(String email) {
        return validate(email, EMAIL_PATTERN);
    } // we probably don't need this

    public static boolean isValidName(String name) {
        return validate(name, NAME_PATTERN);
    } // could be changed to validate teamMembers

    public static boolean isValidTeamName(String name) {
        return validate(name, TEAM_PATTERN);
    }

}
