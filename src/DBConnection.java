import java.sql.*;
import java.util.Scanner;


public class DBConnection {
    public static void main(String[] args) {

        String  dbURL = "jdbc:mysql://localhost:3306/final_project_3401";
        String username = "root";
        String password = "220888_Nadja";
        Scanner scanner = new Scanner(System.in);
        char again = 'y';

        try (Connection conn = DriverManager.getConnection(dbURL,username, password)){
            System.out.println("Connected to V.I.P. database!");
            while (again == 'y') {
                System.out.println("Choose Your next step =>");
                System.out.println("r - read rules");
                System.out.println("p - play the game");
                System.out.println("t - see TOP results");
                System.out.println("q - quit");


                char action = scanner.nextLine().charAt(0);
                if (action == 'p') {

                   // for (int i=0;i<2;i++ ){
                        System.out.println("please, enter Your team name:");
                        String teamName = scanner.nextLine();
                        System.out.print("please enter your team members");
                        String teamMembers = scanner.nextLine();
                        //   System.out.println("please, enter Your team name:");
                       // String teamName2 = scanner.nextLine();
                        insertData(conn, teamName,teamMembers );
                   // }
                   // String teamName = scanner.nextLine();




               } else if (action == 'r') {
                    GameInteractions.printInstruction();
                } else if (action == 't') {
                    readData(conn);
                } else {
                } System.out.println("Do You want to do more action?? y/n?");
                again = scanner.nextLine().charAt(0);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readData (Connection conn) throws SQLException{
        String sql = "SELECT * FROM result";
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery(sql);
        int count = 0;

        while (resultSet.next()){
            String teamName = resultSet.getString("teamName");
            String score = resultSet.getString("score");
            System.out.println(String.format(String.valueOf(++count),teamName,score));

        }


    }
    public static void insertData (Connection conn, String teamName, String teamMembers) throws SQLException{
        String sql = "INSERT INTO team(teamName,teamMembers, Score) VALUE (?, ? , ? )";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(2,teamName);
        statement.setString(3,teamMembers);
      //  statement.setInt(4,Score);

        int rowInserted = statement.executeUpdate();

        if(rowInserted > 0){
            System.out.println("Your score is registered in database!");
        }else {
            System.out.println("Invalid input!");
        }


   }
}

