import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

public class AOCDay7 {
    public static void main (String[] args) {
        try {
            File file = new File("day7.txt");
            Scanner scanner = new Scanner(file);
            Stack<String> stack = new Stack<String>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("$ cd /")) {
                    continue;
                } else if (line.startsWith("$ cd ..")) {
                    stack.pop();
                } else if (line.startsWith("$ cd")) {
                    String[] words = line.split(" ");
                    String folderName = words[2];
                    stack.push(folderName);
                }
                System.out.println(line);                      
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            e.printStackTrace();
        }
    }
}