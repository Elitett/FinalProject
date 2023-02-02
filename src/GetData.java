import java.sql.*;
import java.util.ArrayList;

public class GetData {

    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String> answers = new ArrayList<>();
    static ArrayList<String> hint1 = new ArrayList<>();
    static ArrayList<String> hint2 = new ArrayList<>();

    public static void getDataFromSQL() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java34", "root", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT question, answer, hint1, hint2 FROM questions");

            while (rs.next()) {
                questions.add(rs.getString("question"));
                answers.add(rs.getString("answer"));
                hint1.add(rs.getString("hint1"));
                hint2.add(rs.getString("hint2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getQuestion(int index) {
        return questions.get(index);
    }

    public static String getAnswer(int index) {
        return answers.get(index);
    }

    public static String getHint1(int index) {
        return hint1.get(index);
    }
    public static String getHint2(int index) {
        return hint2.get(index);
    }
}