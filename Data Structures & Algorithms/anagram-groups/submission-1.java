class Solution {
    public HashMap<Character, Integer> frequency(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            var key = Character.valueOf(c);
            var val = freq.get(Character.valueOf(c)) == null ?1:freq.get(Character.valueOf(c))+1;
            freq.put(key, val);
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
                groups.put(frequency(str), list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (HashMap<Character, Integer> key : groups.keySet()){
            res.add(groups.get(key));
        }

        return res;
    }
}
