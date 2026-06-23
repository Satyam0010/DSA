class Solution {
    public boolean backspaceCompare(String s, String t) {
        int l1 = s.length()-1;
        int l2 = t.length()-1;
        while(l1 >= 0 || l2 >= 0){
            int count1 = 0;
            while(l1 >= 0){
                if(s.charAt(l1) == '#'){
                    count1++;
                    l1--;
                }else if(count1 > 0){
                    count1--;
                    l1--;
                }else
                break;
            }
            int count2 = 0;
            while(l2 >= 0){
                if(t.charAt(l2) == '#'){
                    count2++;
                    l2--;
                }else if(count2 > 0){
                    count2--;
                    l2--;
                }else
                break;
            }
            if(l1 >= 0 && l2 >= 0 && s.charAt(l1) != t.charAt(l2)) return false;
            if((l1 >= 0) != (l2 >= 0 )) return false;
            l1--;
            l2--;
        }
            return true;
        }
    }