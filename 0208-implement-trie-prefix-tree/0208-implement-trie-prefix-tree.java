class Trie {
    Trie[] children;
    boolean eow;

    public Trie() {
        children = new Trie[26];
        eow = false;
    }

    public void insert(String word) {
        int l = word.length();
        if(l == 0) return;
        Trie curr = this;
        for(int i = 0; i < l ; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null)   curr.children[idx] = new Trie();
            if(i == l-1)    curr.children[idx].eow = true;
            curr = curr.children[idx];
        }
    }
    
    public boolean search(String word) {
        Trie curr = this;
        int l = word.length();
        for(int i = 0; i < l;i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null)   return false;
            if(i == l-1 && curr.children[idx].eow == false) return false;
            curr = curr.children[idx];
        }
        return true;
    }
    
    public boolean startsWith(String word) {
        Trie curr = this;
        int l = word.length();
        for(int i = 0; i < l;i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null)     return false;
            curr = curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */