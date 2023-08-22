import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}

class WordSet {
    Set<String> words;

    public WordSet(String fileName) {
        words = new TreeSet<>();
        try {
            Scanner reader = new Scanner(new FileInputStream("VANBAN.in"));
            while (reader.hasNext()) {
                words.add(reader.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (String e : words) {
            output += e + "\n";
        }
        return output;
    }
}