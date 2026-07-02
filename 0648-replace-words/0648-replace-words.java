class Solution {
    private class Node{
        Node[] children;
        boolean eow;
        String word;

        Node(){
            children = new Node[26];
            eow = false;
        }
    }

    Node root = new Node();
    private void insert(String word){
        int l = word.length();
        if(l == 0) return;
        Node curr = root;
        for(int i = 0; i < l;i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null) curr.children[idx] = new Node();
            if(i == l-1){
                curr.children[idx].eow = true;
                curr.children[idx].word = word;
            }
            curr = curr.children[idx];
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        int l = dict.size();
        for(int i = 0; i < l; i++){
            insert(dict.get(i));
        }
        StringBuilder sb = new StringBuilder();
        String[] s = sentence.trim().split("\\s+");
        for(String ss : s){
            sb = sb.append(search(ss)).append(" ");
        }
        return sb.toString().trim();
    }
    
    private String search(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null) return word;
            if(curr.children[idx] != null && curr.children[idx].eow == true) return curr.children[idx].word;
            if(curr.children[idx] != null ) curr = curr.children[idx]; 
        }
        return word;
    }
}