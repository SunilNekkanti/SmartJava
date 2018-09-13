import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

class DeletionDistance {

  static int deletionDistance(String str1, String str2) {

    char[] ch1 = str1.toCharArray();

    char[] ch2 = str2.toCharArray();

    if (ch1.length == 0 && ch2.length == 0){
        return 0;
    }
    else if (ch1.length == 0){
        return str2.length();
    }
    else if (ch2.length == 0){
        return  str1.length();
    }
    int[][] memo = new int[ch1.length+1][ch2.length+1];
    for(int i = 0; i <= ch1.length; i++)
        for(int j = 0; j <= ch2.length; j++){

            if(i==0 && j ==0 )  {
                memo[i][j]= 0;
            }
         else if(i==0)  {
             memo[i][j]= j;
         }
         else if(j==0) {
                memo[i][j]= i;
            }

         else if(  ch1[i-1] == ch2[j-1]){

                 memo[i][j] = memo[i - 1][j - 1];
         }
         else{
                 memo[i][j] = Math.min(memo[i - 1][j - 1]+2, Math.min(memo[i - 1][j]+1, memo[i][j - 1]+1)) ;
             }
         }

      Stream.of(memo).map(Arrays::toString).forEach(System.out::println);
      return memo[ch1.length][ch2.length];
  }


  public static void main(String[] args) {

      System.out.println(deletionDistance( "fat","cat"));

  }

}

//             b  l  o  o  p  e  r  s
//         [0, 1, 2, 3, 4, 5, 6, 7, 8]
//       l [1, 2, 1, 2, 3, 4, 5, 6, 7]
//       o [2, 3, 2, 1, 2, 3, 4, 5, 6]
//       o [3, 4, 3, 2, 1, 2, 3, 4, 5]
//       p [4, 5, 4, 3, 2, 3, 4, 5, 6]