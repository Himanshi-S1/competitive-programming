// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{

    public String removeConsecutiveCharacter(String S){

        //Base Case
        if(S.length()==0 || S.length()==1){
            return S;
        }
        
        int flag=0;
        int start=0;
        int count=0;
        
        for(int i=0;i<S.length()-1;i++){
            
            if(S.charAt(i)==S.charAt(i+1)){
                if(flag==0){
                    start=i;
                    count++;
                    flag=1;
                }else{
                    count++;
                }
            }
            
            else{
                if(flag==1){
                    break;
                }
            }
        }
        
        
        if(flag==1){
        for(int i=0;i<count;i++){
            S=S.substring(0, start) + S.substring(start+1);;
        }
        // System.out.println(S);
        return removeConsecutiveCharacter(S);
        }
        else{
            return S;
        }
    }
}
