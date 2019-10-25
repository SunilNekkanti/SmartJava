import java.util.*;

public class WordBreakIII {

    public static List<String> getMinWords(String currentString, List<String> stringList) {
        return getMinWordsHelper(currentString, stringList, new LinkedHashMap<>());
    }

    private static List<String> getMinWordsHelper(String currentString, List<String> stringList, LinkedHashMap<String, List<String>> currentWordMap) {

        if (currentString == null || currentString.length() == 0) return new ArrayList<>();

        List<String> resultList = null;
        for (int i = 0; i < currentString.length(); i++) {
            String substring = currentString.substring(0, i + 1);
            if (stringList.contains(substring)) {
                List<String> restResult = getMinWordsHelper(currentString.substring(i + 1), stringList, currentWordMap);
                if (restResult != null) {
                    restResult.add(substring);
                    if (currentWordMap.get(currentString) != null) {
                        if (currentWordMap.get(currentString).size() > restResult.size()) {
                            currentWordMap.put(currentString, restResult);
                            resultList = restResult;
                        }
                    } else {
                        currentWordMap.put(currentString, restResult);
                        resultList = restResult;
                    }
                }
            }
        }
        currentWordMap.put(currentString, resultList);
        System.out.println(currentWordMap);
        return resultList;
    }




    public static List<String> wordBreak(String s, Set<String> allWordsSet) {

        LinkedHashMap<String, List<String>> map = new LinkedHashMap<String, List<String>>();

        List<String> result = new ArrayList<String>();

        for(int j=s.length()-1;j>=0;j--){

            if (map.containsKey(s))
                return map.get(s);

            if(allWordsSet.contains(s.substring(j))){
                break;
            }
            else{
                if(j==0){
                    return result;
                }
            }
        }

        for(int i=0; i < s.length() - 1; i++){

            if(allWordsSet.contains(s.substring(0,i+1))){

                List<String> strings = wordBreak(s.substring(i+1, s.length()), allWordsSet);

                if(strings.size() != 0){
                    for(String str : strings){
                        result.add(s.substring(0, i+1) + " " + str);
                    }
                }
            }
        }

        map.put(s,result);

        if(allWordsSet.contains(s)){
            result.add(s);
        }
        System.out.println(map);
        return result;
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.addAll(Arrays.asList("bed", "bath", "bat", "and", "hand", "bey", "beyand"));
        System.out.println(Arrays.toString(wordBreak("bedbathandbeyand", set).toArray()));
//        List<String> result2 = getMinWords("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
//        if (result2 == null) {
//            System.out.println("null");
//        }
    }
}