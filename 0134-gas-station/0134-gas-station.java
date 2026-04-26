class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, tank = 0, start = 0;
        for(int i = 0 ; i < gas.length ; i++){
            int d = gas[i] - cost[i];
            sum += d;
            tank += d;
            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }
        return sum >= 0 ? start : -1;
    }
}