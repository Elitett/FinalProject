import java.util.Scanner;
import java.sql.*;
public class Main {

    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "Elite";
        Scanner scanner = new Scanner(System.in);
        char again = 'y';
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            while (again == 'y') {
                System.out.println("Choose Your next step =>");
                System.out.println("r - read rules");
                System.out.println("p - play the game");
                System.out.println("t - see TOP results");
                System.out.println("q - quit");


                char action = scanner.nextLine().charAt(0);
                if (action == 'p') {

                    System.out.println("Team one - please, enter Your team name:");
                    String teamOne = scanner.nextLine();

                    System.out.println("Enter Your team member`s names (one line):");
                    String teamOneMembers = scanner.nextLine();

                    System.out.println("Team Two - please, enter Your team name:");
                    String newFullName = scanner.nextLine();

                    System.out.println("Enter Your team member`s names (one line):l");
                    String newEmail = scanner.nextLine();

                    //   insertData(conn,newUsername,newPassword,newFullName,newEmail);

                } else if (action == 'r') {
                    GameInteractions.printInstruction(); //Done
                } else if (action == 't') {
                   GameInteractions.readData();
                } else {
                    //  System.out.println("Invalid input!");
                }

                System.out.println("Do You want to do more action?? y/n?");
                again = scanner.nextLine().charAt(0);
            }

        } catch (Exception e) {
            e.printStackTrace(); // gives info about - where things went wrong
        }
    }
}
