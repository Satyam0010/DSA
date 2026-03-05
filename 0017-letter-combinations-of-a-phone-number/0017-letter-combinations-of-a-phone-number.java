class Solution {

    static String[] map = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
        };


    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
        return new ArrayList<>();
        }

        return pad("",digits);
        
    }

    static ArrayList<String> pad(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }


        int d = up.charAt(0)-'0';

        ArrayList<String> ans = new ArrayList<>();


       

        String letters = map[d];

        for(int i = 0; i < letters.length(); i++){

        char ch = letters.charAt(i);

        ans.addAll(pad(p + ch, up.substring(1)));

        }

        return ans;
    }

}