class Solution {
    public boolean setSame(Set<Character> set1, Set<Character> set2) {
        if (set1.size() != set2.size()) {
            return false;
        }
        for (Character ch : set1) {
            if (!set2.contains(ch))
                return false;
        }
        return true;
    }
    public int similarPairs(String[] words) {
        int ans = 0;
        List<Set<Character>> list = new ArrayList<>();
        for (String s : words) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            list.add(set);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (setSame(list.get(i), list.get(j)))
                    ans++;
            }
        }
        return ans;
    }
}