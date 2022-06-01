import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {

    int n=q.size();
    int bribe = 0;
    
    List<Integer> temp=new ArrayList<Integer>();
    for(int i=0;i<n;i++){
        temp.add(i,i);
    }

    for(int i=0;i<n;i++){
        
          if(q.get(i)-1 ==temp.get(i)){
             //Good 
          } else if(q.get(i)-1 ==temp.get(i+1)){
              bribe++;
              Collections.swap(temp,i,i+1);
          } else if((q.get(i)-1 ==temp.get(i+2))){
              bribe += 2;
              Collections.swap(temp,i+2,i+1);
              Collections.swap(temp,i,i+1);
            } else{
            System.out.println("Too chaotic");
            return;
          }   
    }
    System.out.println(bribe);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> q = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qTemp[i]);
                q.add(qItem);
            }

            Result.minimumBribes(q);
        }

        bufferedReader.close();
    }
}
