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
}
