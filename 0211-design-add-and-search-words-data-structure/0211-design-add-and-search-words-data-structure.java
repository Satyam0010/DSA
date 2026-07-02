class WordDictionary {

    private WordDictionary[] children;
    private boolean eow;

    public WordDictionary() {
        children = new WordDictionary[26];
        eow = false;
    }
    
    WordDictionary root = this;


    public void addWord(String word) {
        int l = word.length();
        WordDictionary curr = root;
        for(int i = 0; i < l ; i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null) curr.children[idx] = new WordDictionary();
            if(i == l-1) curr.children[idx].eow = true;
            curr = curr.children[idx];
        }
    }
    public boolean search(String word) {
       return helper(word,0,root);
    }

    private boolean helper(String word, int index, WordDictionary node){
        if(index == word.length()) return node.eow;

        char ch = word.charAt(index);

        if(ch == '.'){
            for(WordDictionary child : node.children){
                if(child != null && helper(word,index+1,child)) return true;
            }
            return false;
        } else {
        int idx = ch-'a';
        if(node.children[idx] == null) return false;

        return helper(word,index+1,node.children[idx]);
        }
        
}
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */