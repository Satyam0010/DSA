class Solution {
    public List<String> validateCoupons(String[] code, String[] bl, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        List<String> ele = new ArrayList<>();
        List<String> gro = new ArrayList<>();
        List<String> pha = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int n = code.length;
        for(int i = 0; i < n;i++){
            if(code[i].isEmpty() || isActive[i] == false) continue;
                boolean valid = true;
                for(char ch : code[i].toCharArray()){
                if(!((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90) || (ch >= 48 && ch <= 57) || ch == '_')){
                    valid = false;
                    break;
                }
                }
                if(!valid) continue;
                if(bl[i].equals("electronics")) ele.add(code[i]);
                if(bl[i].equals("grocery")) gro.add(code[i]);
                if(bl[i].equals("pharmacy")) pha.add(code[i]);
                if(bl[i].equals("restaurant")) res.add(code[i]);
            }
        Collections.sort(ele);
        Collections.sort(gro);
        Collections.sort(pha);
        Collections.sort(res);
        ans.addAll(ele);
        ans.addAll(gro);
        ans.addAll(pha);
        ans.addAll(res);
        return ans;
    }
}