import java.util.ArrayList;
import java.util.HashSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class GetData {

    // I create an array list for each variable to store info pulled from SQL table that's called "questions"
    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String> answers = new ArrayList<>();
    static ArrayList<String> hint1 = new ArrayList<>();
    static ArrayList<String> hint2 = new ArrayList<>();

    // This hash set is needed to store used number from randomNumber() method
    static HashSet<Integer> usedNumbers = new HashSet<>();

    public static void getDataFromSQL() {
        String dbURL = "jdbc:mysql://localhost:3306/final_project_3401";
        String username = "root";
        String password = "220888_Nadja"; // change this to your password

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT question, answer, hint1, hint2 FROM questions");

            // Going to add all values from variables "questions", "answers", "hint1", "hint2" from the table "questions"
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

    // Method that generates a random number, that doesn't repeat twice
    public static int randomNumber() {
        Random rand = new Random();
        int randomNum;
        if (usedNumbers.size() == questions.size()) {
            usedNumbers.clear();
        }
        do {
            randomNum = rand.nextInt(questions.size());
        } while (!usedNumbers.add(randomNum));
        return randomNum;
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
