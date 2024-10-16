package Leetcode;

import java.util.*;

public class Problem49_GroupAnagram{
    public List<List<String>> groupAnagrams(String[] strs) {
        int N = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortedString = Arrays.toString(letters);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
