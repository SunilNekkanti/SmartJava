import java.util.*;
import java.util.LinkedList;

public class WordLadder {

    private static boolean isAdjacent(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return count == 1;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> allWordsSet = new HashSet<>(wordList);
        Set<String> visitedWordSet = new HashSet<>();

        Queue<String> wordTransitionChain = new LinkedList<String>();
        Map<String, Integer> wordTransitionPosition = new LinkedHashMap<>();

        wordTransitionChain.offer(beginWord);
        wordTransitionPosition.put(beginWord, 1);

        while (!wordTransitionChain.isEmpty()) {

            String word1 = wordTransitionChain.remove();
            //Compare word1 with all other given words
            for (String word2: allWordsSet) {
                //If the word is not in visited words and is adjacent
                if (!visitedWordSet.contains(word2) && isAdjacent(word1, word2)) {

                    wordTransitionChain.offer(word2);
                    wordTransitionPosition.put(word2,wordTransitionPosition.get(word1)+1);
                    visitedWordSet.add(word2);

                    // if reached final word
                    if (word2.equals(endWord)) {
                        System.out.println(wordTransitionPosition);
                        return wordTransitionPosition.get(word2);
                    }
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) {

        String[] words = {"hot","dot","dog","lot","log","cog", "penta"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(ladderLength("hit", "cog", wordList));

    }
}
