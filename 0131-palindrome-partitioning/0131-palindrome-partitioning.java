class Solution {
    int length;
    public List<List<String>> partition(String s) {
        length = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        check(s,0,curr,result);
        return result;
    }

    private void check(String s, int index, List<String> curr, List<List<String>> result){
        if(index == length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < length;i++){
            if(isPalindrome(s,index,i)){
                curr.add(s.substring(index,i+1));
                check(s,i+1,curr,result);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}