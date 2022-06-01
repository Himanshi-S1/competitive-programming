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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    k=k%26;
    int n=s.length();
    String ans="";
     for(int i=0;i<n;i++){
         char ch=s.charAt(i);
         int in=ch;
         //Uppercase
         if(in>=65 && in<=90){
             in=in+k;
             if(in>90){
                 in=in+64-90;
             }
         }
         //Lowercase
         if(in>=97 && in<=122){
             in=in+k;
             if(in>122){
                 in=in+96-122;
             }
         }
    ans=ans+(char)in;
    }
      return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
