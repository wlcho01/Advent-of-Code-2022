import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;
import java.lang.StringBuilder;

public class AOCDay3_2 {
    public static void main(String[] args) {
        int total = 0;
        try {
            File file = new File("day3.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                Map<Character, Integer> map = new HashMap<Character, Integer>();  
                String line = scanner.nextLine();
                String line2 = scanner.nextLine();
                String line3 = scanner.nextLine();
                char[] charArray = line.toCharArray();  
                for (Character ch : charArray) {  
                    if (map.containsKey(ch)) {  
                        continue;
                    } else {  
                        map.put(ch, 1);  
                    }  
                }
                Set<Character> set = new LinkedHashSet<Character>();
                char[] charArray2 = line2.toCharArray();
                for (char ch2 : charArray2) {
                    set.add(ch2);
                }

                StringBuilder sb = new StringBuilder();
                for (Character ch : set) {
                    sb.append(ch);
                }

                char[] charArrayNoDupes2 = sb.toString().toCharArray();
                for (Character ch2 : charArrayNoDupes2) {
                    if (map.containsKey(ch2)) {
                        map.put(ch2, map.get(ch2) + 1);
                    }
                }
                Set<Character> set2 = new LinkedHashSet<Character>();
                char[] charArray3 = line3.toCharArray();
                for (char ch3 : charArray3) {
                    set2.add(ch3);
                }

                StringBuilder sb2 = new StringBuilder();
                for (Character ch2 : set2) {
                    sb2.append(ch2);
                }
                
                char[] charArrayNoDupes3 = sb2.toString().toCharArray();
                for (Character ch3 : charArrayNoDupes3) {
                    if (map.containsKey(ch3)) {
                        map.put(ch3, map.get(ch3) + 1);
                    }
                }
                Set<Character> keys = map.keySet();
                for (Character ch : keys) {
                    if(map.get(ch) > 2) {
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
