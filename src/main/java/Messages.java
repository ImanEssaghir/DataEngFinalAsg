import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Messages {

    public static void main(String[] args) throws IOException {

        // Determine the confidence and support of each word pair (bigram)

        // bigram applied to messages.txt
        biGram bm = new biGram();
        bm.bigram("./src/messages.txt");

        // Ask user for word (as if they were typing it)
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a word");
        String userInput = sc.nextLine();
        System.out.println("The user's word is : " + userInput);

        // Build a List of possible "next words" at least 3 words in length
        List<String> output = new ArrayList<>();

        ConfidenceAnalysis confA = new ConfidenceAnalysis();
        for (int i = 0; i < bm.size; i++){

            // If the support of a word pair is >65% suggest that as one of the possible next word to be typed
            if(confA.support > 0.65){
                output.set(i, output.get(i) + " that");
            }
            // If no words with support >65% suggest the three most common English connector words: the, this, of
            if(confA.support <= 0.65){
                output.set(i, output.get(i) + " the");
                output.set(i, output.get(i) + " this");
                output.set(i, output.get(i) + " of");
            }
            // If less than 3 words found - pad the list with words from the most common Connectors (the this of)

        }

        // Print out the list with each word on its own line similar to: "Your next word might be <word here>.\n"
        for (String s : output) {
            System.out.println("Your next word might be " + s);
        }

    }

}

