package AdventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Helpers {
    public static ArrayList<String> GenerateArrayListFromFile(String filename) throws IOException {
        try {
            List<String> result = Files.readAllLines(Paths.get(filename));
            return (ArrayList<String>) result;
        } catch (IOException e){
            System.out.println("Failed to parse file.");
            throw e;
        }
    }

    public static char[][] ConvertStringArrayListTo2DCharArray(ArrayList<String> list, int size_first, int size_second) {
        char[][] main = new char[size_first][size_second];
        for(int i = 0; i < list.size(); i++) {
            main[i] = list.get(i).toCharArray();
        }
        return main;
    }

    public static int[] ConvertStringArrayToIntArray(String[] array) {
        int[] returnArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            returnArray[i] = Integer.parseInt(array[i]);
        }
        return returnArray;
    }

    public static int[][][] ConvertIntArrayTo3DIntArray(int[] array, int matrices, int rows, int cols) {
        int[][][] returnArray = new int[matrices][rows][cols];
        int counter = 0;
        for(int matrix = 0; matrix < matrices; matrix++){
            for(int row = 0; row < rows; row++) {
                for(int col = 0; col < cols; col++) {
                    returnArray[matrix][row][col] = array[counter];
                    counter++;
                }
            }
        }
        return returnArray;
    }
}
