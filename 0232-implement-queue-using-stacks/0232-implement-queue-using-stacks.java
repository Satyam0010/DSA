import java.util.Stack;
class MyQueue {
    private Stack <Integer> one;
    private Stack<Integer> two;


    public MyQueue() {
        one = new Stack<>();
        two = new Stack<>();
    }
    
    public void push(int x) {
        one.push(x);
    }
    
    public int pop() {
        while(!one.isEmpty()){
            two.push(one.pop());
        }

        int rem = two.pop();

        while(!two.isEmpty()){
            one.push(two.pop());
        }
        return rem;
    }
    
    public int peek() {
         while(!one.isEmpty()){
            two.push(one.pop());
        }

        int peeked = two.peek();

        while(!two.isEmpty()){
            one.push(two.pop());
        }
        return peeked;
    }
    
    public boolean empty() {
        return one.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */