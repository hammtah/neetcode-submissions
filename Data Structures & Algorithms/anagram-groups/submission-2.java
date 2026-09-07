class Solution {
    public HashMap<Character, Integer> frequency(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        
        return freq;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            var list = groups.get(frequency(str));
            if (list == null) {
                groups.put(frequency(str), new ArrayList<>(List.of(str)));
            } else {
                list.add(str);
            }
        }

        List<List<String>> res = new ArrayList<>(groups.values());

        return res;
    }
}
