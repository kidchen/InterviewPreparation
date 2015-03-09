/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

// HashMap + bit manipulation: O(n) for traversing the string

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() < 10) {
            return result;
        }
        
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('G', 2);
        dict.put('T', 3);
        
        // initialize the seq (a 20 bits int)
        int seq = 0;
        for(int i = 0; i < 10; i++) {
            seq <<= 2;
            if(dict.containsKey(s.charAt(i))) {
                int cur = dict.get(s.charAt(i));
                seq += cur;
            } else {
                // invalid input
                return result;
            }
        }
        
        // find duplicates
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(seq, 1);
        int mask = 0xFFFFF;
        for(int i = 10; i < s.length(); i++) {
            seq <<= 2;
            if(dict.containsKey(s.charAt(i))) {
                int cur = dict.get(s.charAt(i));
                seq += cur;
            } else {
                // invalid input
                return result;
            }
            seq &= mask;
            if(map.containsKey(seq)) {
                map.put(seq, map.get(seq) + 1);
                if(map.get(seq) == 2) {
                    result.add(s.substring(i - 9, i + 1));
                }
            } else {
                map.put(seq, 1);
            }
        }
        return result;
    }
}
