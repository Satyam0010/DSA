class Solution {
    class Node{
        Node[] children;
        Node(){
            children = new Node[2];
        }
    }

    Node root = new Node();


    public int findMaximumXOR(int[] nums) {
        for(int num : nums){
            insert(num);
        }
        int ans = 0;
        for(int num : nums){
            int xor = 0;
            Node curr = root;
            for(int i = 31; i > -1;i--){
                int bit = (num >> i) & 1;
                int sbit = 1 - bit;
                if(curr.children[sbit] != null){
                    curr = curr.children[sbit];
                    xor |= (1 << i);
                } else {
                    curr = curr.children[bit];
                }
                
            }

            ans = Math.max(xor,ans);
        }
        return ans;
    }

    private void insert(int num){
        Node curr = root;
        for(int i = 31; i > -1; i--){
            int n = (num >> i) & 1 ;
            if(curr.children[n] == null){
                curr.children[n] = new Node();
            }
            curr = curr.children[n];
        }
    }
}