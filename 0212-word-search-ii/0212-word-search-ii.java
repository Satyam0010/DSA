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
        Node curr = root;
        int l = word.length();
        for(int i = 0; i < l ; i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null ){
                curr.children[idx] = new Node();
            }
            if(i == l-1){
                curr.children[idx].eow = true;
                curr.children[idx].word = word;
                }
            curr = curr.children[idx];
        }
    }
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(String w : words){
            insert(w);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                dfs(board,i,j,m,n,visited,root);
            }
        }
       return ans;
    }
    int[] ru = {-1,0,1,0};
    int[] cu = {0,-1,0,1};
    private void dfs(char[][] board,int i,int j,int m,int n,boolean[][] visited,Node curr){
       
        char ch = board[i][j];
        int idx = ch - 'a';

        if(curr.children[idx] == null) return;
            curr = curr.children[idx];
            visited[i][j] = true;

            if(curr.eow == true) {
                curr.eow = false;
                ans.add(curr.word);
            }

            for(int k = 0; k < 4;k++){
            int nr = i+ru[k];
            int nc = j+cu[k];
            if(nr > -1 && nr < m && nc > -1 && nc < n && visited[nr][nc] == false){
                dfs(board,nr,nc,m,n,visited,curr);
            }
        }
        visited[i][j] = false;
        return ;
    }
        
}