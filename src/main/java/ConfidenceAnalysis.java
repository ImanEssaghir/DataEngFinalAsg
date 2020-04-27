import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Code based on the video of AA
public class ConfidenceAnalysis {

    double confidence;
    double support;

    public void confiAnalysis(String path) throws IOException {

        // Read the file
        File sampleFile = new File(path);
        BufferedReader reader;

        // Check if the file exists
        if(!sampleFile.exists()){
            System.out.println("The file does not exist");
            System.exit(1);
        }

        reader = new BufferedReader(new FileReader((sampleFile)));
        List<String[]> output = new ArrayList<>();

        int total = 0;
        String line = null;
        biGram bm = new biGram();

        // fullResults ie full count of any premise (matching & non-matching)
        Map<String, Integer> fullResults = new HashMap<>();
        // validResults ie count of matching results
        Map<HashSet<String>, Integer> validResults = new HashMap<>();
        String[] lSplit = reader.readLine().split("\n");

        for(String[] sample : output) {

            for(int premise = 0; premise < bm.size; premise++){
                if(sample[premise].equals("the") || sample[premise].equals("this") || sample[premise].equals("of")){
                    fullResults.put((lSplit[premise]), fullResults.getOrDefault(lSplit[premise], 0) + 1);
                }

            }
        }

        // Calculate and print
        for(HashSet<String> hSet : validResults.keySet()){
            List<Object> featureList = hSet.stream().collect(Collectors.toList());
            // Confidence = % of times items are bought together
            confidence = (double) fullResults.get(featureList.get(0)) / validResults.get(hSet);
            // Support = % of times items are bought overall (total)
            support = (double) validResults.get(hSet) / total;

            System.out.printf("Confidence is %f "
                            + " %s will also type %s%n      and  the support is %f",
                    confidence, featureList.get(0), featureList.get(1), support);
            System.out.println();
        }

    }
}
