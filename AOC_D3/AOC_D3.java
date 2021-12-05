package AdventOfCode.AOC_D3;
import java.io.IOException;
import java.util.ArrayList;
import AdventOfCode.Helpers;

public class AOC_D3 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = Helpers.GenerateArrayListFromFile("AdventOfCode\\AOC_D3\\dataset.txt");
        char[][] main = Helpers.ConvertStringArrayListTo2DCharArray(list, list.size(), list.get(0).length());

        String gamma = "";
        String epsilon = "";
        int rowLength = main[0].length; // Stops out of bound 

        for(int row = 0; row < rowLength; row++) {
            int bit1Counter = 0;
            int bit0Counter = 0;
            for(int col = 0; col < main.length; col++) {
                if(main[col][row] == '1') {
                    bit1Counter++;
                } else {
                    bit0Counter++;
                }
            }
            if(bit1Counter >= bit0Counter) {
                gamma += 1;
                epsilon += 0;
            } else {
                gamma += 0;
                epsilon += 1;
            }
        }
        System.out.println(Integer.parseInt(gamma, 3) * Integer.parseInt(epsilon, 2));
    }
}
