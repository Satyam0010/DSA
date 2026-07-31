class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String s = "123456789";
        for(int i = 2; i <= 9;i++){
            for(int j = 0;j <= s.length()-i;j++){
                String sb = s.substring(j,j+i);
                int num = Integer.parseInt(sb);
                if(num >= low && num <= high) list.add(num);
            }
        }
        return list;
    }
}