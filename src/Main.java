import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "220888_Nadja";
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

                   /* for (int i=0;i<2;i++ ) {
                        System.out.println("Please, enter Your team name:");
                        String teamName[i] = scanner.nextLine();
                        while (!Validator.isValidTeamName(teamName[i])) {
                            System.out.println("Team name is not valid, please try again...");
                            teamName[i] = scanner.nextLine();
                        }
                        System.out.println("Please enter your team members");
                        String teamMembers[i] = scanner.nextLine();
                    }*/

                    System.out.println("Team one - please, enter Your team name:");
                    String teamOne = scanner.nextLine();

                    while (!Validator.isValidTeamName(teamOne)) {
                        System.out.println("Team name is not valid, please try again...");
                        teamOne = scanner.nextLine();
                    }

                    System.out.println("Enter Your team member`s names in one line (name, name, name):");
                    String teamOneMembers = scanner.nextLine();

                    System.out.println("Team Two - please, enter Your team name:");
                    String teamTwo = scanner.nextLine();

                    while (!Validator.isValidTeamName(teamTwo)) {
                        System.out.println("Team name is not valid, please try again...");
                        teamTwo = scanner.nextLine();
                    }

                    System.out.println("Enter Your team member`s names in one line (name, name, name):");
                    String teamTwoMembers = scanner.nextLine();

                    System.out.println("Let's start the game!");

                    AskQuestion.askQuestion(teamOne, teamTwo, teamOneMembers, teamTwoMembers);

                } else if (action == 'r') {
                    GameInteractions.printInstruction(); //Done
                } else if (action == 't') {
                    GameInteractions.readData(conn);
                } else if (action == 'q') {
                    break;
                }else {
                    System.out.println("Invalid input!");
                }

                System.out.println("Do You want to do something more? y/n");
                again = scanner.nextLine().charAt(0);
            }

        } catch (Exception e) {
            e.printStackTrace(); // gives info about - where things went wrong
        }
    }
}