import java.util.Scanner;
import java.sql.*;
public class Main {

    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "220888_Nadja";
        Scanner scanner = new Scanner(System.in);
        char again = 'y';
        try (Connection conn = DriverManager.getConnection(dbURL,username,password)) {

            while (again == 'y') {
                System.out.println("Choose Your next step =>");
                System.out.println("r - read rules");
                System.out.println("p - play the game");
                System.out.println("t - see TOP results");
                System.out.println("q - quit");

                char action = scanner.nextLine().charAt(0);
                if (action == 'p') {
                    System.out.println("Team one - please, enter Your team name:");
                    String teamName = scanner.nextLine();
                    while (!Validator.isValidTeamName(teamName)) {
                        System.out.println("Team one is not valid, please enter again...");
                        teamName = scanner.nextLine();
                    }

                    System.out.println("Enter Your team member`s names (one line):");
                    String teamMembers = scanner.nextLine();

                  /*  System.out.println("Team Two - please, enter Your team name:");
                    String teamTwo = scanner.nextLine();
                    while (!Validator.isValidTeamName(teamTwo)) {
                        System.out.println("Team one is not valid, please enter again...");
                        teamTwo = scanner.nextLine();
                    }

                    System.out.println("Enter Your team member`s names (one line):");
                    String teamTwoMembers = scanner.nextLine();*/

                    //insertData(conn, teamName, teamMembers);

                    //insertData(conn,,newPassword,newFullName,newEmail);

                } else if (action == 'r') {
                    GameInteractions.printInstruction(); //Done
                } else if (action == 't') {
                   GameInteractions.readData();
                } else if (action == 'q') {
                    break;
                }else {
                    System.out.println("Invalid input!");
                }

                System.out.println("Do You want to do something more? y/n?");
                again = scanner.nextLine().charAt(0);
            }

        } catch (Exception e) {
            e.printStackTrace(); // gives info about - where things went wrong
        }
    }
}
