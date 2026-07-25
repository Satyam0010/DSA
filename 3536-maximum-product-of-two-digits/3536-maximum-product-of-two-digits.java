class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        while(n > 0){
            int num = n%10;
            q.add(num);
            n /= 10;
        }
        int num1 = q.poll();
        int num2 = q.poll();
        return num1*num2;
    }
}