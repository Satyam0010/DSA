class Solution {
    public boolean detectCapitalUse(String word) {
        int l = word.length();
        int capital = 0;
        for(int i = 0; i < l; i++){
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z') capital++;
        }
        if(capital == l || capital == 0) return true;
        else if(capital == 1 && (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')) return true;
        return false;
    }
}