class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0){
            int num = n%10;
            list.add(num);
            n /= 10;
        }
        Collections.sort(list,Collections.reverseOrder());
        int num1 = list.get(0);
        int num2 = list.get(1);
        return num1*num2;
    }
}