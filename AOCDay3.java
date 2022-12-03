import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AOCDay3 {
    public static void main(String[] args) {
        int total = 0;
        try {
            File file = new File("day3.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                Map<Character, Integer> map = new HashMap<Character, Integer>();  
                String line = scanner.nextLine();
                String line1 = line.substring(0, (line.length()/2));
                String line2 = line.substring((line.length()/2));
                char[] charArray = line1.toCharArray();  
                for (Character ch : charArray) {  
                    if (map.containsKey(ch)) {  
                        continue;
                    } else {  
                        map.put(ch, 1);  
                    }  
                }
                char[] charArray2 = line2.toCharArray();
                for (Character ch2 : charArray2) {
                    if (map.containsKey(ch2)) {
                        map.put(ch2, map.get(ch2) + 1);
                    }
                }
                Set<Character> keys = map.keySet();
                for (Character ch : keys) {
                    if(map.get(ch) > 1) {
                        if (ch >= 'A' && ch <= 'Z') { 
                            total += 1 + ch - 'A' + 26;    
                        } else if (ch >= 'a' && ch <= 'z') {
                            total += 1 + ch - 'a';                        
                        }
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