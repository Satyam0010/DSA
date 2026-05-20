class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            String s = String.valueOf(n);
            for(char c : s.toCharArray()){
                list.add(c-'0');
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length;i++){
            result[i]=list.get(i);
        }
        return result;
    }
}