import java.util.*;
import java.util.stream.Collectors;

public class ReOrderingLines {

     static List<String> reorderLines(int logFileSize, List<String> logfile){

//        List<String> sortedWordList = logfile.stream()
//                                  .filter(num -> !(num.split(" ")[1]).chars().allMatch(Character::isDigit))
//                                  .sorted(Comparator.comparing( firstWord ->  firstWord.split(" ")[1]))
//                                  .collect(Collectors.toList());
//
//        List<String> numberList = logfile.stream()
//                .filter(num -> (num.split(" ")[1]).chars().allMatch(Character::isDigit))
//                .collect(Collectors.toList());
//
//         System.out.println(logfile.stream()
//                 .collect(Collectors.partitioningBy(num -> !(num.split(" ")[1]).chars().allMatch(Character::isDigit))));
//
//        sortedWordList.addAll(numberList);

         List<String> sortedWordList = logfile;

         List<String> numbersList = new ArrayList<String>();
         List<String> wordsList = new ArrayList<String>();

         for(String e:logfile){
             if(e.split(" ")[1].matches("-?\\d+(\\.\\d+)?")){
                 numbersList.add(e);
             }
             else {
                 wordsList.add(e);
             }
         }


         wordsList.sort(new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {


                 String identifier_1 = o1.split(" ")[0];
                 String identifier_2 = o2.split(" ")[0];

                 String o1_firststring = o1.split(" ")[1];
                 String o2_firststring = o2.split(" ")[1];

                 String o1_wholestring = o1.split(" ", 2)[1];
                 String o2_wholestring = o2.split(" ", 2)[1];


                 if(o1_wholestring.equals(o2_wholestring)){
                     return identifier_1.compareTo(identifier_2);
                 }

                 else{
                     return o1_firststring.compareTo(o2_firststring);
                 }


             }
         });

         wordsList.addAll(numbersList);
        return wordsList;
    }



    public static void main(String[] f){

     int logFileSize = 5;
     List<String> loglines =  Arrays.asList("a1 9 2 3 1",
                                            "g1 Act Car",
                                             "pz ruki huki",
                                             "zo4 4 7",
                                             "ab1 off KEY dog",
                                             "a8 act zoo",
              "a8 bat cat",
             "z04 99 88",
             "lz loki maki");

        List<String> sorted = reorderLines(logFileSize, loglines);

        for(String t: sorted){
            System.out.println(t);
        }

    }

}
