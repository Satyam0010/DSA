class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int len = s.length();
        int[] ch = new int[26];
        for (char c : s.toCharArray())
            ch[c - 'a']++;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int tar = target.charAt(i) - 'a';
            if (ch[tar] > 0) {
                ch[tar]--;
                if (check(ch, target, i + 1)) {
                    ans.append(target.charAt(i));
                    continue;
                }
                ch[tar]++;
            }

            for (int j = tar + 1; j < 26; j++) {
                if (ch[j] > 0) {
                    ans.append((char) (j + 97));
                    ch[j]--;
                    for (int k = 0; k < 26; k++) {
                        while (ch[k] > 0) {
                            ans.append((char) (k + 97));
                            ch[k]--;
                        }
                    }
                    return ans.toString();
                }
            }
            return "";
        }
        return "";
    }

    private boolean check(int[] ch, String target, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            while (ch[i] > 0){
                sb.append((char) (i + 97));
                ch[i]--;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            ch[sb.charAt(i) - 'a']++;
        }
        String tar = target.substring(start);
        return sb.toString().compareTo(tar) > 0;
    }
}