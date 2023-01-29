import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameInteractions {

    public static void printInstruction(){
        System.out.println("\nThis is version of V.I.P. quiz or mind game!");
        System.out.println("\tV.I.P. are abbreviation of Veiksme, Intuīcija, Prāts (Success, Intuition, Mind");
        System.out.println("\t - Two teams participate in the game");
        System.out.println("\t - Each team has the same number of questions");
        System.out.println("\t - Value for every question is 150 points");
        System.out.println("\t - Every team has max points for all question`s at the beginning of the game - starting score");
        System.out.println("\t - If team gives correct answer to the question it keeps the current score");
        System.out.println("\t - If team needs to choose some hint, it costs a certain number of points - hints value");
        System.out.println("\t - The winner is team with biggest score\n");
    }

    public static void readData() throws SQLException {

        String sql = "SELECT*FROM Result"; //Check if table name will be the same
        Connection conn = null;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;

        while(resultSet.next()){
            String teamName = resultSet.getString("fullname");
            String score = resultSet.getString("email");
                                                                        // If we want to show TOP5 (not every team from list), where to define length
            System.out.println(String.format(String.valueOf(++count),teamName,score)); //using ++ we can increase by one and print out
        }
    }
}
