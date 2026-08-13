class Solution {
    class Node{
        char leftchar;
        char rightchar;
        int prefix;
        int suffix;
        int max;
        int length;
        Node(char ch){
            leftchar = ch;
            rightchar = ch;
            prefix = 1;
            suffix = 1;
            max = 1;
            length = 1;
        }
    }
    Node[] tree;
    public int[] longestRepeating(String s, String queryCh, int[] queryIn) {
        int len = s.length();
        tree = new Node[len*4];
        buildingTree(1,0,len-1,s);
        int k = queryIn.length;
        int[] result = new int[k];
        for(int i = 0; i < k;i++){
            int index = queryIn[i];
            char c = queryCh.charAt(i);
            update(1,0,len-1,index,c);
            result[i] = tree[1].max;
        }
        return result;
    }
    void buildingTree(int node,int start,int end,String s){
        if(start == end){
            tree[node] = new Node(s.charAt(start));
            return;
        }
        int mid = start + (end-start)/2;
        buildingTree(node*2,start,mid,s);
        buildingTree(node*2+1,mid+1,end,s);
        tree[node] = merge(tree[node*2],tree[node*2+1]);
    }
    Node merge(Node left,Node right){
        Node result = new Node(left.leftchar);
        result.leftchar = left.leftchar;
        result.rightchar = right.rightchar;
        result.length = left.length+right.length;
        result.prefix = left.prefix;
        if(left.prefix == left.length && left.rightchar == right.leftchar) result.prefix = left.length+right.prefix;
        result.suffix = right.suffix;
        if(right.suffix == right.length && left.rightchar == right.leftchar) result.suffix = right.length+left.suffix;

        result.max = Math.max(left.max,right.max);
        if(left.rightchar == right.leftchar) result.max = Math.max(result.max,left.suffix+right.prefix);
        return result;
    }
    void update(int node,int start,int end,int index,char ch){
        if(start == end){
            tree[node] = new Node(ch);
            return;
        }
        int mid = start + (end-start)/2;
        if(index <= mid) update(node*2,start,mid,index,ch);
        else update(node*2+1,mid+1,end,index,ch);
        tree[node] = merge(tree[node*2],tree[node*2+1]);
    }
}