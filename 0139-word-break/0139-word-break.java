class Solution {
    static class Node{
        Node[] arr;
        boolean eow;
        Node(){
            arr = new Node[26];
            for(int i = 0; i < 26 ;i++){
                arr[i] = null;
            }
            eow = false;
        }
    }

    Node root = new Node();

     HashMap<String,Boolean> map = new HashMap<>();


    public boolean wordBreak(String s, List<String> words) {
        int l = words.size();
        for(int i = 0; i < l ; i++){
            String word = words.get(i);
            insert(word);
        }
        boolean ans = check(s);
        return ans;
        
    }


    private void insert(String word){
        int l = word.length();
        if(l == 0) return;

        Node curr = root;
        for(int i = 0; i < l ; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.arr[idx] == null){
                curr.arr[idx] = new Node();
            }
            if(i == l-1){
                curr.arr[idx].eow = true;
            }
            curr = curr.arr[idx];
        }
    }

    private boolean check(String word){
        if(word.length() == 0) return true;

       
        if(map.containsKey(word)){
            return map.get(word);
        }
        for(int i = 1; i <= word.length(); i++){
            String first = word.substring(0,i);
            String second = word.substring(i);
            if(search(first) && check(second)){
                map.put(word,true);
                return true;
            }
        }
        map.put(word,false);
        return false;
    }

    private boolean search(String word){
        Node node = root;
        for(int i = 0; i < word.length();i++){
            int idx = word.charAt(i) - 'a';
            Node curr = node.arr[idx];
            if(curr == null) {
                return false;
            }
            if(i == word.length()-1 && curr.eow == false){
                return false;
            }
            node = curr;
        }
        return true;
    }
}