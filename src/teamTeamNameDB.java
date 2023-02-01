package db;

import java.sql.*;
import java.util.Scanner;


public class teamTeamNameDB {
    public static void main(String[] args) {

        String  dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "123456";
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

                    for (int i=0;i<2;i++ ){
                        System.out.println("please, enter Your team name:");
                        String teamName = scanner.nextLine();
                        System.out.println("please enter your team members");
                        String teamMembers = scanner.nextLine();

                        insertData(conn,teamName,teamMembers);
                    }
                      } else if (action == 'r') {
                        //GameInteraction.printInstruction();
                } else if (action == 't') {
                    //       readData(conn); //read data from table team
                } else {
                } System.out.println("Do You want to do more action?? y/n?");
                again = scanner.nextLine().charAt(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   //to insert teamName in BD
    public static void insertData (Connection conn, String teamName, String teamMembers) throws SQLException{
        String sql = "INSERT INTO team(teamName,teamMembers) VALUE (?, ? )";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,teamName);
        statement.setString(2,teamMembers);
        // statement.setInt(4,score);

        int rowInserted = statement.executeUpdate();

        if(rowInserted > 0){
            System.out.println("Your score is registered in database!");
        }else {
            System.out.println("Invalid input!");
        }


    }
}

