package AdventOfCode.Day_2;
import java.io.IOException;
import java.util.ArrayList;
import AdventOfCode.Helpers;

public class D2P2 {
    public static void main(String[] args) throws IOException {
        int horizontal_pos = 0;
        int depth = 0;
        int aim = 0;
        ArrayList<String> list = Helpers.GenerateArrayListFromFile("AdventOfCode\\Day_2\\dataset.txt");

        for(String command : list) {
            String[] commands = command.split(" ");
        
            if(commands[0].equalsIgnoreCase("forward")) {
                horizontal_pos += Integer.parseInt(commands[1]);
                depth += aim * Integer.parseInt(commands[1]);
            } else if (commands[0].equalsIgnoreCase("down")) {
                aim += Integer.parseInt(commands[1]);
            } else {
                aim -= Integer.parseInt(commands[1]);
            }
        }
        System.out.println(horizontal_pos * depth);
    }
}
