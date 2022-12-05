import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class AOCDay5 {
    public static String whatStack (int num) {
        String thisStack = "stack" + Integer.toString(num);
        return thisStack;
    }
    public static void main (String[] args) {
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        Stack<String> stack3 = new Stack<String>();
        Stack<String> stack4 = new Stack<String>();
        Stack<String> stack5 = new Stack<String>();
        Stack<String> stack6 = new Stack<String>();
        Stack<String> stack7 = new Stack<String>();
        Stack<String> stack8 = new Stack<String>();
        Stack<String> stack9 = new Stack<String>();
        //HASUSAIFHNASDFJKSDNFJDSKFNDSJKF
        stack1.push("F");
        stack1.push("C");
        stack1.push("J");
        stack1.push("P");
        stack1.push("H");
        stack1.push("T");
        stack1.push("W");
        stack2.push("G");
        stack2.push("R");
        stack2.push("V");
        stack2.push("F");
        stack2.push("Z");
        stack2.push("J");
        stack2.push("B");
        stack2.push("H");
        stack3.push("H");
        stack3.push("P");
        stack3.push("T");
        stack3.push("R");
        stack4.push("Z");
        stack4.push("S");
        stack4.push("N");
        stack4.push("P");
        stack4.push("H");
        stack4.push("T");
        stack5.push("N");
        stack5.push("V");
        stack5.push("F");
        stack5.push("Z");
        stack5.push("H");
        stack5.push("J");
        stack5.push("C");
        stack5.push("D");
        stack6.push("P");
        stack6.push("M");
        stack6.push("G");
        stack6.push("F");
        stack6.push("W");
        stack6.push("D");
        stack6.push("Z");
        stack7.push("M");
        stack7.push("V");
        stack7.push("Z");
        stack7.push("W");
        stack7.push("S");
        stack7.push("J");
        stack7.push("D");
        stack7.push("P");
        stack8.push("N");
        stack8.push("D");
        stack8.push("S");
        stack9.push("D");
        stack9.push("Z");
        stack9.push("S");
        stack9.push("F");
        stack9.push("M");
        Map<String, Stack<String>> map = new HashMap<String, Stack<String>>();
        map.put("stack1", stack1);
        map.put("stack2", stack2);
        map.put("stack3", stack3);
        map.put("stack4", stack4);
        map.put("stack5", stack5);
        map.put("stack6", stack6);
        map.put("stack7", stack7);
        map.put("stack8", stack8);
        map.put("stack9", stack9);
        try {
            File file = new File("day5new.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String foo = scanner.next();
                String num = scanner.next();
                int numInt = Integer.parseInt(num);
                String foo2 = scanner.next();
                String num2 = scanner.next();
                String foo3 = scanner.next();
                String num3 = scanner.next();
                String from = whatStack(Integer.parseInt(num2));
                String to = whatStack(Integer.parseInt(num3));
                //Part 1
                //while (numInt > 0 && map.get(from).size() > 0) {
                //    String crate = map.get(from).pop();
                //    map.get(to).push(crate);
                //    numInt -= 1;
                //}
                //Part 2
                Stack<String> tempStack = new Stack<String>();
                while (numInt > 0 && map.get(from).size() > 0) {
                    String crate = map.get(from).pop();
                    tempStack.push(crate);
                    numInt -= 1;
                }
                while (tempStack.size() > 0) {
                    String crate = tempStack.pop();
                    map.get(to).push(crate);                  
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            e.printStackTrace();
        }
        
        System.out.println(stack1.peek());
        System.out.println(stack2.peek());
        System.out.println(stack3.peek());
        System.out.println(stack4.peek());
        System.out.println(stack5.peek());
        System.out.println(stack6.peek());
        System.out.println(stack7.peek());
        System.out.println(stack8.peek());
        System.out.println(stack9.peek());
    }
}