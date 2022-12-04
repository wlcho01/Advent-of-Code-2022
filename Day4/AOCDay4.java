import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.Arrays;

public class AOCDay4 {
    public static void main(String[] args) {
        int total = 0;
        int totalPart2 = 0;
        try {
            File file = new File("day4.txt");
            Scanner scanner = new Scanner(file);
            File newFile = new File("day4new.txt");
            FileWriter writer = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(writer);
            while (scanner.hasNext()) {
                String line = scanner.next();
                String newLine = line.replace("-",",");
                bw.write(newLine);
                bw.newLine();
            }
            bw.close();
            scanner.close();
            
            Scanner scanner2 = new Scanner(newFile);
            while (scanner2.hasNext()) {
                String line2 = scanner2.next();
                String[] newLine2 = line2.split(",",4);
                int[] array = IntStream.range(Integer.parseInt(newLine2[0]),Integer.parseInt(newLine2[1])+1).toArray();
                int[] array2 = IntStream.range(Integer.parseInt(newLine2[2]),Integer.parseInt(newLine2[3])+1).toArray();
                int same = 0;
                for (int num : array) {
                    for (int num2 : array2) {
                        if (num == num2) {
                            same += 1;
                        }
                    }
                }

                if (same == array.length || same == array2.length) {
                    total += 1;
                }

                if (same > 0) {
                    totalPart2 += 1;
                }
            }
            scanner2.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Buffered writer error");
        }
        System.out.println(total);
        System.out.println(totalPart2);
    }
}