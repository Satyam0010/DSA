class Solution {
    public boolean canBeEqual(String s1, String s2) {

        String ss = s1;
        if(s1.equals(s2)){
            return true;
        }
        char[] ar = s1.toCharArray();
        s1 = change1(ar);
        if(s1.equals(s2)){
            return true;
        }
        s1 = change2(ar);
        if(s1.equals(s2)){
            return true;
        }

        char[] arr = ss.toCharArray();
        s1 = change2(arr);
        if(s1.equals(s2)){
            return true;
        }


        return false;
    }

    String change1(char[] ar){
        char temp = ar[0];
        ar[0] = ar[2];
        ar[2] = temp;
        return new String(ar);
    }

    String change2(char[] ar){
        char temp = ar[1];
        ar[1] = ar[3];
        ar[3] = temp;
        return new String(ar);
    }
}