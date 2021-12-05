package AdventOfCode.AOC_D3;
import java.io.IOException;
import java.util.ArrayList;
import AdventOfCode.Helpers;

public class AOC_D3 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = Helpers.GenerateArrayListFromFile("AdventOfCode\\AOC_D3\\dataset_test2.txt");
        char[][] main = Helpers.ConvertStringArrayListTo2DCharArray(list, list.size(), list.get(0).length());

        String gamma = "";
        String epsilon = "";

        for(int row = 0; row < main[row].length; row++) {
            for(int col = 0; col < main.length; col++) {
                System.out.println(main[col][row]);
            }
        }

        System.out.println(gamma);
        System.out.println(epsilon);
    }
}
