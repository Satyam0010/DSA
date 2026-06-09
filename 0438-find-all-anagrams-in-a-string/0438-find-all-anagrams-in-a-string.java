class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int l1 = s.length();
        int l2 = p.length();
        if(l2 > l1) return ans;
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        for(int i = 0; i < l2; i++) {
            freqP[p.charAt(i) - 'a']++;
            freqS[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(freqP, freqS)) {
            ans.add(0);
        }

        for(int i = l2; i < l1; i++) {
            freqS[s.charAt(i) - 'a']++;
            freqS[s.charAt(i - l2) - 'a']--;

            if(Arrays.equals(freqP, freqS)) {
                ans.add(i - l2+ 1);
            }
        }

        return ans;
    }
}