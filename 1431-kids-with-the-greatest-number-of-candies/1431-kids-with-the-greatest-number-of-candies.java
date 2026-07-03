class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int ec) {
        int max = Integer.MIN_VALUE;
        for(int num : candies){
            if(num >= max) max = num;
        }

        List<Boolean> list = new ArrayList<>();

        for(int num : candies){
            if((num+ec) >= max) list.add(true);
            else list.add(false);
        }
        return list;
    }
}