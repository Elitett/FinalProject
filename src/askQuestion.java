//import java.util.Scanner;
//
//public class askQuestion {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        /* GetData is a class that stores methods: randomNumber(), getQuestion(), getAnswer(), getHint1(), getHint2()
//        and getDataFromSQL() */
//
//        /*  Here I'm calling method getDataFromSQL() from Class GetData. This method takes questions, answers, hint1
//        and hint2 from our SQL table and stores all values in Array lists (new list for each variable (questions,
//        answers etc.)). Without this method we couldn't use data from SQL table in this Class file. */
//        GetData.getDataFromSQL();
//
//        // Now this is the hint part. It should go into the loop that asks questions.
//
//        // Here I'm calling method randomNumber() from Class GetData. A random number, that doesn't repeat, will be generated
//        int questionIndex = GetData.randomNumber();
//
//        System.out.println("Would you like a hint? y/n");
//        char askForHint;
//        askForHint = scanner.nextLine().charAt(0);
//
//        if (askForHint == 'y') {
//            char useHint;
//            // For questions that have no hints. In if() condition it is asking if hint1 and hint2 in table are empty for given question
//            if (GetData.getHint1(questionIndex) == null && GetData.getHint2(questionIndex) == null) {
//                System.out.println("Sorry, this question has no hints... You're on your own!");
//
//            // For questions that have only one hint. In if() condition it is asking if hint2 in table is empty
//            } else if (GetData.getHint2(questionIndex) == null) {
//                System.out.println("This question has a hint that costs 60 points. Do you want to use it? y/n");
//                useHint = scanner.nextLine().charAt(0);
//
//                if (useHint == 'y') {
//                    System.out.println("Hint for 60 points: " + GetData.getHint1(questionIndex));
//                }
//
//            // For questions that have both hints
//            } else {
//                System.out.println("There are two hints available. Would you like to use hint for 30 or for 70 points? " +
//                        "\nWrite \"1\" for 30 point hint \nWrite \"2\" for 70 point hint");
//                useHint = scanner.nextLine().charAt(0);
//
//                if (useHint == '1') {
//                    System.out.println("Hint for 30 points: " + GetData.getHint1(questionIndex));
//                    System.out.println("\nDo you want to use other hint? y/n");
//                    useHint = scanner.nextLine().charAt(0);
//                    if (useHint == 'y') {
//                        System.out.println("Hint for 70 points: " + GetData.getHint2(questionIndex));
//                    }
//
//                } else if (useHint == '2') {
//                    System.out.println("Hint for 70 points: " + GetData.getHint2(questionIndex));
//                    System.out.println("\nDo you want to use other hint? y/n");
//                    useHint = scanner.nextLine().charAt(0);
//                    if (useHint == 'y') {
//                        System.out.println("Hint for 30 points: " + GetData.getHint1(questionIndex));
//                    }
//
//                } else {
//                    System.out.println("Invalid input");
//                }
//            }
//        }
//    }
//}
