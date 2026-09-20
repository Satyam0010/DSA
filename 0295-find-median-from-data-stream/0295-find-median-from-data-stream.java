class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num < max.peek()){
            max.offer(num);
        }
        else min.offer(num);

        if(max.size() > min.size()+1) min.offer(max.poll());
        else if(min.size() > max.size()) max.offer(min.poll());
    }
    
    public double findMedian() {
        if(min.size() == max.size()){
            return (min.peek() + max.peek())/2.0;
        }
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */