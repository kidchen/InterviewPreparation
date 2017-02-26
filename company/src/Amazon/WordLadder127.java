/**
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

        1. Only one letter can be changed at a time.
        2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
        For example,

        Given:

        beginWord = "hit"

        endWord = "cog"

        wordList = ["hot","dot","dog","lot","log","cog"]

        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",

        return its length 5.

        Note:


        * Return 0 if there is no such transformation sequence.
        * All words have the same length.
        * All words contain only lowercase alphabetic characters.
        * You may assume no duplicates in the word list.
        * You may assume beginWord and endWord are non-empty and are not the same.
**/

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        // for the beginWord
        int result = 1;
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] letters = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (letters[j] != c) {
                            letters[j] = c;
                            String temp = new String(letters);
                            if (dict.contains(temp)) {
                                if (temp.equals(endWord)) {
                                    return result + 1;
                                }
                                queue.offer(temp);
                                dict.remove(temp);
                            }
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
