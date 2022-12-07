import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class AOCDay6 {
    public static void main (String[] args) {
        int count = 0;
        try {
            File file = new File("day6.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> array = new ArrayList<String>();
            while (scanner.hasNext()) {
                String line = scanner.next();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    //part1
                    //while (array.size() < 4) {
                    //    array.add(String.valueOf(c));
                    //    count += 1;
                    //    Set<String> set = new HashSet<String>(array);
                    //    if (set.size() < array.size()) {
                    //        array.remove(0);
                    //    } else {
                    //        break;
                    //    }
                    //    break;
                    //}
                    //part2
                    while (array.size() < 14) {
                        array.add(String.valueOf(c));
                        count += 1;
                        Set<String> set = new HashSet<String>(array);
                        if (set.size() < array.size()) {
                                    array.remove(0);
                        } else {
                            break;
                        }
                        break;
                    }
                }
                
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            e.printStackTrace();
        }
        System.out.println(count);
    }
}