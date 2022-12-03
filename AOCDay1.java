import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AOCDay1 {
    public static void main(String[] args) {
        try {
            File file = new File("Day1_1.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(" ");
            int sum = 0;
            int elfCount = 1;
            int highest = 0;
            int highestElfCount = 1;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (line.startsWith(" ")) {      
                    sum = 0;              
                    elfCount += 1;
                    continue;
                }
                sum += Integer.parseInt(line);
                if (sum >= highest) {
                    highest = sum;
                    sum = 0;
                    highestElfCount = elfCount;
                }
                System.out.println(highest);
            }
            
            System.out.println(highest);
            System.out.println(highestElfCount);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}