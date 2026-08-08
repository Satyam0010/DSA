class Solution {
    public int[] validSequence(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[] suff = new int[l1+1];
        int j = l2-1;
        for(int i = l1-1;i >= 0;i--){
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)) j--;
            suff[i] = l2-j-1;
        }

        int result[] = new int[l2];
        int k = 0;
        j = 0;
        boolean used = false;
        for(int i = 0; i < l1 && k < l2;i++){
            if(word1.charAt(i) == word2.charAt(j)){
                result[k++] = i;
                j++;
            } else if(!used && suff[i+1] >= l2-j-1){
                result[k++] = i;
                j++;
                used = true;
            }
        }
        return k == l2 ? result : new int[0];
    }
}