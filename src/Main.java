import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "123456";
        GetData.getDataFromSQL();
        Scanner scanner = new Scanner(System.in);
        char again = 'y';

        System.out.println("\nWELCOME TO THE V.I.P. QUIZ!");

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            while (again == 'y') {

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Choose Your next step =>");
                System.out.println("\tr - read rules");
                System.out.println("\tp - play the game");
                System.out.println("\tt - see TOP5 results");
                System.out.println("\tq - quit");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                char action = scanner.nextLine().charAt(0);
                if (action == 'p') {
                    String[] teamName = new String[2];
                    String[] teamMembers = new String[2];

                    for (int i=0;i<2;i++ ) {
                        System.out.println("Team "+ (i+1) +" please, enter Your team name:");
                        teamName[i] = scanner.nextLine();

                        while (!Validator.isValidTeamName(teamName[i])) {
                            System.out.println("Team name is not valid, please try again...");
                            teamName[i] = scanner.nextLine();
                        }
                        System.out.println("Please enter your team members in one line (name, name, name): ");
                        teamMembers[i] = scanner.nextLine();
                    }

                    System.out.println("Let's start the game!");
                    AskQuestion.askQuestion(teamName[0], teamName[1], teamMembers[0], teamMembers[1]);

                } else if (action == 'r') {
                    GameInteractions.printInstruction();
                } else if (action == 't') {
                    GameInteractions.readData(conn);
                } else if (action == 'q') {
                    break;
                }else {
                    System.out.println("Invalid input!");
                }

                System.out.println("Do You want to do something more? y/n");
                again = scanner.nextLine().charAt(0);

                while (again != 'y' && again != 'n') {
                    System.out.println("Invalid input. Please enter 'y' or 'n':");
                    again = scanner.nextLine().charAt(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}