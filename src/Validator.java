import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String TEAM_PATTERN =  "^[\\w. -]+$";

    private static boolean validate(String value) {
        Pattern p = Pattern.compile(Validator.TEAM_PATTERN);
        Matcher m = p.matcher(value);
        return m.matches();
    }

    public static boolean isValidTeamName(String name) {
        return validate(name);
    }
}
