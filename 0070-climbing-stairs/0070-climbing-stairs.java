class Solution {

    HashMap<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return check(n);
    }
    private int check(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(map.containsKey(n)) return map.get(n);
        int num = check(n-1)+check(n-2);
        map.put(n,num);
        return num;
    }
}