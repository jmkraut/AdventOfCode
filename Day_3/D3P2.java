package AdventOfCode.Day_3;
import java.io.IOException;
import java.util.ArrayList;
import AdventOfCode.Helpers;

public class D3P2 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> oxygenList = Helpers.GenerateArrayListFromFile("AdventOfCode\\Day_3\\dataset.txt");
        ArrayList<String> co2List = new ArrayList<>();
        co2List.addAll(oxygenList);
        ArrayList<String> oxygenRemovalList = new ArrayList<>();
        ArrayList<String> co2RemovalList = new ArrayList<>();

        char[][] oxygenArray = Helpers.ConvertStringArrayListTo2DCharArray(oxygenList, oxygenList.size(), oxygenList.get(0).length());
        char[][] co2Array = Helpers.ConvertStringArrayListTo2DCharArray(co2List, co2List.size(), co2List.get(0).length());

        int oxygenRowLength = oxygenArray[0].length;
        int oxygenColumnLength = oxygenArray.length;

        for(int row = 0; row < oxygenRowLength; row++) {
            int bit1Counter = 0;
            int bit0Counter = 0;
            for(int col = 0; col < oxygenColumnLength; col++) {
                if(oxygenArray[col][row] == '1') {
                    bit1Counter++;
                } else {
                    bit0Counter++;
                }
            }
            if(bit1Counter >= bit0Counter) {
                if(oxygenList.size() > 1) {
                  for(String s : oxygenList) {
                        if(s.charAt(row) == '0') {
                            oxygenRemovalList.add(s);
                        }
                    }  
                }
            } else {
                if(oxygenList.size() > 1) {
                    for(String s : oxygenList) {
                          if(s.charAt(row) == '1') {
                              oxygenRemovalList.add(s);
                          }
                      }  
                  }
            }
            oxygenList.removeAll(oxygenRemovalList);
            oxygenArray = Helpers.ConvertStringArrayListTo2DCharArray(oxygenList, oxygenList.size(), oxygenList.get(0).length());
            oxygenRowLength = oxygenArray[0].length;
            oxygenColumnLength = oxygenArray.length;
        }

        int co2RowLength = co2Array[0].length;
        int co2ColumnLength = co2Array.length;

        for(int row = 0; row < co2RowLength; row++) {
            int bit1Counter = 0;
            int bit0Counter = 0;
            for(int col = 0; col < co2ColumnLength; col++) {
                if(co2Array[col][row] == '1') {
                    bit1Counter++;
                } else {
                    bit0Counter++;
                }
            }
            if(bit1Counter >= bit0Counter) {
                if(co2List.size() > 1) {
                  for(String s : co2List) {
                        if(s.charAt(row) == '1') {
                            co2RemovalList.add(s);
                        }
                    }  
                }
            } else {
                if(co2List.size() > 1) {
                    for(String s : co2List) {
                          if(s.charAt(row) == '0') {
                              co2RemovalList.add(s);
                          }
                      }  
                  }
            }
            co2List.removeAll(co2RemovalList);
            co2Array = Helpers.ConvertStringArrayListTo2DCharArray(co2List, co2List.size(), co2List.get(0).length());
            co2RowLength = co2Array[0].length;
            co2ColumnLength = co2Array.length;
        }
        System.out.println(Integer.parseInt(oxygenList.get(0), 2) * Integer.parseInt(co2List.get(0), 2));
    }
}
