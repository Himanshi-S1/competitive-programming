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
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
    
       int noOfPP=petrolpumps.size();
       int i=0;
       boolean flag=false;
       while(i<noOfPP){
       int restp=0;
       for(int j=i;j<(i+noOfPP);j++){
           int pet = petrolpumps.get(j%noOfPP).get(0);
           int dis = petrolpumps.get(j%noOfPP).get(1);
           if((restp+pet)>=dis){
               restp=restp+pet-dis;
               flag=true;
           //continue;

           }else{
               flag=false;
               break;
           }
      }
       if(flag){
           return i;
       }
       i++;
       }
       return -1;
    }

}
