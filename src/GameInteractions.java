import java.sql.*;

public class GameInteractions {

    public static void printInstruction(){
        System.out.println("\nThis is a version of V.I.P. quiz/mind game!");
        System.out.println("\tV.I.P. is an abbreviation for Veiksme, Intuīcija, Prāts (Luck, Intuition, Mind)");
        System.out.println("\t - Two teams participate in the game");
        System.out.println("\t - Each team is given the same number of questions");
        System.out.println("\t - After first team answers the question, next question goes to second team");
        System.out.println("\t - Both teams have maximum value of points at the beginning of the game");
        System.out.println("\t - After every question team will be able to choose if they want to use hints");
        System.out.println("\t - Questions might have one, two or zero hints");
        System.out.println("\t - If team gives correct answer to the question, they keep the current score");
        System.out.println("\t - Incorrect answer costs 150 points");
        System.out.println("\t - If team uses a hint, they lose a certain number of points (hint's value)");
        System.out.println("\t - If team uses a hint, but answer is incorrect, they lose hint's value and additional 150 points");
        System.out.println("\t - Team with biggest score wins");
        System.out.println("\t - Answers should be written in English\n");
    }

    public static void readData(Connection conn) throws SQLException {

        String sql = "SELECT * FROM team ORDER BY Score DESC LIMIT 5";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;

        System.out.println("TOP 5 results:");

        while (resultSet.next()) {
            String teamName = resultSet.getString(2);
            String teamMembers = resultSet.getString(3);
            String Score = String.valueOf(resultSet.getInt(4));

            String output = "%d. %s ~ %s ~ %s points";
            System.out.println(String.format(output, ++count, teamName, teamMembers, Score)); //using ++ we can increase by one and print out
        }
    }

    public static void insertData (Connection conn, String teamName, String teamMembers, int Score) throws SQLException{
        String sql = "INSERT INTO team(teamName,teamMembers,Score) VALUE (?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,teamName);
        statement.setString(2,teamMembers);
        statement.setInt(3,Score);

        int rowInserted = statement.executeUpdate();

        if(rowInserted > 0){
            System.out.println("Your score is registered in database!");
        }else {
            System.out.println("Invalid input!");
        }
    }
}
