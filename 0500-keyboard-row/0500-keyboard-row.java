class Solution {
    public String[] findWords(String[] words) {
        
        int[] map = new int[26];

        for(char c : "qwertyuiop".toCharArray()){
            map[c-'a'] = 1;
        }
        for(char c : "asdfghjkl".toCharArray()){
            map[c-'a'] = 2;
        }
        for(char c : "zxcvbnm".toCharArray()){
            map[c-'a'] = 3;
        }

        List<String> ans = new ArrayList<>();
        for(String n : words){
            String check = n.toLowerCase();

            int row = map[check.charAt(0)-'a'];
            boolean v = true;
            for(int i = 1 ; i < check.length() ; i++){
                char ch = check.charAt(i);
                if(map[ch-'a'] != row){
                    v = false;
                    break;
                }
            }
            if(v){
                ans.add(n);
            }
        }

        return ans.toArray(new String[0]);
    }
}