import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class AOCDay8 {
    static int[][] forest;

    public static void printForest(int[][] forest) {
        for (int[] i : forest) {
            System.out.println(Arrays.toString(i));
        }
    }
    public static void main (String[] args) {
        forest = new int[99][99];
        int index = 0;
        int visible = 0;
        int maxScore = 0;
        try {
            File file = new File("day8.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++){
                    int row = index/99;
                    int col = index%99;
                    index += 1;
                    char c = line.charAt(i);
                    int tempInt = Character.getNumericValue(c);
                    forest[row][col] = tempInt;
                }                   
            }             
            for (int row = 0; row < 99; row++) {
                for (int col = 0; col < 99; col++) {
                    if (row == 0 || row == 98 || col == 0 || col == 98) {
                        visible += 1;
                    } else {
                        int maxColLeft = forest[row][col];
                        int maxRowTop = forest[row][col];
                        int maxColRight = forest[row][col];
                        int maxRowBot = forest[row][col];
                        int top = 0;
                        int left = 0;
                        int bot = 0;
                        int right = 0;
                        int score = 0;
                        //Part 1
                        /*                     
                        for (int col2 = 0; col2 < col; col2++) {
                            if (forest[row][col2] >= forest[row][col]) {
                                maxColLeft = forest[row][col2] + 1;
                                break;
                            }
                        }
                        for (int row2 = 0; row2 < row; row2++) {
                            if (forest[row2][col] >= forest[row][col]) {
                                maxRowTop = forest[row2][col] + 1;
                                break;
                            }
                        }
                        for (int col2 = col + 1; col2 < 99; col2++) {
                            if (forest[row][col2] >= forest[row][col]) {
                                maxColRight = forest[row][col2] + 1;
                                break;
                            }
                        }
                        for (int row2 = row + 1; row2 < 99; row2++) {
                            if (forest[row2][col] >= forest[row][col]) {
                                maxRowBot = forest[row2][col] + 1;
                                break;
                            }
                        }
                        if (forest[row][col] == maxColTop || forest[row][col] == maxRowLeft || forest[row][col] == maxColBot || forest[row][col] == maxRowRight) {
                            visible += 1;
                        }
                        */
                        //Part 2
                        for (int col2 = col - 1; col2 >= 0; col2--) {
                            if (forest[row][col2] >= forest[row][col]) {
                                left = col - col2;
                                break;
                            }   else if (forest[row][col2] == forest[row][0]) {
                                left = col - col2;
                            }
                        }
                        for (int row2 = row - 1; row2 >= 0; row2--) {
                            if (forest[row2][col] >= forest[row][col]) {
                                top = row - row2;
                                break;
                            }   else if (forest[row2][col] == forest[0][col]) {
                                top = row - row2;
                            }
                        }
                        for (int col2 = col + 1; col2 < 99; col2++) {
                            if (forest[row][col2] >= forest[row][col]) {
                                right = col2 - col;
                                break;
                            }   else if (forest[row][col2] == forest[row][98]) {
                                right = col2 - col;
                            }
                        }
                        for (int row2 = row + 1; row2 < 99; row2++) {
                            if (forest[row2][col] >= forest[row][col]) {
                                bot = row2 - row;
                                break;
                            }   else if (forest[row2][col] == forest[98][col]) {
                                bot = row2 - row;
                            }
                        }
                        score = top*left*right*bot;
                        if (score > maxScore) {
                            maxScore = score;
                        }
                    }                  
                }
            }
            //System.out.println(visible); part1                                    
            System.out.println(maxScore);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            e.printStackTrace();
        }
    }
}