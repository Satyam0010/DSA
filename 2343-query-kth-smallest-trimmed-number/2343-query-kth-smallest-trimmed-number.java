class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        for(int i = 0 ; i < n;i++){
            int trim = queries[i][1];
            int k = queries[i][0];
            result[i] = find(nums,trim,k);
        }
        return result;
    }

    private int find(String[] nums,int trim,int k){
        int n = nums.length;
        String[][] arr = new String[n][2];

        for(int i = 0;i < n ; i++){
            String trimmed = nums[i].substring(nums[i].length()-trim);
            arr[i][0] = trimmed;
            arr[i][1] = String.valueOf(i);
        }
        Arrays.sort(arr,(a,b) -> {
            int cm = a[0].compareTo(b[0]);
            if(cm != 0) return cm;
            return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
        });
        return Integer.parseInt(arr[k-1][1]);
    }
}