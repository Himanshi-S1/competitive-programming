/*
In operating systems that use paging for memory management, page replacement algorithm is needed to decide which page needs to be replaced when the new page comes in.
Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page.
Given a sequence of pages in an array pages[] of length N and memory capacity C, find the number of page faults using Least Recently Used (LRU) Algorithm. 

Example 1:
Input: N = 9, C = 4
pages = {5, 0, 1, 3, 2, 4, 1, 0, 5}
Output: 8
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        }
    }
}
// } Driver Code Ends

class Solution{
    static int pageFaults(int N, int C, int pages[]){
        // code here
        int count=0;
        
        List<Integer> l =new ArrayList<Integer>();

        for(int i=0;i<pages.length;i++){
    
                if(!l.contains(pages[i])){
                    if(l.size()<C){
                        l.add(pages[i]);
                    }else{
                        l.remove(0);
                        l.add(pages[i]);
                    }
                    count++;
                }else{
                    l.remove(new Integer(pages[i]));
                    l.add(pages[i]);
                }
                
                // System.out.println(l);
                
            }
            return count;
            
    }
}
