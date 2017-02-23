package LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by czhang on 11/22/16.
 */
public class ShortestWordDistanceII244 {
  /**
   * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your
   * method will be called repeatedly many times with different parameters. How would you optimize it?
   * 
   * Design a class which receives a list of words in the constructor, and implements a method that takes two words
   * word1 and word2 and return the shortest distance between these two words in the list.
   * 
   * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
   * 
   * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
   * 
   * 
   * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
   */

  public class WordDistance {

    Map<String, List<Integer>> map = new HashMap<>();
    int maxLength;

    public WordDistance(String[] words) {
      if (words != null && words.length > 0) {
        maxLength = words.length - 1;
        for (int i = 0; i < words.length; i++) {
          if (!map.containsKey(words[i])) {
            List<Integer> list = new ArrayList<>();
            map.put(words[i], list);
          }
          map.get(words[i]).add(i);
        }
      }
    }

    public int shortest(String word1, String word2) {
      if (map.isEmpty() || word1.equals(word2)) {
        return 0;
      }
      List<Integer> word1Pos = map.get(word1);
      List<Integer> word2Pos = map.get(word2);
      int distance = maxLength;
      int i = 0, j = 0;
      while (i < word1Pos.size() && j < word2Pos.size()) {
        distance = Math.min(distance, Math.abs(word1Pos.get(i) - word2Pos.get(j)));
        if (word1Pos.get(i) < word2Pos.get(j)) {
          i++;
        } else {
          j++;
        }
      }
      return distance;
    }
  }

  // Your WordDistance object will be instantiated and called as such:
  // WordDistance wordDistance = new WordDistance(words);
  // wordDistance.shortest("word1", "word2");
  // wordDistance.shortest("anotherWord1", "anotherWord2");
}
