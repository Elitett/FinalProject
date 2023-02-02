import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class AskQuestion {
    public static void askQuestion(String teamOne, String teamTwo, String teamOneMembers, String teamTwoMembers) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(dbURL,username,password);
        Scanner scanner = new Scanner(System.in);
        String answer;
        GetData.getDataFromSQL();

        String[] teams = {teamOne, teamTwo};
        int[] teamPoints = {600,600};

        // These are used for randomNumber method
        Set<Integer>[] usedNumbersForTeam = new HashSet[teams.length];

        for (int i = 0; i < teams.length; i++) {
            usedNumbersForTeam[i] = new HashSet<>();
        }

        Set<Integer> usedNumbers = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int a = 0; a < teams.length; a++) {

                int questionIndex = randomNumber(usedNumbers, usedNumbersForTeam[a]);

                System.out.println("\nQuestion " + (i+1) + " for team "+ teams[a] + ": " + GetData.getQuestion(questionIndex));
                System.out.println("Would you like a hint? y/n");

                char askForHint = scanner.nextLine().charAt(0);
                while (askForHint != 'y' && askForHint != 'n') {
                    System.out.println("Invalid input. Please enter 'y' or 'n':");
                    askForHint = scanner.nextLine().charAt(0);
                }
                if (askForHint == 'y') {
                    char useHint;

                    if (GetData.getHint1(questionIndex) == null && GetData.getHint2(questionIndex) == null) {
                        System.out.println("This question has no hints... You're on your own!");

                    } else if (GetData.getHint2(questionIndex) == null) {
                        System.out.println("This question has a hint that costs 60 points. Do you want to use it? y/n");
                        useHint = validUseHint();

                        if (useHint == 'y') {
                            System.out.println("Hint for 60 points: " + GetData.getHint1(questionIndex));
                            teamPoints[a] = teamPoints[a] - 60;
                        }
                    } else {
                        System.out.println("""
                                    There are two hints available. Would you like to use hint for 30 or for 70 points?\s
                                    Write '1' for 30 point hint\s
                                    Write '2' for 70 point hint""");
                        useHint = scanner.nextLine().charAt(0);
                        while (useHint != '1' && useHint != '2') {
                            System.out.println("Invalid input. Please enter '1' or '2':");
                            useHint = scanner.nextLine().charAt(0);
                        }

                        if (useHint == '1') {
                            System.out.println("Hint for 30 points: " + GetData.getHint1(questionIndex));
                            teamPoints[a] = teamPoints[a] - 30;

                            System.out.println("\nDo you want to use other hint? y/n");
                            useHint = validUseHint();

                            if (useHint == 'y') {
                                System.out.println("Hint for 70 points: " + GetData.getHint2(questionIndex));
                                teamPoints[a] = teamPoints[a] - 70;
                            }

                        } else if (useHint == '2') {
                            System.out.println("Hint for 70 points: " + GetData.getHint2(questionIndex));
                            teamPoints[a] = teamPoints[a] - 70;

                            System.out.println("\nDo you want to use other hint? y/n");
                            useHint = validUseHint();

                            if (useHint == 'y') {
                                System.out.println("Hint for 30 points: " + GetData.getHint1(questionIndex));
                                teamPoints[a] = teamPoints[a] - 30;
                            }
                        } else {
                            System.out.println("Invalid input");
                        }
                    }
                }

                System.out.println("Your answer: ");
                answer = scanner.nextLine();

                if (answer.trim().equalsIgnoreCase(GetData.getAnswer(questionIndex))) {
                    System.out.println("Correct! Your team has "+ teamPoints[a] + " points.");
                } else {
                    teamPoints[a] = teamPoints[a] - 150;
                    System.out.println("Incorrect. The right answer was " + GetData.getAnswer(questionIndex) + ". Your team has " + teamPoints[a] + " points.");
                }
            }
        }
        GameInteractions.insertData(conn, teamOne, teamOneMembers, teamPoints[0]);
        GameInteractions.insertData(conn, teamTwo, teamTwoMembers, teamPoints[1]);

        if(teamPoints[0] > teamPoints[1]){
            System.out.println("Team "+ teamOne + " wins the game with " + teamPoints[0] + " points! Team " + teamTwo + " final score is " + teamPoints[1] + " points. Better luck next time!");
        } else if (teamPoints[1] > teamPoints[0]) {
            System.out.println("Team "+ teamTwo + " wins the game with " + teamPoints[1] + " points! Team " + teamOne + " final score is " + teamPoints[0] + " points. Better luck next time!");
        } else {
            System.out.println("Both teams have scored " + teamPoints[0] + " points. It's a tie!");
        }
    }

    public static char validUseHint() {
        Scanner scanner = new Scanner(System.in);
        char useHint = scanner.nextLine().charAt(0);
        while (useHint != 'y' && useHint != 'n') {
            System.out.println("Invalid input. Please enter 'y' or 'n':");
            useHint = scanner.nextLine().charAt(0);
        }
        return useHint;
    }

    public static int randomNumber(Set<Integer> usedNumbers, Set<Integer> usedNumbersForTeam) {
        Random rand = new Random();
        int randomNum;
        if (usedNumbers.size() == GetData.questions.size() || usedNumbersForTeam.size() == GetData.questions.size()) {
            usedNumbers.clear();
            usedNumbersForTeam.clear();
        }
        do {
            randomNum = rand.nextInt(GetData.questions.size());
        } while (!usedNumbers.add(randomNum) || !usedNumbersForTeam.add(randomNum));
        return randomNum;
    }
}