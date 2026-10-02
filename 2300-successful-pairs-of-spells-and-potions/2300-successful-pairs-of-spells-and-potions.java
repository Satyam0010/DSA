class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i = 0; i < n; i++){
            int low = 0, high = m-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                long pro = (long)spells[i]*potions[mid];
                if(pro < success) low = mid + 1;
                else{
                    ans[i] = m-mid;
                    high = mid-1;
                }
            }
        }

        return ans;
    }
}