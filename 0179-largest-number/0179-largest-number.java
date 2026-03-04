class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0 ; i < nums.length;i++){
            s[i] = nums[i]+"";
        }
       Arrays.sort(s,(a,b)-> (b+a).compareTo(a+b));
       if(s[0].equals("0"))
       return "0";

       StringBuilder sb = new StringBuilder();
       for(String sa : s){
        sb.append(sa);
       }

       return sb.toString();
       }
}