import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AOCDay2_2 {
    public static void main(String[] args) {
        int total = 0;
        try {
            File file = new File("day2.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                //while (scanner.hasNext()) {                   
                    String opponent = scanner.next();
                    String me = scanner.next();
                    
                    if (opponent.equals("A")) {
                        if (me.equals("X")) {
                            total += 3;
                        } else if (me.equals("Y")) {
                            total += 4;
                        } else {
                            total += 8;
                        }
                    } else if (opponent.equals("B")) {
                        if (me.equals("X")) {
                            total += 1;
                        } else if (me.equals("Y")) {
                            total += 5;
                        } else {
                            total += 9;
                        } 
                    } else {
                        if (me.equals("X")) {
                            total += 2;
                        } else if (me.equals("Y")) {
                            total += 6;
                        } else {
                            total += 7;
                        } 
                    }                   
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            e.printStackTrace();
        }
        System.out.println(total);
    }
}