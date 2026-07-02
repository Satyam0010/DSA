class Solution {
    class Node{
        Node[] children;
        boolean eow ;
        Node(){
            children = new Node[26];
            eow = false;
        }
    }
    Node root = new Node();

    HashMap<String, List<String>> map = new HashMap<>();


    public List<String> wordBreak(String s, List<String> word) {
        int l = word.size();
        for(int i = 0; i < l;i++){
            insert(word.get(i));
        }
        return check(s);
        
    }

    private void insert(String w){
        int l = w.length();
        if(l == 0) return;
        Node curr = root;
        for(int i = 0; i < l;i++){
            int idx = w.charAt(i)-'a';
            if(curr.children[idx] == null) curr.children[idx] = new Node();
            if(i == l-1) curr.children[idx].eow = true;
            curr = curr.children[idx];
        }
    }

    private boolean search(String word){
        int l = word.length();
        Node curr = root;
        for(int i = 0; i < l; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) return false;
            if(i == l-1 && curr.children[idx].eow == false) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    private List<String> check(String word){

        if(map.containsKey(word)){
            return map.get(word);
        }

        List<String> ans = new ArrayList<>();

        if(word.isEmpty()){
            ans.add("");
            return ans;
        }

        
        for(int i = 1; i <= word.length() ; i++){
            String first = word.substring(0,i);

            if(search(first)){
                String second = word.substring(i);
                List<String> curr = check(second);
                for(String ss : curr){
                    if(ss.isEmpty()){
                        ans.add(first);
                    } else {
                        ans.add(first + " " + ss);
                    }
                }
            }
           
        }  
    map.put(word,ans);
        return ans;
    }
}