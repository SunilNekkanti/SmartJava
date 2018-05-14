import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReOrderingLines {

     static List<String> reorderLines(int logFileSize, List<String> logfile){

        List<String> sortedWordList = logfile.stream()
                                  .filter(num -> !(num.split(" ")[1]).chars().allMatch(Character::isDigit))
                                  .sorted(Comparator.comparing( firstWord ->  firstWord.split(" ")[1]))
                                  .collect(Collectors.toList());

        List<String> numberList = logfile.stream()
                .filter(num -> (num.split(" ")[1]).chars().allMatch(Character::isDigit))
                .collect(Collectors.toList());

         System.out.println(logfile.stream()
                 .collect(Collectors.partitioningBy(num -> !(num.split(" ")[1]).chars().allMatch(Character::isDigit))));

        sortedWordList.addAll(numberList);

        return sortedWordList;
    }


    public static void main(String[] f){

     int logFileSize = 5;
     List<String> loglines =  Arrays.asList("a1 9 2 3 1",
                                            "g1 Act Car",
                                             "zo4 4 7",
                                             "ab1 off KEY dog",
                                             "a8 act zoo");

        List<String> sorted = reorderLines(logFileSize, loglines);

        for(String t: sorted){
            System.out.println(t);
        }

    }

}
