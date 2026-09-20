class Solution {
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        List<Integer> result = new ArrayList<>();
        int[] ch = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            ch[c - 'a'] = i;
        }
        int i = 0, start = 0, end = 0;
        while (i < length) {
            end = Math.max(end, ch[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
            i++;

        }
        return result;
    }
}