class Solution {
    public int countBinarySubstrings(String s) {

        char ch = s.charAt(0);
        int count =1;
        ArrayList<Integer>  n= new ArrayList<>();
        for(int i = 1; i < s.length();i++){
            char c = s.charAt(i);
            if(c == ch){
            count++;
            }
            else{
                n.add(count);
                ch = c;
                count = 1;
            }
        }

        n.add(count);

        int sum = 0;
        for(int i = 0; i < n.size()-1;i++){
            sum += Math.min(n.get(i),n.get(i+1));
        }

        return sum;
    }
}