class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;
    private HashSet<Integer> set;
    private int smallest;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        smallest = 1;
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()){
            int ans = pq.poll();
            set.remove(ans);
            return ans;
        }

        int ans = smallest;
        smallest++;
        return ans;
    }
    
    public void addBack(int num) {
        if(num < smallest && !pq.contains(num)){
            pq.offer(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */