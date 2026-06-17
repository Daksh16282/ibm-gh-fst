package fst.rock_paper_scissors;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

class RPS {

    private static String[] inputs = { "Rock", "Scissors", "Paper" };

    protected void validateUserInput(int userInput) throws Exception {

        if ((userInput != 0 && userInput != 1 && userInput != 2 && userInput != 3)) {
            throw new Exception("Received invalid input, please restart to play again");
        }
    }

    protected void validateCompInput(int compInput) throws Exception {

        if (compInput != 0 && compInput != 1 && compInput != 2) {
            throw new Exception("System Error, please restart to play again");
        }
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        char input = ' ';
        do {
            try {
                System.out.println("Press 0 for Rock,1 for Scissors and 2 for Paper and 3 for history :-");
                int userInput = sc.nextInt();

                if (userInput == 3) {
                    String data = getHistoryData();
                    if (data == null) {
                        System.out.println("No History Found");
                    } else {
                        System.out.println(data);
                    }
                    return;
                }
                try {
                    validateUserInput(userInput);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }

                int compInput = rd.nextInt(inputs.length);

                try {
                    validateCompInput(compInput);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }
                String userSelection = inputs[userInput];
                System.out.println("You selected -> " + userSelection);
                String compSelection = inputs[compInput];
                System.out.println("Opponent selected -> " + compSelection);
                String result = calculateResult(userInput, compInput);
                System.out.println(result);
                writeResults(userSelection, compSelection, result);
                System.out.println("Press Y to Replay and any other key to exit ,then Enter");
                input = sc.next().toUpperCase().charAt(0);
            } catch (Exception ex) {
                if (ex.getMessage() == null) {
                    System.out.println("Input Error Occured");
                } else {
                    System.out.println(ex.getMessage());
                }
                // to clear the old buffered input string from console,else program keeps
                // reading the
                // old input ,throw exception again and this process continues resulting
                // infinite loop
                sc.nextLine();
                //Halt Program 
                return;
            }
        } while (input == 'Y');

        sc.close();

    }

    protected String calculateResult(int userInput, int compInput) {

        if ((userInput == 0 && compInput == 1) || (userInput == 1 && compInput == 2)
                || (userInput == 2 && compInput == 0)) {
            return "You Win";
        }

        if ((userInput == 1 && compInput == 0) || (userInput == 2 && compInput == 1)
                || (userInput == 0 && compInput == 2)) {
            return "You Lose";
        }

        return "Match Draw";

    }

    protected boolean writeResults(String userSelection, String compSelection, String result) {
        try {
            File file = FileUtils.getFile("src/main/java/fst/rock_paper_scissors/history.txt");
            if (!file.exists()) {
                boolean isCreated = file.createNewFile();
                // System.out.println(isCreated);
                FileUtils.writeStringToFile(file,
                        "You Selected ->" + userSelection + " ,Opponent Selected->" + compSelection
                                + " ,Result is ->" + result + "\n",
                        Charset.defaultCharset());
            } else {
                String data = FileUtils.readFileToString(file, Charset.defaultCharset());
                FileUtils.writeStringToFile(file,
                        data + "You Selected ->" + userSelection + " ,Opponent Selected->" + compSelection
                                + " ,Result is ->" + result + "\n",
                        Charset.defaultCharset());
            }
            return true;

        } catch (Exception ex) {
            System.out.println("Got some error while saving the results (" + ex.getMessage() + ")");
        }

        return false;
    }

    protected String getHistoryData() {
        try {
            File file = FileUtils.getFile("src/main/java/fst/rock_paper_scissors/history.txt");
            if (!file.exists()) {
                throw new Exception("No history found");
            } else {
                String data = FileUtils.readFileToString(file, Charset.defaultCharset());
                return data;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }
}

public class Rock_Paper_Scissor {

    public static void main(String[] args) {
        RPS rps = new RPS();
        rps.playGame();

    }
}
