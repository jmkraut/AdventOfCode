package AdventOfCode.Day_4;

import AdventOfCode.Helpers;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class D4P1 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // Choose between the test dataset or the real dataset
        String test = "AdventOfCode\\Day_4\\dataset_test.txt";
        String data = "AdventOfCode\\Day_4\\dataset.txt";

        // Filter out the empty lines in the dataset
        List<String> dataset = Helpers.GenerateArrayListFromFile(data).stream()
        .filter(string -> !string.equalsIgnoreCase(""))
        .collect(Collectors.toList());

        // Convert from a string array to an int array of the bingo numbers
        int[] bingoNumsIntArray = Helpers.ConvertStringArrayToIntArray(dataset.get(0).split(","));
        // Remove the bingo numbers from the list
        dataset.remove(0);

        int rows = 5;
        int cols = 5;
        int totalRows = dataset.size();
        int matrices = totalRows / 5;
        int winningBingoMatrix = 0;
        int winningBingoNumber = 0;
        int winningTotal = 0;

        // Normalise the data into a string array so it can be converted
        String[] bingoTablesStringArray = String.join("\n", dataset).replaceAll("\n", " ").replaceAll("  ", " ").replaceAll("  ", " ").strip().split(" ");
        //Convert from a string array to a flat array of the all the bingo table numbers
        int[] bingoTablesIntArray = Helpers.ConvertStringArrayToIntArray(bingoTablesStringArray);

        // Convert the flat int array to a 3D array containing each matrice and its rows and columns
        int[][][] bingoTables3DIntArray = Helpers.ConvertIntArrayTo3DIntArray(bingoTablesIntArray, matrices, rows, cols);
        // Track which numbers have appeared and mark them
        boolean[][][] bingoTables3DBoolArray = new boolean[matrices][rows][cols];

        // Iterate over the 3D int array and mark any that are found from the bingo numbers in the 3D bool array
        mainLoop: 
        for(int round = 0; round < bingoNumsIntArray.length; round++) {
            for(int matrix = 0; matrix < matrices; matrix++) {
                for(int row = 0; row < rows; row++) {
                    for(int col = 0; col < cols; col++) {
                        if(bingoTables3DIntArray[matrix][row][col] == bingoNumsIntArray[round]) {
                            bingoTables3DBoolArray[matrix][row][col] = true;
                        }
                    }
                }
            }
            // Not possible to win until at least 5 numbers have been drawn
            if(round >= 4) {
                // Check the matrices after each draw, iterate over the columns of each matrix first
                for(int matrix = 0; matrix < matrices; matrix++) {
                    for(int row = 0; row < rows; row++) {
                        //Reset the counter after each column is checked
                        int colTruthCounter = 0;
                        for(int col = 0; col < cols; col++) {
                            if(bingoTables3DBoolArray[matrix][row][col] == true) {
                                colTruthCounter++;
                            }
                        }
                        if(colTruthCounter > 4) {
                            winningBingoMatrix = matrix;
                            winningBingoNumber = bingoNumsIntArray[round];
                            break mainLoop;
                        }
                    }
                    // Then iterate over each row of each matrix
                    for(int row = 0; row < rows; row++) {
                        //Reset the counter after each row is checked
                        int rowTruthCounter = 0;
                        for(int col = 0; col < cols; col++) {
                            if(bingoTables3DBoolArray[matrix][col][row] == true) {
                                rowTruthCounter++;
                            }
                        }
                        if(rowTruthCounter > 4) {
                            winningBingoMatrix = matrix;
                            winningBingoNumber = bingoNumsIntArray[round];
                            break mainLoop;
                        }
                    }
                }   
            }
        }
        
        // Calculate the value of the winning matrix * the winning bingo number
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(bingoTables3DBoolArray[winningBingoMatrix][row][col] == false) {
                    winningTotal += bingoTables3DIntArray[winningBingoMatrix][row][col];
                }
            }
        }
    
        System.out.print(winningTotal * winningBingoNumber);
    }
}