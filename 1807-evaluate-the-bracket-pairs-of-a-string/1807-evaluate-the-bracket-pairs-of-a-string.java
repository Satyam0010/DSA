class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> pair : knowledge){
            String key = pair.get(0);
            String value = pair.get(1);
            map.put(key,value);
        }
        StringBuilder sb = new StringBuilder(),
                      ans = new StringBuilder();
        boolean flag = false;
        for(char c : s.toCharArray()){
            if(c == '(') flag = true;
            else if(c == ')'){
                flag = false;
                ans.append(map.getOrDefault(sb.toString(),"?"));
                sb.setLength(0);
            }
            else{
                if(flag) sb.append(c);
                else ans.append(c);
            }
        }
        return ans.toString();
    }
}