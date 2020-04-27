import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Code based on the videos of the course
public class biGram {

    int size;
    public void bigram(String path) throws IOException {

        Path messages = Paths.get(path);

        // Read all lines (except empty) into a String Stream
        Stream<String> messagesLines = Files.lines(messages)
                .filter(line -> !line.isEmpty());

        // Add a split & flatMap the Arrays
        List<String> sportsWords = messagesLines
                .map(String::toLowerCase)
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        Map<Set<String>, Integer> bigrams = new HashMap<>();

        for (int i = 1; i < sportsWords.size(); i++) {
            bigrams.merge(new HashSet<>(Arrays.asList(
                    sportsWords.get(i-1),
                    sportsWords.get(i))),
                    1, Integer::sum);
        }

        // Print the biGram
        System.out.println(" The bigram is : ");
        bigrams.forEach((key, value) -> System.out.println(key + ", " + value));
        System.out.println();
        System.out.println(" The bigram printed as a list: ");
        System.out.println(bigrams);
        System.out.println();
        System.out.print(" The size of the bigram is : ");
        size = bigrams.size();
        System.out.println(size);
        System.out.println();
    }
}

