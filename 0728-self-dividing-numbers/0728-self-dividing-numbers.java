class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left ; i <= right ; i++){
            if(check(i)){
                list.add(i);
            }
        }
        return list;
    }

    boolean check(int num){
        int org = num;
        while(num > 0){
            int d = num%10;
            if(d == 0){
                return false;
            }
            else if(org%d != 0){
                return false;
            }
            num /= 10;
        }
        return true;
    }
}