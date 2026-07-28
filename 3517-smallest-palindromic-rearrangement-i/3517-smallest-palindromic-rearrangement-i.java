class Solution {
    public String smallestPalindrome(String s) {
        int l = s.length();
        if(l == 1) return s;
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i = 0; i < l;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        StringBuilder front = new StringBuilder();
        char middle = '\0';
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            char ch = entry.getKey();
            for(int i = 0; i < freq/2;i++){
                front.append(ch);
            }
            if(freq%2 == 1) middle = ch;
        }
        StringBuilder ans = new StringBuilder();
        ans.append(front);
        if(middle != '\0'){
            ans.append(middle);
        }
        ans.append(new StringBuilder (front).reverse());
        return ans.toString();
    }
}