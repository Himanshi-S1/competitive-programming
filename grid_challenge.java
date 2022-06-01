import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {

    int n=grid.size();
    
    //maximum length of string present in grid
    int maxLen=0;
    
    //rearrange row alphabetically
    for(int i=0;i<n;i++){
        String str = grid.get(i);
        char[] chArray=str.toCharArray();
        Arrays.sort(chArray);
        str = String.valueOf(chArray);
        grid.remove(i);
        grid.add(i,str);
        if(str.length()>maxLen){
            maxLen=str.length();
        }
    }
    System.out.println(grid);
    
    for(int i=0;i<maxLen;i++){
    int minn=Integer.MIN_VALUE;

        for(int j=0;j<n;j++){
            String str = grid.get(j);
            if(i<str.length()){
            char ch=str.charAt(i);
            int in=ch;
            if(minn<=in){
                minn=in;
            }else{
                return "NO";
            }
            }
        }
    }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
