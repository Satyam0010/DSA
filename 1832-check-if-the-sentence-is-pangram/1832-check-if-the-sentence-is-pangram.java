class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] ch = new int[26];
        for(char c : sentence.toCharArray()){
            if(ch[c-'a'] != 1) ch[c-'a'] = 1;
        }
        for(int num : ch){
            if(num == 0) return false;
        }
        return true;
    }
}