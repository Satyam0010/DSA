class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        int left = 0;
        int right = products.length -1;

        for(int i = 0; i < searchWord.length() ; i++){
            char c = searchWord.charAt(i);

            while(left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) left++;
            while(left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) right--;

            List<String> current = new ArrayList<>();
            for(int j = 0; j < 3 && left + j <= right ; j++){
                current.add(products[left+j]);
            }

            ans.add(current);
        }

        return ans;
    }
}